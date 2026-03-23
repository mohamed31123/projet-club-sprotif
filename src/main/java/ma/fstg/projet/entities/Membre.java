package ma.fstg.projet.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String categorie;
    private LocalDate dateAdhesion;
    @OneToMany(mappedBy = "memebre",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Inscription> inscriptions;

}