package tn.esprit.tpfoyer.Control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.services.IUniversiteService;
import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;
@Tag(name = "Gestion des Universités", description = "API pour la gestion des universités")
@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {
    IUniversiteService universiteService;
    @Operation(
            summary = "Récupérer toutes les universités",
            description = "Cette méthode permet de récupérer la liste complète des universités enregistrées dans la base de données."
    )
    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversites() {
        return universiteService.retrieveAllUniversites();
    }
    @Operation(
            summary = "Récupérer une université par ID",
            description = "Cette méthode permet de récupérer une université spécifique en fournissant son ID."
    )
    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long universiteId) {
        return universiteService.retrieveUniversite(universiteId);
    }
    @Operation(
            summary = "Ajouter une nouvelle université",
            description = "Cette méthode permet d'ajouter une nouvelle université à la base de données."
    )
    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite u) {
        return universiteService.addUniversite(u);
    }
    @Operation(
            summary = "Supprimer une université",
            description = "Cette méthode permet de supprimer une université en fournissant son ID."
    )
    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long universiteId) {
        universiteService.removeUniversite(universiteId);
    }
    @Operation(
            summary = "Modifier une université",
            description = "Cette méthode permet de mettre à jour les informations d'une université existante."
    )
    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite universite) {
        return universiteService.modifyUniversite(universite);
    }
}
