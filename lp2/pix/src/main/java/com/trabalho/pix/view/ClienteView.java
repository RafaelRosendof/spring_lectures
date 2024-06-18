//view do cliente 
package com.trabalho.pix.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

import com.trabalho.pix.Service.ClienteService;
import com.trabalho.pix.Service.TransactionService;

@Component
public class ClienteView{
    private final ClienteService clienteService;
    private final TransactionService transactionService; 

    @Autowired
    public ClienteView(ClienteService clienteService , TransactionService transactionService){
        this.clienteService = clienteService;
        this.transactionService = transactionService;
    }

    public void menuCliente(){
    Scanner leitor = new Scanner(System.in);
    
    while (true) {
       System.out.println("Menu Cliente: ");
       System.out.println("1. Consultar Saldo"); 
       System.out.println("2. Transferir Dinheiro"); 
       System.out.println("3. Sair"); 

       int escolha = leitor.nextInt();
       leitor.nextLine();

       switch (escolha) {
        case 1:
           consultarSaldo(leitor);

            break;

        case 2:
            transferir(leitor);
            break;

        case 3:
            System.out.println("Saind....."); //todo ajeitar isso 
        default:
        System.out.println("Opção inválida, tente novamente ou mais tarde");
            break;
       }
        }

    }

    private void consultarSaldo(Scanner leitor){
        System.out.println("Digite a conta: ");
        String conta = leitor.nextLine();
        BigDecimal saldo = clienteService.consultarSaldo(conta);
        System.out.println("O saldo da sua conta é " + saldo);
    }

    private void transferir(Scanner leitor){

        System.out.println("Por segurança digite a sua conta: ");
        String contaRemetente = leitor.nextLine();

        System.out.println("Digite a conta do recebedor: ");
        String contaRecebedor = leitor.nextLine();

        System.out.println("Quantos reais será a transferência: ");
        BigDecimal valor = leitor.nextBigDecimal();
        leitor.nextLine();
        
    
        try{
        transactionService.transferir(contaRemetente, contaRecebedor, valor); 
        } catch(Exception e ){
            System.out.println("erro na transferencia : " + e.getMessage());
        }
    }

}