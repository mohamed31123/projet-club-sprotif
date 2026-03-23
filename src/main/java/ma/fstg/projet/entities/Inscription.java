package ma.fstg.projet.entities;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateInscription;
    private String statut;
    private double montant;

    @ManyToOne
    private Activitie activitie;

    @ManyToOne
    private Membre membre;

}