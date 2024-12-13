package isme.rest.Controllers;

import isme.rest.Models.Reservation;
import isme.rest.Models.ReservationId;
import isme.rest.Repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable ReservationId id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable ReservationId id, @RequestBody Reservation reservationDetails) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent()) {
            Reservation updatedReservation = reservation.get();
            updatedReservation.setUtilisateur(reservationDetails.getUtilisateur());
            updatedReservation.setChambre(reservationDetails.getChambre());
            updatedReservation.setDateDebut(reservationDetails.getDateDebut());
            updatedReservation.setDateFin(reservationDetails.getDateFin());
            updatedReservation.setPreferences(reservationDetails.getPreferences());
            reservationRepository.save(updatedReservation);
            return ResponseEntity.ok(updatedReservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable ReservationId id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent()) {
            reservationRepository.delete(reservation.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
