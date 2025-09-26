package tn.esprit.tpfoyer.Control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.services.IReservationService;
import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;
@Tag(name = "Gestion des Réservations", description = "API pour la gestion des réservations")
@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {

    @Autowired
    IReservationService reservationService;
    @Operation(
            summary = "Récupérer toutes les réservations",
            description = "Cette méthode permet de récupérer la liste de toutes les réservations enregistrées dans la base de données."
    )
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        return reservationService.retrieveAllReservations();
    }
    @Operation(
            summary = "Récupérer une réservation par ID",
            description = "Cette méthode permet de récupérer une réservation spécifique en fournissant son ID."
    )
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") String reservationId) {
        return reservationService.retrieveReservation(reservationId);
    }
    @Operation(
            summary = "Ajouter une nouvelle réservation",
            description = "Cette méthode permet d'ajouter une nouvelle réservation à la base de données."
    )
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation r) {
        return reservationService.addReservation(r);
    }
    @Operation(
            summary = "Supprimer une réservation",
            description = "Cette méthode permet de supprimer une réservation en fournissant son ID."
    )
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") String reservationId) {
        reservationService.removeReservation(reservationId);
    }
    @Operation(
            summary = "Modifier une réservation",
            description = "Cette méthode permet de mettre à jour les informations d'une réservation existante."
    )
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation reservation) {
        return reservationService.modifyReservation(reservation);
    }
}
