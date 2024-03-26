package com.exemple.meu_todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Código responsável para tratar com os paths e mostrar todos os status
 * Método get put post e delete, aqui se encontra todos os métodos 
 * com o tratamento das exceções e muito mais 
 */


@RestController
@RequestMapping("/api/todos")
public class TodoController{
    private final TodoRepo todoRepo;

    @Autowired
    public TodoController(TodoRepo todoRepo){
        this.todoRepo = todoRepo;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllTodos(){
        try{
            List<Todo> todos = todoRepo.findAll();
            return ResponseEntity.ok(new ApiResponse(true, "Recebido com sucesso", todos)); 
        }catch( Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(false, "Deu algo de errado \n", todoRepo));
        }
    }

    @GetMapping("/{id}")
   public ResponseEntity<ApiResponse> getTodoById(@PathVariable Long id){
    try{
        Todo todo = todoRepo.findById(id).orElseThrow(() -> new Arquivo_not_found("Todo não foi achado pelo ID" + id));
        return ResponseEntity.ok(new ApiResponse(true, "Todo Recebido com muito sucesso ", todo));

    }catch(Arquivo_not_found e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "Erro pegar o todo com o id" + id, null));

    }
   } 

   @PostMapping
   public ResponseEntity<ApiResponse> createTodo(@RequestBody Todo todo){
    try{
        Todo createTodo = todoRepo.save(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, "TODO criado com sucesso", createTodo));

    }catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(false, "Deu erro em criar o todo", null));
        
    }
   }    

   @PostMapping("/{id}")
    public ResponseEntity<ApiResponse> updateTodo(@PathVariable Long id , @RequestBody Todo todoDetails){
        try{
            Todo todo = todoRepo.findById(id).orElseThrow(() -> new Arquivo_not_found("Todo não achado com o id " + id));

            todo.setTitulo(todoDetails.getTitulo());
            todo.setCompleto(todoDetails.getCompleto());

            Todo updateTodo = todoRepo.save(todo);

            return ResponseEntity.ok(new ApiResponse(false, "N]ao conseguiu atualizar o todo com id"+ id, null));
        }catch(Arquivo_not_found e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "Não conseguiu atualizar o todo com o id " + id, null));
        }
    } 

  @DeleteMapping("/{id}")
  public ResponseEntity<ApiResponse> deleteTodo(@PathVariable Long id){
    try{
        Todo todo = todoRepo.findById(id).orElseThrow(() -> new Arquivo_not_found("Todo não achado com o id" + id));
        todoRepo.delete(todo);

        return ResponseEntity.ok(new ApiResponse(true , "Conseguiu remover com sucesso ", null));
    }catch(Arquivo_not_found e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "Não conseguiu deletar pois não achou o id " + id, null));
    }
  } 
    
    
}