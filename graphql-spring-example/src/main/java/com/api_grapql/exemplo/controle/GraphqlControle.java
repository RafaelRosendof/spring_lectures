package com.api_grapql.exemplo.controle;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;

import com.api_grapql.exemplo.modelo.Address;
import com.api_grapql.exemplo.modelo.User;
import com.api_grapql.exemplo.modelo.UserInput;
import com.api_grapql.exemplo.service.GraphqlService;



@Controller
public class GraphqlControle{

    @Autowired
    private GraphqlService graphqlService; //objeto

    public String getGreetingMessage(@Argument Optional<String> name){
        String mensagem = graphqlService.greet(name);
        return mensagem + "\n" + graphqlService.initializeData();
    }

    @QueryMapping
    public Collection<User> getAllUsers(){
        return graphqlService.getAllUsers();
    }

    @QueryMapping
    public User GetUserById(@Argument int userId){
        return graphqlService.getUserById(userId); //buscando usuário por id
    }

    public Address getAddressByUserId(User user){
        System.out.println("------------------------------");
        return graphqlService.getAddressByUserId(user.userId());

    }

    @BatchMapping(field ="address")
    public Map<User , Address> getAddressByUserId(List<User> userList){
        System.out.println("-----------------------------\n");
        Set<Integer> userIdList = userList.stream().map(a -> a.userId()).collect(Collectors.toSet());

        return graphqlService.getAddressByUserIdList(userIdList);

    }  //map  da funcional onde aplica essa função a todo usuario da lista 

    @MutationMapping
    public User addNovoUsuario(@Argument UserInput user){
        return graphqlService.addNewUser(user);
    }

    @SubscriptionMapping
    public Publisher<String> greetNewUsers(){
        return graphqlService.greetNewUser();
    }
}
    
