package com.example.demo.Controllers;

import com.example.demo.Service.GraphQLService;
import com.example.demo.models.Chambre;
import com.example.demo.models.Reservation;
import com.example.demo.models.Utilisateur;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@AllArgsConstructor
@Controller
@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private GraphQLService graphQLService;

    @QueryMapping
    public List<Chambre> getChambres() {
        return graphQLService.getAllChambres();
    }
    @QueryMapping
    public List<Reservation> getReservations() {
        return graphQLService.getAllReservations();
    }
    @QueryMapping
    public List<Utilisateur> getUtilisateurs() {
        return graphQLService.getAllUtilisateurs();
    }
}
