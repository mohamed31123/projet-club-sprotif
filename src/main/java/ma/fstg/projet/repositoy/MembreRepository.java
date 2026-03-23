package ma.fstg.projet.repositoy;


import ma.fstg.projet.entities.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MembreRepository extends JpaRepository<Membre,Long>{

    List<Membre> findByCategorie(String categorie);

}