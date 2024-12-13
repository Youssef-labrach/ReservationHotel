package com.example.demo.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
@NoArgsConstructor

public class ReservationId implements Serializable {
    private Long utilisateurId;
    private Long chambreId;

    public ReservationId(Long utilisateurId, Long chambreId) {
        this.utilisateurId = utilisateurId;
        this.chambreId = chambreId;
    }
    // Getters et setters
    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public Long getChambreId() {
        return chambreId;
    }

    public void setChambreId(Long chambreId) {
        this.chambreId = chambreId;
    }

    // hashCode et equals (obligatoires pour les clés composites)
    @Override
    public int hashCode() {
        return Objects.hash(utilisateurId, chambreId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ReservationId that = (ReservationId) obj;
        return Objects.equals(utilisateurId, that.utilisateurId) &&
                Objects.equals(chambreId, that.chambreId);
    }
}
