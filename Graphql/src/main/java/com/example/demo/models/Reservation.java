package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @EmbeddedId
    private ReservationId id;

    @ManyToOne
    @MapsId("utilisateurId")
    private Utilisateur utilisateur;

    @ManyToOne
    @MapsId("chambreId")
    private Chambre chambre;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String preferences;

    // Getters and Setters
    public ReservationId getId() {
        return id;
    }

    public void setId(ReservationId id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }
}
