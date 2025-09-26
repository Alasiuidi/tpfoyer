package tn.esprit.tpfoyer.Control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.services.IBlocService;

import java.util.List;
@Tag(name = "Gestion Bloc", description = "API pour la gestion des blocs")
@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {

     IBlocService blocService;

    // http://localhost:8089/tpfoyer/bloc/retrieve-all-blocs
    @Operation(
            summary = "Récupérer tous les blocs",
            description = "Cette méthode permet de récupérer la liste de tous les blocs enregistrés dans la base de données."
    )
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        return blocService.retrieveAllBlocs();
    }

    // http://localhost:8089/tpfoyer/bloc/retrieve-bloc/8
    @Operation(
            summary = "Récupérer un bloc par ID",
            description = "Cette méthode permet de récupérer un bloc spécifique en fournissant son ID."
    )
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long blocId) {
        return blocService.retrieveBloc(blocId);
    }
    @Operation(
            summary = "Ajouter un nouveau bloc",
            description = "Cette méthode permet d'ajouter un nouveau bloc à la base de données."
    )
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        return blocService.addBloc(b);
    }
    @Operation(
            summary = "Supprimer un bloc",
            description = "Cette méthode permet de supprimer un bloc en fournissant son ID."
    )
    // http://localhost:8089/tpfoyer/bloc/remove-bloc/{bloc-id}
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long blocId) {
        blocService.removeBloc(blocId);
    }
    @Operation(
            summary = "Modifier un bloc",
            description = "Cette méthode permet de mettre à jour les informations d'un bloc existant."
    )
    // http://localhost:8089/tpfoyer/bloc/modify-bloc
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc b) {
        return blocService.modifyBloc(b);
    }
}