package com.SistemLoja.SistemaLoja.Rest;


import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.SistemLoja.SistemaLoja.Entity.ClienteEntity;
import com.SistemLoja.SistemaLoja.Service.ClienteService;

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
                .andExpect(jsonPath("$.saldo").value(cliente1.getSaldo()));

        verify(clienteService, times(1)).findById(1);

    }
/* 
    @Test
    public void testUpdateCliente() throws Exception{
        ClienteEntity cliente1 = new ClienteEntity(1 , "Rafael" , "7021666450", "rafinha.galego73@gmail.com", "84988278927" , "rafael", "rafael123", BigDecimal.valueOf(1250));

        String nome = "Rosendo";

        cliente1.setNome(nome);


        when(clienteService.findById(1)).thenReturn(cliente1);
        when(clienteService.updateCliente(cliente1)).thenReturn(cliente1);
        doNothing().when(clienteService).updateCliente(cliente1); 

        mockMvc.perform(post(nome , ("/cliente/{cliente.getId()}/updateCliente")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(cliente1.getId()))
                .andExpect(jsonPath("$.nome").value(nome))
                .andExpect(jsonPath("$.cpf").value(cliente1.getCPF()))
                .andExpect(jsonPath("$.email").value(cliente1.getEmail()))
                .andExpect(jsonPath("$.telefone").value(cliente1.getTelefone()))
                .andExpect(jsonPath("$.login").value(cliente1.getLogin()))
                .andExpect(jsonPath("$.senha").value(cliente1.getSenha()))
                .andExpect(jsonPath("$.salario").value(cliente1.getSaldo()));
    }

*/
    @Test
    public void testAddCliente() throws Exception{

        ClienteEntity cliente1 = new ClienteEntity(1 , "Rafael" , "7021666450", "rafinha.galego73@gmail.com", "84988278927" , "rafael", "rafael123", BigDecimal.valueOf(1250));
        ClienteEntity cliente2 = new ClienteEntity(2 , "Firuza" , "702166", "figas@gmail.com", "84988278927" , "figas", "figas123", BigDecimal.valueOf(1550));
        ClienteEntity cliente3 = new ClienteEntity(3 , "Figao" , "702166", "firuza@gmail.com", "84988278927" , "firuza", "firuza123", BigDecimal.valueOf(1750));
            
            when(clienteService.CriarCliente(cliente1)).thenReturn(cliente1);
            when(clienteService.CriarCliente(cliente2)).thenReturn(cliente2);
            when(clienteService.CriarCliente(cliente3)).thenReturn(cliente3);

            mockMvc.perform(put("/cliente/adicionarCliente"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(cliente1.getId()))
                .andExpect(jsonPath("$.nome").value(cliente1.getNome()))
                .andExpect(jsonPath("$.cpf").value(cliente1.getCPF()))
                .andExpect(jsonPath("$.email").value(cliente1.getEmail()))
                .andExpect(jsonPath("$.telefone").value(cliente1.getTelefone()))
                .andExpect(jsonPath("$.login").value(cliente1.getLogin()))
                .andExpect(jsonPath("$.senha").value(cliente1.getSenha()))
                .andExpect(jsonPath("$.saldo").value(cliente1.getSaldo()));
    }
    /* TODO
     * Teste de update (dando erro no post)
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