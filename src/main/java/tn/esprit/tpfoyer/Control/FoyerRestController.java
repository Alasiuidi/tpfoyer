package tn.esprit.tpfoyer.Control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.services.IFoyerService;
import tn.esprit.tpfoyer.entity.Foyer;

import java.util.List;
@Tag(name = "Gestion des Foyers", description = "API pour la gestion des foyers")

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {
    @Autowired
     IFoyerService foyerService;
    @Operation(
            summary = "Récupérer tous les foyers",
            description = "Cette méthode permet de récupérer la liste de tous les foyers enregistrés dans la base de données."
    )
    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> getFoyers() {
        return foyerService.retrieveAllFoyers();
    }
    @Operation(
            summary = "Récupérer un foyer par ID",
            description = "Cette méthode permet de récupérer un foyer spécifique en fournissant son ID."
    )
    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long foyerId) {
        return foyerService.retrieveFoyer(foyerId);
    }
    @Operation(
            summary = "Ajouter un nouveau foyer",
            description = "Cette méthode permet d'ajouter un nouveau foyer à la base de données."
    )
    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer f) {
        return foyerService.addFoyer(f);
    }
    @Operation(
            summary = "Supprimer un foyer",
            description = "Cette méthode permet de supprimer un foyer en fournissant son ID."
    )
    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long foyerId) {
        foyerService.removeFoyer(foyerId);
    }
    @Operation(
            summary = "Modifier un foyer",
            description = "Cette méthode permet de mettre à jour les informations d'un foyer existant."
    )
    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer foyer) {
        return foyerService.modifyFoyer(foyer);
    }

    @Operation(summary = "Ajouter un foyer avec ses blocs", description = "Ajoute un nouveau foyer et les blocs associés")
    @PostMapping("/add-with-blocs")
    public Foyer addFoyerWithBlocs(@RequestBody Foyer foyer) {
        return foyerService.addFoyerWithBloc(foyer);
    }

    @PutMapping("/affecter-bloc-foyer/{idBloc}/{idFoyer}")
    public Bloc affecterBlocAFoyer(@PathVariable Long idBloc, @PathVariable Long idFoyer) {
        return foyerService.affecterBlocAFoyer(idBloc, idFoyer);
    }

    @PutMapping("/desaffecter-bloc-foyer/{idBloc}/{idFoyer}")
    public Bloc desaffecterBlocDeFoyer(@PathVariable Long idBloc, @PathVariable Long idFoyer) {
        return foyerService.desaffecterBlocDeFoyer(idBloc);
    }



}
