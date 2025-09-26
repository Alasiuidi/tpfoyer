package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level =AccessLevel.PRIVATE)
public class Reservation {
    @Id
     String idReservation;

    @Temporal(TemporalType.DATE)
     Date anneeUniversitaire;
     Boolean estValide;
     @ManyToMany(cascade = CascadeType.ALL)
    Set<Etudiant> etudiants;
}
