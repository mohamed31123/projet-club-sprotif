package ma.fstg.projet.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "activities")
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Activitie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String niveau;
    private int capacite;
    @OneToMany(mappedBy = "activitie",fetch = FetchType.LAZY)
    private List<Inscription> inscriptions;

}
