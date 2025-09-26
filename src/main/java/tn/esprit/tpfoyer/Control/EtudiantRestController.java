package tn.esprit.tpfoyer.Control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.services.IEtudiantService;
import tn.esprit.tpfoyer.entity.Etudiant;

import java.util.List;
@Tag(name = "Gestion des Étudiants", description = "API pour la gestion des étudiants")
@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
    @Autowired
    IEtudiantService etudiantService;
    @Operation(
            summary = "Récupérer tous les étudiants",
            description = "Cette méthode permet de récupérer la liste de tous les étudiants enregistrés dans la base de données."
    )
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
        return etudiantService.retrieveAllEtudiants();
    }
    @Operation(
            summary = "Récupérer un étudiant par ID",
            description = "Cette méthode permet de récupérer un étudiant spécifique en fournissant son ID."
    )
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        return etudiantService.retrieveEtudiant(etudiantId);
    }
    @Operation(
            summary = "Ajouter un nouvel étudiant",
            description = "Cette méthode permet d'ajouter un nouvel étudiant à la base de données."
    )
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return etudiantService.addEtudiant(e);
    }
    @Operation(
            summary = "Supprimer un étudiant",
            description = "Cette méthode permet de supprimer un étudiant en fournissant son ID."
    )
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        etudiantService.removeEtudiant(etudiantId);
    }
    @Operation(
            summary = "Modifier un étudiant",
            description = "Cette méthode permet de mettre à jour les informations d'un étudiant existant."
    )
    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.modifyEtudiant(etudiant);
    }
}
