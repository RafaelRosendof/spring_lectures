package com.SistemLoja.SistemaLoja.Rest;


import com.SistemLoja.SistemaLoja.Service.ClienteService;

//import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.SistemLoja.SistemaLoja.Entity.ClienteEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.List;
import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteRestControllerTest{


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Test
    public void testFindAll() throws Exception{
        ClienteEntity cliente1 = new ClienteEntity(1 , "Rafael" , "7021666450", "rafinha.galego73@gmail.com", "84988278927" , "rafael", "rafael123", BigDecimal.valueOf(1250));
        ClienteEntity cliente2 = new ClienteEntity(2 , "Firuza" , "702166", "figas@gmail.com", "84988278927" , "figas", "figas123", BigDecimal.valueOf(1550));
        ClienteEntity cliente3 = new ClienteEntity(3 , "Figao" , "702166", "firuza@gmail.com", "84988278927" , "firuza", "firuza123", BigDecimal.valueOf(1750));

        List<ClienteEntity> clientes = Arrays.asList(cliente1, cliente2, cliente3);

        when(clienteService.findAll()).thenReturn(clientes);

        mockMvc.perform(get("/cliente/ListClientes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(clientes.size()));
    }

    @Test
    public void testDeleteCliente() throws Exception{
        ClienteEntity cliente1 = new ClienteEntity(1 , "Rafael" , "7021666450", "rafinha.galego73@gmail.com", "84988278927" , "rafael", "rafael123", BigDecimal.valueOf(1250));

        when(clienteService.findById(1)).thenReturn(cliente1);
        doNothing().when(clienteService).deleteById(1);

        mockMvc.perform(delete("/cliente/deletaCliente/1"))
                .andExpect(status().isOk());

        verify(clienteService, times(1)).deleteById(1);

    }

    @Test
    public void testGetCliente() throws Exception{
        ClienteEntity cliente1 = new ClienteEntity(1 , "Rafael" , "7021666450", "rafinha.galego73@gmail.com", "84988278927" , "rafael", "rafael123", BigDecimal.valueOf(1250));
        
        when(clienteService.findById(cliente1.getId())).thenReturn(cliente1);

        //doNothing().when(clienteService)

        mockMvc.perform(get("/cliente/cliente/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(cliente1.getId()))
                .andExpect(jsonPath("$.nome").value(cliente1.getNome()))
                .andExpect(jsonPath("$.cpf").value(cliente1.getCPF()))
                .andExpect(jsonPath("$.email").value(cliente1.getEmail()))
                .andExpect(jsonPath("$.telefone").value(cliente1.getTelefone()))
                .andExpect(jsonPath("$.login").value(cliente1.getLogin()))
                .andExpect(jsonPath("$.senha").value(cliente1.getSenha()))
                .andExpect(jsonPath("$.salario").value(cliente1.getSaldo()));

        verify(clienteService, times(1)).findById(1);

    }


    /* TODO
     * Teste de update
     * teste de adicionar 
     * teste de find saldo 
     */


/* 

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteRestController clienteRestController;

    @BeforeEach
    void setUp(){
        clienteRestController = new ClienteRestController(clienteService);
    }

    @Test
    void testFindAll(){
        ClienteEntity cliente1 = new ClienteEntity();
        ClienteEntity cliente2 = new ClienteEntity();
        ClienteEntity cliente3 = new ClienteEntity();

        cliente1.setId(1);
        cliente2.setId(2);
        cliente3.setId(3);


        cliente1.setNome("Rinaldo");
        cliente2.setNome("Firuza");
        cliente3.setNome("Figao");

        List<ClienteEntity> clientes =  Arrays.asList(cliente1, cliente2, cliente3);

        when(clienteService.findAll()).thenReturn(clientes);

        List<ClienteEntity> result = clienteRestController.findAll();

        assertEquals(3 , result.size());

        assertEquals("Rinaldo", result.get(0).getNome());

    }
        */
} 