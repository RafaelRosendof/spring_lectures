//possível view do gerente

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
public class GerenteView{
    private final ClienteService clienteService;
    private final FuncionarioService funcionarioService;

    @Autowired
    public GerenteView(ClienteService clienteService , FuncionarioService funcionarioService) {
        this.clienteService = clienteService;
        this.funcionarioService = funcionarioService;
    }

    Scanner leitor = new Scanner(System.in);
    public void menuFuncionario() {
        
        while (true) {
            System.out.println("Menu Gerente:");
            System.out.println("1. Criar Funcionario");
            System.out.println("2. Consultar Funcionario");
            System.out.println("3. Deletar funcionario");
            System.out.println("4. Atualizar funcionario");
            System.out.println("5 Sair");
            int escolha = leitor.nextInt();
            leitor.nextLine(); // Consumir a nova linha

            switch (escolha) {
                case 1:
                    criarFuncionario();
                    break;
                case 2:
                    consultarFuncionario();
                    break;
                case 3:
                    deleteFuncionario();
                    break;
                case 4:
                    updateFuncionario();
                    break;

                case 5:
                    return;
                    
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private void consultarFuncionario(){
        System.out.println("Digite o id do cliente: ");
        int idCliente = leitor.nextInt();
        leitor.nextLine();

        FuncionarioEntity cliente = funcionarioService.findFun(idCliente);
        if (cliente != null) {
            System.out.println(cliente.toString());
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void criarFuncionario(){
        System.out.println("Digite quantos clientes quer criar: ");
        int quantos = leitor.nextInt();

        leitor.nextLine();

        String nome, sobrenome , login, senha , categoria;

        for(int i =0 ; i < quantos ; i++){
            System.out.println("Cadastrando o Funcionario " + (i+1) + "\n\n");

            System.out.println("\n Digite o nome: ");
            nome = leitor.nextLine();

            System.out.println("\n Digite o sobrenome: ");
            sobrenome = leitor.nextLine();

            System.out.println("\n Digite o login: ");
            login = leitor.nextLine();

            System.out.println("\n Digite a senha: ");
            senha = leitor.nextLine();
            
            System.out.println("\n Digite a categoria: ");
            categoria = leitor.nextLine();

            FuncionarioEntity funcionarioNovo = new FuncionarioEntity(nome , sobrenome , login , senha , categoria);
            funcionarioService.criarFuncionario(funcionarioNovo);
        }
    }

    private void deleteFuncionario(){
        System.out.println("Quantos funcionarios devem ser removidos? ");
        int quantos = leitor.nextInt();

        while(quantos > 0){
            System.out.println("Digite o id do cliente a ser removido: ");
            int id = leitor.nextInt();

            funcionarioService.deleteFuncionario(id);

            System.out.println("Funcionario "+ id + " deletado");
            quantos --;
        }
    }

    private void updateFuncionario(){
        System.out.println("Digite o ID do funcionario que precisa ser atualizado: ");
        int opt = leitor.nextInt();
        leitor.nextLine();

        FuncionarioEntity temp = funcionarioService.findFun(opt);
        System.out.println("Atualizando o Funcionario" + temp.toString());

        FuncionarioEntity fun = new FuncionarioEntity();

        fun.setNome(temp.getNome());
        fun.setId(temp.getId());
        fun.setLogin(temp.getLogin());
        fun.setSobrenome(temp.getSobrenome());
        fun.setSenha(temp.getSenha());

       // String chave = "p";

        while(true){
            System.out.println("O que mudar? (1) Nome (2) sobrenome (3) Login (4) Senha  , para sair aperte(q)");

            String escolha = "0";
            escolha = leitor.nextLine();

			if(escolha.equals("1")){
				System.out.println("Qual o novo nome: ");
				String catNovo = leitor.nextLine();
				fun.setNome(catNovo);
				funcionarioService.updateFuncionario(fun);
			}
			else if(escolha.equals("2")){
				System.out.println("Qual o Sobrenome: ");
				String surname = leitor.nextLine();
				fun.setSobrenome(surname);
				funcionarioService.updateFuncionario(fun);
			}

			else if(escolha.equals("q")){
                funcionarioService.updateFuncionario(fun);
				break;
			}
			else if(escolha.equals("3")){
				System.out.println("Qual o novo Login: ");
				String login = leitor.nextLine();
                fun.setLogin(login);
                funcionarioService.updateFuncionario(fun);
			}
            else if(escolha.equals("4")){
                System.out.println("Qual o nova senha: ");
                String senha = leitor.nextLine();
                fun.setSenha(senha);
                funcionarioService.updateFuncionario(fun);
            }

		}

        }

    }