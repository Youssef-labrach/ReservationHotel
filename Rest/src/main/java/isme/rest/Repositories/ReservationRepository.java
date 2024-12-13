package isme.rest.Repositories;

import isme.rest.Models.Reservation;
import isme.rest.Models.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {
}