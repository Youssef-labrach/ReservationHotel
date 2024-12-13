package isme.rest.Models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ReservationId implements Serializable {
    private Long utilisateurId;
    private Long chambreId;

}

