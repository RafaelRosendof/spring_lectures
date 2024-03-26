package com.api_grapql.exemplo.modelo;

public record User(int userId , String primeriroNome , String sobrenome){
    public User(){
        this(0, "", "");
    }
}