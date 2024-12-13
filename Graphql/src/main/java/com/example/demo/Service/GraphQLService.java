package com.example.demo.Service;

import com.example.demo.Repositories.ChambreRepository;
import com.example.demo.Repositories.ReservationRepository;
import com.example.demo.Repositories.UtilisateurRepository;
import com.example.demo.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GraphQLService {

    @Autowired
    private ChambreRepository chambreRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Chambre createChambre(String type, double prix, boolean disponible) {
        Chambre chambre = new Chambre();
        chambre.setType(type);
        chambre.setPrix(prix);
        chambre.setDisponible(disponible);
        return chambreRepository.save(chambre);
    }

    public Reservation createReservation(Long utilisateurId, Long chambreId, String dateDebut, String dateFin, String preferences) {
        Reservation reservation = new Reservation();
        ReservationId reservationId = new ReservationId(utilisateurId, chambreId);
        reservation.setId(reservationId);
        reservation.setUtilisateur(utilisateurRepository.findById(utilisateurId).orElseThrow());
        reservation.setChambre(chambreRepository.findById(chambreId).orElseThrow());
        reservation.setDateDebut(LocalDate.parse(dateDebut));
        reservation.setDateFin(LocalDate.parse(dateFin));
        reservation.setPreferences(preferences);
        return reservationRepository.save(reservation);
    }

    public Utilisateur createUtilisateur(String nomUtilisateur, String motDePasse, Role role) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNomUtilisateur(nomUtilisateur);
        utilisateur.setMotDePasse(motDePasse);
        utilisateur.setRole(role);
        return utilisateurRepository.save(utilisateur);
    }
}
