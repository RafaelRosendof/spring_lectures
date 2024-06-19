package com.trabalho.pix.view;

import com.trabalho.pix.entity.ClienteEntity;
import com.trabalho.pix.entity.FuncionarioEntity;
import com.trabalho.pix.Service.AutenticaService;
import com.trabalho.pix.view.ClienteView;
import com.trabalho.pix.view.FuncionarioView;
import com.trabalho.pix.view.GerenteView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AutenticaView {

    private final AutenticaService autenticaService;
    private final ClienteView clienteView;
    private final FuncionarioView funcionarioView;
    private final GerenteView gerenteView;

    @Autowired
    public AutenticaView(AutenticaService autenticaService, ClienteView clienteView, FuncionarioView funcionarioView, GerenteView gerenteView) {
        this.autenticaService = autenticaService;
        this.clienteView = clienteView;
        this.funcionarioView = funcionarioView;
        this.gerenteView = gerenteView;
    } 

    public void menuPrincipal() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Bem vindo ao menu do banco");
        System.out.println("Digite (1) para cliente, (2) para funcionário, ou (3) para gerente: ");
        int opt = leitor.nextInt();
        leitor.nextLine();

        switch (opt) {
            case 1:
                autenticaCliente(leitor);
                break;
            case 2:
                autenticaFuncionario(leitor);
                break;
            case 3:
                autenticaGerente(leitor);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void autenticaCliente(Scanner leitor) {
        System.out.println("\n Por favor insira o seu login: ");
        String login = leitor.nextLine();

        System.out.println("\n Agora insira a senha: ");
        String senha = leitor.nextLine();

        ClienteEntity cliente = autenticaService.clienteFind(login, senha);
        if (cliente != null) {
            clienteView.menuCliente();
        } else {
            System.out.println("Login ou senha incorretos.");
        }
    }

    private void autenticaFuncionario(Scanner leitor) {
        System.out.println("\n Por favor insira o seu login: ");
        String login = leitor.nextLine();

        System.out.println("\n Agora insira a senha: ");
        String senha = leitor.nextLine();

        FuncionarioEntity funcionario = autenticaService.funcionarioFind(login, senha);
        if (funcionario != null) {
            funcionarioView.menuFuncionario();
        } else {
            System.out.println("Login ou senha incorretos.");
        }
    }

    private void autenticaGerente(Scanner leitor) {
        System.out.println("\n Por favor insira o seu login: ");
        String login = leitor.nextLine();

        System.out.println("\n Agora insira a senha: ");
        String senha = leitor.nextLine();

        FuncionarioEntity gerente = autenticaService.gerenteFind(login, senha);
        if (gerente != null) {
            gerenteView.menuFuncionario();
        } else {
            System.out.println("Login ou senha incorretos.");
        }
    }
}

/*
 * //			FuncionarioEntity fun1 = new FuncionarioEntity("Rafael", "Rosendo", "1905", "471560", "Gerente"); //acho que vai dar merda na categoria
			// FuncionarioService funcionarioService;
		//	funcionarioService.criarFuncionario(fun1);

            // Criando algumas amostras de clientes
            //ClienteEntity cli1 = new ClienteEntity("Jadnaaa", "Cristinaaaa", "amorr", "rafaell", BigDecimal.valueOf(10000) , "190504");
            //ClienteEntity cli2 = new ClienteEntity("Rafaelllll", "Faustinoooo", "jadnaa", "jadnaa", BigDecimal.valueOf(200) , "47156");

//			funcionarioService.criarCliente(cli1);
		//	funcionarioService.criarCliente(cli2);

			//Antes de rodar, faça a criação de 3 clientes dois funcionarios e um gerente 
			System.out.println("Bem vindo ao menu do banco");

			System.out.println("Digite (1) para cliente ou (2) para funcionário: ");			
			int opt = leitor.nextInt();
			leitor.nextLine();

			if(opt == 2){

				System.out.println("\n Por favor insira o seu login: ");
				String login = leitor.nextLine();

				System.out.println("\n Agora insira a senha: ");
				String senha = leitor.nextLine();
				//FuncionarioEntity funcionario = autenticaService.funcionarioFind(login, senha);
				FuncionarioEntity funcionarioEntity = autenticaService.funcionarioFind(login, senha);
				
				funcionarioView.menuFuncionario();

			}else{
				System.out.println("Bem vindo cliente ");
				System.out.println("\n Por favor insira o seu login: ");
				String login = leitor.nextLine();

				System.out.println("\n Agora insira a senha: ");
				String senha = leitor.nextLine();

				ClienteEntity cliente = autenticaService.clienteFind(login, senha);
				clienteView.menuCliente();
			}


		};
	}
 */