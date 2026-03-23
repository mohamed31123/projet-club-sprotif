package ma.fstg.projet.repositoy;



import ma.fstg.projet.entities.Activitie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ActiviteRepository extends JpaRepository<Activitie,Long>{

    List<Activitie> findByNiveau(String niveau);

}
