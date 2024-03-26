package com.exemple.meu_todo;

public class Arquivo_not_found extends RuntimeException{
    public Arquivo_not_found(String message){
        super(message); //classe filha para tratar mensagens de erro 
    }
}