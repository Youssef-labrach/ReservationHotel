package com.example.demo.Repositories;

import com.example.demo.models.Reservation;
import com.example.demo.models.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {
}
