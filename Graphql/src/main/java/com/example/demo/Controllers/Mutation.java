package com.example.demo.Controllers;

import com.example.demo.Service.GraphQLService;
import com.example.demo.models.Chambre;
import com.example.demo.models.Reservation;
import com.example.demo.models.Role;
import com.example.demo.models.Utilisateur;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@AllArgsConstructor
@Controller
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private GraphQLService graphQLService;

    @MutationMapping
    public Chambre createChambre(@Argument String type, @Argument double prix, @Argument boolean disponible) {
        return graphQLService.createChambre(type, prix, disponible);
    }

    @MutationMapping
    public Reservation createReservation(@Argument Long utilisateurId, @Argument Long chambreId, @Argument String dateDebut, @Argument String dateFin, @Argument String preferences) {
        return graphQLService.createReservation(utilisateurId, chambreId, dateDebut, dateFin, preferences);
    }

    @MutationMapping
    public Utilisateur createUtilisateur(@Argument String nomUtilisateur, @Argument String motDePasse, @Argument Role role) {
        return graphQLService.createUtilisateur(nomUtilisateur, motDePasse, role);
    }
}