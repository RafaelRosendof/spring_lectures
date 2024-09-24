package com.SistemLoja.SistemaLoja.Rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.SistemLoja.SistemaLoja.Service.FuncionarioService;

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

}