package ma.fstg.projet.repositoy;



import ma.fstg.projet.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription,Long>{

    List<Inscription> findByDateInscriptionBetween(LocalDate d1, LocalDate d2);

}