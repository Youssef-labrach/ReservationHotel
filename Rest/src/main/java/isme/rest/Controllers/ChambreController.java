package isme.rest.Controllers;

import isme.rest.Models.Chambre;
import isme.rest.Repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chambres")
public class ChambreController {

    @Autowired
    private ChambreRepository chambreRepository;

    @GetMapping
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chambre> getChambreById(@PathVariable Long id) {
        Optional<Chambre> chambre = chambreRepository.findById(id);
        return chambre.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Chambre createChambre(@RequestBody Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chambre> updateChambre(@PathVariable Long id, @RequestBody Chambre chambreDetails) {
        Optional<Chambre> chambre = chambreRepository.findById(id);
        if (chambre.isPresent()) {
            Chambre updatedChambre = chambre.get();
            updatedChambre.setType(chambreDetails.getType());
            updatedChambre.setPrix(chambreDetails.getPrix());
            updatedChambre.setDisponible(chambreDetails.isDisponible());
            updatedChambre.setReservations(chambreDetails.getReservations());
            chambreRepository.save(updatedChambre);
            return ResponseEntity.ok(updatedChambre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChambre(@PathVariable Long id) {
        Optional<Chambre> chambre = chambreRepository.findById(id);
        if (chambre.isPresent()) {
            chambreRepository.delete(chambre.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
