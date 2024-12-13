package isme.rest.Controllers;

import isme.rest.Models.Utilisateur;
import isme.rest.Repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        return utilisateur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateurDetails) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if (utilisateur.isPresent()) {
            Utilisateur updatedUtilisateur = utilisateur.get();
            updatedUtilisateur.setNomUtilisateur(utilisateurDetails.getNomUtilisateur());
            updatedUtilisateur.setMotDePasse(utilisateurDetails.getMotDePasse());
            updatedUtilisateur.setRole(utilisateurDetails.getRole());
            updatedUtilisateur.setReservations(utilisateurDetails.getReservations());
            utilisateurRepository.save(updatedUtilisateur);
            return ResponseEntity.ok(updatedUtilisateur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if (utilisateur.isPresent()) {
            utilisateurRepository.delete(utilisateur.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
