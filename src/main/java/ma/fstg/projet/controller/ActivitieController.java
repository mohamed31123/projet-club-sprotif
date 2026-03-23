package ma.fstg.projet.controller;

import ma.fstg.projet.entities.Activitie;
import ma.fstg.projet.repositoy.ActiviteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ActivitieController {
    private final ActiviteRepository activiteRepository;
    public ActivitieController(ActiviteRepository activiteRepository) {
        this.activiteRepository = activiteRepository;
    }
    @GetMapping("/activities")
    public String activites(Model model) {
        model.addAttribute("activites", activiteRepository.findAll());
        return "activities";
    }
    @PostMapping("/activites")
    public String save(Activitie activite){
        activiteRepository.save(activite);
        return "redirect:/activites";
    }
}
