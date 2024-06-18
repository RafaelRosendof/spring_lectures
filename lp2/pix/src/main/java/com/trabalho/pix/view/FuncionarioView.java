//view do funcionario 

/*
 * criar usuário
 * atualizar 
 * deletar
 * buscar achar por id e achar tudo
 */

 package com.trabalho.pix.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;
import com.trabalho.pix.Service.ClienteService;
import com.trabalho.pix.Service.FuncionarioService;
import com.trabalho.pix.entity.ClienteEntity;
import com.trabalho.pix.entity.FuncionarioEntity;
@Component
public class FuncionarioView{
    private final ClienteService clienteService;
    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioView(ClienteService clienteService , FuncionarioService funcionarioService) {
        this.clienteService = clienteService;
        this.funcionarioService = funcionarioService;
    }

    Scanner leitor = new Scanner(System.in);
    public void menuFuncionario() {
        
        while (true) {
            System.out.println("Menu Funcionário:");
            System.out.println("1. Criar Cliente");
            System.out.println("2. Consultar Saldo");
            System.out.println("3. Transferir");
            System.out.println("4. Sair");
            int escolha = leitor.nextInt();
            leitor.nextLine(); // Consumir a nova linha

            switch (escolha) {
                case 1:
                    criarCliente();
                    break;
                case 2:
                    consultarCliente();
                    break;
                case 3:
                    deletarCliente();
                    break;
                case 4:
                    updateCliente();
                    break;

                case 5:
                    return;
                    
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private void consultarCliente(){
        System.out.println("Digite o id do cliente: ");
        int idCliente = leitor.nextInt();
        leitor.nextLine();

        ClienteEntity cliente = funcionarioService.findById(idCliente);
        if (cliente != null) {
            System.out.println(cliente.toString());
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void criarCliente(){
        System.out.println("Digite quantos clientes quer criar: ");
        int quantos = leitor.nextInt();

        leitor.nextLine();

        String nome, sobrenome , login, senha , conta;
        BigDecimal saldo;

        for(int i =0 ; i < quantos ; i++){
            System.out.println("Cadastrando o cliente " + (i+1) + "\n\n");

            System.out.println("\n Digite o nome: ");
            nome = leitor.nextLine();

            System.out.println("\n Digite o sobrenome: ");
            sobrenome = leitor.nextLine();

            System.out.println("\n Digite o login: ");
            login = leitor.nextLine();

            System.out.println("\n Digite a senha: ");
            senha = leitor.nextLine();
            
            System.out.println("\n Digite o saldo: ");
            saldo = leitor.nextBigDecimal();
            leitor.nextLine();

            System.out.println("\n Digite a conta: ");
            conta = leitor.nextLine();

            ClienteEntity clienteNovo = new ClienteEntity(nome , sobrenome , login , senha , saldo , conta);
            funcionarioService.criarCliente(clienteNovo);
        }
    }

    private void deletarCliente(){
        System.out.println("Quantos clientes devem ser removidos? ");
        int quantos = leitor.nextInt();

        while(quantos > 0){
            System.out.println("Digite o id do cliente a ser removido: ");
            int id = leitor.nextInt();

            funcionarioService.deleteCliente(id);

            System.out.println("Cliente "+ id + " deletado");
            quantos --;
        }
    }

    private void updateCliente(){
        System.out.println("Digite o ID do cliente que precisa ser atualizado: ");
        int opt = leitor.nextInt();
        leitor.nextLine();

        ClienteEntity temp = funcionarioService.findById(opt);
        System.out.println("Atualizando o cliente" + temp.toString());

        ClienteEntity cliente = new ClienteEntity();

        cliente.setNome(temp.getNome());
        cliente.setId(temp.getId());
        cliente.setConta(temp.getConta());
        cliente.setLogin(temp.getLogin());
        cliente.setSaldo(temp.getSaldo());
        cliente.setSobrenome(temp.getSobrenome());
        cliente.setSenha(temp.getSenha());

       // String chave = "p";

        while(true){
            System.out.println("O que mudar? (1) Nome (2) sobrenome (3) Conta (4) Login (5) Senha (6) Saldo , para sair aperte(q)");

            String escolha = "0";
            escolha = leitor.nextLine();

			if(escolha.equals("1")){
				System.out.println("Qual o novo nome: ");
				String catNovo = leitor.nextLine();
				cliente.setNome(catNovo);
				funcionarioService.updateCliente(cliente);
			}
			else if(escolha.equals("2")){
				System.out.println("Qual o Sobrenome: ");
				String surname = leitor.nextLine();
				cliente.setSobrenome(surname);
				funcionarioService.updateCliente(cliente);
			}
			else if(escolha.equals("3")){
				System.out.println("Qual a nova conta: ");
				String conta = leitor.nextLine();
				cliente.setConta(conta);
                funcionarioService.updateCliente(cliente);
			}
			else if(escolha.equals("q")){
                funcionarioService.updateCliente(cliente);
				break;
			}
			else if(escolha.equals("4")){
				System.out.println("Qual o novo Login: ");
				String login = leitor.nextLine();
                cliente.setLogin(login);
                funcionarioService.updateCliente(cliente);
			}
            else if(escolha.equals("5")){
                System.out.println("Qual o nova senha: ");
                String senha = leitor.nextLine();
                cliente.setSenha(senha);
                funcionarioService.updateCliente(cliente);
            }

            else if(escolha.equals("6")){
                System.out.println("Qual o novo Saldo: ");
                BigDecimal saldo = leitor.nextBigDecimal();
                cliente.setSaldo(saldo);
                funcionarioService.updateCliente(cliente);
            }
		}

        }

    }
 