package com.api_grapql.exemplo.service;


import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api_grapql.exemplo.modelo.Address;
//import com.api_grapql.exemplo.modelo.User;
//import com.api_grapql.exemplo.modelo.UserInput;
import com.api_grapql.exemplo.modelo.User;
import com.api_grapql.exemplo.modelo.UserInput;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;


@Component
public class GraphqlService{
    //definindo métodos hash 
    private static Map<Integer , User> userData = new ConcurrentHashMap<>(); 
    private static Map< Integer , Address> userAddress = new ConcurrentHashMap<>();

    @Autowired
    private Sinks.Many<User> userSink;

    @Autowired
    private Flux<User> userFlux;
    
    public String initializeData(){
        
     //    userAddress.put(userAddress.size()+1, new Address(userAddress.size()+1,159,userData.size()+1,"Random Street","Berlin","10119","DE"));    
        userAddress.put(userAddress.size()+1, new Address(userAddress.size()+1, 159 ,userData.size()+1,"Random Street","Berlin","10119","DE"));
        userData.put(userData.size()+1 , new User(userData.size()+ 1 , "Rafael" , "Rosendo"  ));

        return "Data resgitrado e finalizado ";
    }

    public User getUserById(int userId) {
        return userData.containsKey(userId) ?
          userData.get(userId) : new User();
    }

    public Address getAddressById(int addressId) {
        return userAddress.containsKey(addressId) ?
          userAddress.get(addressId) : new Address();
    }

    public Address getAddressByUserId(int userId) {
        return userAddress.values()
          .stream()
          .filter(a -> a.userId()==userId)
          .findAny().orElse(new Address());
    }

    public Collection<User> getAllUsers() {
        return userData.values();
    }

    public Map<User, Address> getAddressByUserIdList(Set<Integer> userIdList) {
        return userAddress.values()
          .stream()
          .filter(a -> userIdList.contains(a.userId()))
          .collect(Collectors.toMap(a -> getUserById(a.userId()), a -> a));
    }

    public User addNewUser(UserInput userId) {
        User user = new User(userData.size()+1, userId.primeiroNome(), userId.sobreNome());
        userData.put(userData.size()+1, user);
        Address add = new Address(userAddress.size()+1, user.userId(), userId.numero_casa(), userId.rua(), userId.cidade(), userId.CEP(), userId.pais());
        userAddress.put(userAddress.size()+1, add);
        userSink.tryEmitNext(user);
        return user;
    }

    public Publisher<String> greetNewUser() {
        return userFlux.map(testando -> greet(Optional.of(testando.primeriroNome()+" "+testando.sobrenome())));
    }

    public String greet(Optional<String> name) {
        System.out.println("-----greeting-----");
        return "Hello "+name.orElse("to you")+"!";
    }
}
