package com.exemple.meu_todo;

/*
 * Agora vou construir essa classe APIresponse para processar as respostas e enviar os feedbacks para os clientes
 * essa classe vai encapsular a estrutura da API response
 */

 public class ApiResponse{
    private boolean sucesso;
    private String message;
    private Object data;

    public ApiResponse(boolean sucesso , String message , Object data){
        //construtor 
        this.sucesso = sucesso; //sucesso vai indicar se deu certo ou não
        this.message = message; //da mensagens se deu certo ou não 
        this.data = data; //
    }

    public boolean isSucesso(){
        return sucesso;
    }
    public void setSucesso(boolean sucesso){
        this.sucesso = sucesso;
    }

    public String getMessage(){
        return this.message;
    }
    public void setMessage(String message){
        this.message = message;
    }

    public Object getData(){
        return data;
    }
    public void setData(Object data){
        this.data = data;
    }

 }