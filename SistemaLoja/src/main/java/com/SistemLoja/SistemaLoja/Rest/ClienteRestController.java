package com.SistemLoja.SistemaLoja.Rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.math.BigDecimal;

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

    @DeleteMapping("/deletaCliente/{clienteId}")
    public void deleteCliente(@RequestParam int clienteId){
        ClienteEntity cliente = clienteService.findById(clienteId);

        if(cliente == null){
            throw new RuntimeException("Cliente não encontrado - " + clienteId);
        }
        clienteService.deleteById(clienteId);
    }

    @GetMapping("/ListClientes")
    public List<ClienteEntity> findAll(){
        return clienteService.findAll();
    }

    @GetMapping("/cliente/{clienteId}")
    public ClienteEntity getCliente(@RequestParam int clienteId){
        ClienteEntity cliente = clienteService.findById(clienteId);

        if(cliente == null){
            throw new RuntimeException("Cliente não encontrado - " + clienteId);
        }

        return cliente;

    }

    @PostMapping("/updateCliente")
    public ClienteEntity updateCliente(@RequestParam ClienteEntity cliente){
        clienteService.updateCliente(cliente);
        return cliente;
    }

    @PostMapping("/adicionarCliente")
    public ClienteEntity addCliente(@RequestParam ClienteEntity cliente){
        clienteService.CriarCliente(cliente);
        return cliente;
    }

   @GetMapping("/findSaldo")
   public BigDecimal findSaldo(@RequestParam int id){
       return clienteService.findSaldo(id);
   } 
    

}