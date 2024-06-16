package com.trabalho.pix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Scanner;
import com.trabalho.pix.entity.ClienteEntity;
import com.trabalho.pix.entity.FuncionarioEntity;

import com.trabalho.pix.Service.AutenticaService;
import com.trabalho.pix.Service.ClienteService;
import com.trabalho.pix.Service.FuncionarioService;
import com.trabalho.pix.Service.TransactionServiceImpl;
import com.trabalho.pix.view.ClienteView;
import com.trabalho.pix.view.FuncionarioView;
import com.trabalho.pix.view.GerenteView;

import java.math.BigDecimal;

@SpringBootApplication
public class PixApplication {

	public static void main(String[] args) {
		SpringApplication.run(PixApplication.class, args);

	}

	Scanner leitor = new Scanner(System.in);
	@Bean
	public CommandLineRunner commandLineRunner(@Autowired FuncionarioService funcionarioService , @Autowired ClienteService clienteService , @Autowired TransactionServiceImpl transactionServiceImpl,@Autowired ClienteView clienteView , @Autowired FuncionarioView funcionarioView , @Autowired GerenteView gerenteView , @Autowired AutenticaService autenticaService){

		return runner ->{

			FuncionarioEntity fun1 = new FuncionarioEntity("Rafael", "Rosendo", "1905", "471560", "Gerente"); //acho que vai dar merda na categoria
			//final FuncionarioService funcionarioService;
			funcionarioService.criarFuncionario(fun1);

            // Criando algumas amostras de clientes
            ClienteEntity cli1 = new ClienteEntity("Jadna", "Cristina", "amor", "rafael", BigDecimal.valueOf(10000) , "190504-x");
            ClienteEntity cli2 = new ClienteEntity("Rafael", "Faustino", "jadna", "jadna", BigDecimal.valueOf(200) , "471560");

			funcionarioService.criarCliente(cli1);
			funcionarioService.criarCliente(cli2);

			//Antes de rodar, faça a criação de 3 clientes dois funcionarios e um gerente 
			System.out.println("Bem vindo ao menu do banco");

			
			System.out.println("\n Por favor insira o seu login: ");
			String login = leitor.nextLine();

			System.out.println("\n Agora insira a senha: ");
			String senha = leitor.nextLine();

            FuncionarioEntity funcionario = autenticaService.funcionarioFind(login, senha);
            if (funcionario != null) {
                System.out.println("Bem-vindo, Funcionário.");
                funcionarioView.menuFuncionario();
                return;
            }

            ClienteEntity cliente = autenticaService.clienteFind(login, senha);
            if (cliente != null) {
                System.out.println("Bem-vindo, Cliente.");
                clienteView.menuCliente();
                return;
            }

            System.out.println("Credenciais inválidas. Tente novamente.");

		};
	}

}
