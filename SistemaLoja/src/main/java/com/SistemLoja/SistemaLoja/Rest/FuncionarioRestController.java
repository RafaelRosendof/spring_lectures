package com.SistemLoja.SistemaLoja.Rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.SistemLoja.SistemaLoja.Service.FuncionarioService;
import com.SistemLoja.SistemaLoja.Entity.FuncionarioEntity;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioRestController {
    
    private FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioRestController(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }

    //métodos a vontade agora 
    /*
     * exemplo de um 
     *     @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    lembrar de manipular isso no postman e usar o navegador para visualizar
     */

     @GetMapping("/Listfuncionarios")
     public List<FuncionarioEntity> findAll(){
         return funcionarioService.findAll();
     }

     @GetMapping("/funcionarios/{funcionarioId}")
     public FuncionarioEntity getFuncionario(@RequestBody int funcionarioId){
         FuncionarioEntity funcionario = funcionarioService.findById(funcionarioId);

         if(funcionario == null){
             throw new RuntimeException("Funcionario não encontrado - " + funcionarioId);
         }

         return funcionario;

     }

    @PostMapping("/adicionarFuncionario")
    public FuncionarioEntity addFunc(@RequestBody FuncionarioEntity funcionario){
        funcionarioService.CriarFuncionario(funcionario);
        return funcionario;
    }

    


}