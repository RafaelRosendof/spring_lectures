package com.crudEscola.escola;

import java.util.Scanner;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.crudEscola.escola.dao.UsuarioDAO;
import com.crudEscola.escola.entidade.Usuario;


@SpringBootApplication
public class EscolaApplication {
	Scanner leitor = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(EscolaApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(UsuarioDAO usuarioDAO){
		return runner -> {
			System.out.println("Começando a CRUD");

			String controle = "1";

			while(controle.equals("1")){
				System.out.println("BEM VINDO A CRUD DA ESCOLA");
				System.out.println("Digite (1) para ler um usuário");
				System.out.println("Digite (2) para criar multiplos ou único  usuário");
				System.out.println("Digite (3) para atualizar um usuário");
				System.out.println("Digite (4) para Deletar um ou vários usuário");
				System.out.println("Digite (5) para pesquisar por categoria sobrenome ou ID");
				System.out.println("Digite q para sair");
        

				/*
				 * TODO LIST
				 * TESTAR O RESTO DOS MÉTODOS 
				 * VER SE TODOS ESTÃO FUNCIONANDO CORRETAMENTE
				 * IMPLEMENTAR O MÉTODO DE BUSCA 
				 * 
				 */

        

				String option;
				System.out.printf("\n\n Digite a opção que deseja:");
				option = leitor.nextLine();
				
				if(option.equals("1")){
					readUser(usuarioDAO);
					System.out.println("\n\n\n");
				}
				else if(option.equals("2")){
					createMultipleUsers(usuarioDAO);
					System.out.println("\n\n\n");
				}
				else if( option.equals("3")){
					updateUser(usuarioDAO);
					System.out.println("\n\n");
				}
				else if( option.equals("4")){
					delete(usuarioDAO);
					System.out.println("\n\n");
				}
				else if(option.equals("q")){
					break;
				}
				else if(option.equals("5")){
					retornaSobrenome(usuarioDAO);
				}
				else{
					System.out.println("AINDA EM CONSTRUÇÃO !!!!!");
				}
			}
		};
	}
	/*
	 * READ  DONE
	 * CREATE  DONE
	 * UPDATE   DONE
	 * DELETE  DONE
	 * BUSCAR feito por nome e por ID 
	 *  
	 */

	 private void retornaSobrenome(UsuarioDAO usuarioDAO){
		System.out.println("Digite o sobrenome que queres pesquisar: ");
		String nome = leitor.nextLine();

		List<Usuario> temp = usuarioDAO.findBySobrenome(nome);

		for(Usuario tempp : temp){
			System.out.println(tempp);
		}
	 }

	 private void readUser(UsuarioDAO usuarioDAO){
		System.out.println("Qual usuário o sr. quer fazer a consulta: ");
		int idUser = leitor.nextInt();

		Usuario temp = usuarioDAO.findById(idUser);

		System.out.println("USUÁRIO:    " + temp);
	 }

	private void createMultipleUsers(UsuarioDAO usuarioDAO){
		System.out.println("Digite quantos usuário queres criar: ");
		int quantos = leitor.nextInt();
		leitor.nextLine();

		String categoria , primeiroNome , sobrenome , email;

		for(int i = 0; i< quantos ; i++){
			System.out.println("Cadastrando o usuário " + (i+1) + "\n\n");

			System.out.printf("\nDigite a categoria do usuário: ");
			categoria = leitor.nextLine();

			System.out.printf("\nDigite o primeiro Nome: ");
			primeiroNome = leitor.nextLine();

			System.out.printf("\nDigite o sobrenome: ");
			sobrenome = leitor.nextLine();

			System.out.printf("\nDigite o email: ");
			email = leitor.nextLine();

			Usuario tempUsuario = new Usuario(categoria , primeiroNome , sobrenome , email);

			usuarioDAO.save(tempUsuario);
		}
	 }

	 private void updateUser(UsuarioDAO usuarioDAO){
		System.out.println("Quem o sr. quer atualizar ?");
		int option = leitor.nextInt();
		leitor.nextLine();
		Usuario temp = usuarioDAO.findById(option);
		System.out.println("Getting student with id: " + temp);

		System.out.println("ALUNO = "+ temp.getId());
		
		Usuario mUsuario = new Usuario();
		mUsuario.setId(temp.getId());
		mUsuario.setEmail(temp.getEmail());
		mUsuario.setPrimeiroNome(temp.getPrimeiroNome());
		mUsuario.setSobrenome(temp.getSobrenome());
		mUsuario.setTypeOfUser(temp.getTypeOfUser());


		String chave = "p";

		while(chave != "q"){
			System.out.println("O que queres mudar? (1) categoria (2) email (3) primeiro Nome (4) Sobrenome Digite (q) para sair");
			String escolha = "0";
			escolha = leitor.nextLine();

			if(escolha.equals("1")){
				System.out.println("Qual a nova categoria: ");
				String catNovo = leitor.nextLine();
				mUsuario.setTypeOfUser(catNovo);
				usuarioDAO.update(mUsuario);
			}
			else if(escolha.equals("2")){
				System.out.println("Qual o novo email: ");
				String email = leitor.nextLine();
				mUsuario.setEmail(email);
				usuarioDAO.update(mUsuario);
			}
			else if(escolha.equals("3")){
				System.out.println("Qual o novo primeiro Nome: ");
				String nome = leitor.nextLine();
				mUsuario.setPrimeiroNome(nome);
				usuarioDAO.update(mUsuario);
			}
			else if(escolha.equals("q")){
				break;
			}
			else if(escolha.equals("4")){
				System.out.println("Qual o novo sobrenome: ");
				String nome = leitor.nextLine();
				mUsuario.setSobrenome(nome);
				usuarioDAO.update(mUsuario);
			}
		}

		

	 }

	 private void delete(UsuarioDAO usuarioDAO){
		System.out.println("Digite quantos usuários devem ser removidos: ");
		int quantos = leitor.nextInt();

		while(quantos > 0){
			System.out.printf("Digite o ID do usuário que queres deletar: ");
			int id = leitor.nextInt();

			System.out.println("Removido o usuário: " + id);
			usuarioDAO.delete(id);

			quantos--;
		}
	 }

	//leitor.close();
}
