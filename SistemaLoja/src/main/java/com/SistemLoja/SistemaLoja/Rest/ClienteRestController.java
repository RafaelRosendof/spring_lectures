package com.SistemLoja.SistemaLoja.Rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.el.lang.ELArithmetic.BigDecimalDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
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
    public void deleteCliente(@PathVariable int clienteId){
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
    public ClienteEntity getCliente(@PathVariable int clienteId){
        ClienteEntity cliente = clienteService.findById(clienteId);

        if(cliente == null){
            throw new RuntimeException("Cliente não encontrado - " + clienteId);
        }

        return cliente;

    }

    @PostMapping("{id}/updateCliente")
    public ClienteEntity updateCliente(@PathVariable int id ,  @RequestBody ClienteEntity cliente){
        cliente.setId(id);

        ClienteEntity updateCliente = clienteService.updateCliente(cliente);

        if(updateCliente == null){
            throw new RuntimeException("Cliente não encontrado - " + id);
        }
        return updateCliente;
    }

    @PostMapping("/adicionarCliente")
    public ClienteEntity addCliente(@RequestBody ClienteEntity cliente){
        clienteService.CriarCliente(cliente);
        return cliente;
    }

   @GetMapping("{id}/findSaldo")
   public BigDecimal findSaldo(@PathVariable int id){
    BigDecimal saldo = clienteService.findSaldo(id);

    if(saldo == null){
        throw new RuntimeException("Cliente não encontrado - " + id);
    }
    return saldo;
   } 
    

}