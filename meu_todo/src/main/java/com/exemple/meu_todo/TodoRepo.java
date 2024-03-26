package com.exemple.meu_todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Todo , Long> {

    
}
/*
 * Aqui foi criado uma interface que vai extender do JpaRepository<Todo,Long> onde o Todo é uma entity class 
 * e o long é um tipo 
 * 
 * 
O JpaRepository é uma interface fornecida pelo Spring Data JPA. Ele oferece uma coleção de métodos predefinidos para operações de banco de dados, 
os quais você verá posteriormente chamados em nossa classe Controller que vamos implementar. Ao estender o JpaRepository,
 nosso TodoRepository ganha métodos como save, findById, findAll, delete e mais, sem exigir implementação explícita.

Ao criar a interface TodoRepository, você estabeleceu a base para acessar e manipular dados de Tarefas dentro do banco de dados (neste caso, nosso banco de dados H2 em memória).
 Nos próximos passos, vamos construir sobre isso criando o controlador e implementando operações CRUD que utilizam este repositório para gerenciar itens de Tarefas.
 */