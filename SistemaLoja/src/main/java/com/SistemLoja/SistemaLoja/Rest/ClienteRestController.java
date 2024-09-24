package com.SistemLoja.SistemaLoja.Rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.SistemLoja.SistemaLoja.Entity.ClienteEntity;
import com.SistemLoja.SistemaLoja.Service.ClienteService;
@RestController
@RequestMapping("/cliente")
public class ClienteRestController{

    private ClienteService clienteService;

    @Autowired
    public ClienteRestController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    /*
     * Segue o mesmo exemplo, lembrar de testar no postman e no navegador
     * 
     *     @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    para deletar é o 
    @DeleteMapping("/employees/{employeeId}")
     * 
     */
}