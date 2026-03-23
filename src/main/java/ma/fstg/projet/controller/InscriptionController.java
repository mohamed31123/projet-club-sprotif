package ma.fstg.projet.controller;

import ma.fstg.projet.entities.Inscription;
import ma.fstg.projet.repositoy.ActiviteRepository;
import ma.fstg.projet.repositoy.InscriptionRepository;
import ma.fstg.projet.repositoy.MembreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InscriptionController {

    private final InscriptionRepository inscriptionRepository;
    private final ActiviteRepository activiteRepository;
    private final MembreRepository membreRepository;

    public InscriptionController(
            InscriptionRepository inscriptionRepository,
            ActiviteRepository activiteRepository,
            MembreRepository membreRepository) {

        this.inscriptionRepository = inscriptionRepository;
        this.activiteRepository = activiteRepository;
        this.membreRepository = membreRepository;
    }

    @GetMapping("/inscriptions")
    public String list(Model model){

        model.addAttribute("inscriptions",inscriptionRepository.findAll());
        model.addAttribute("activites",activiteRepository.findAll());
        model.addAttribute("membres",membreRepository.findAll());

        return "inscriptions";
    }

    @PostMapping("/inscriptions")
    public String save(Inscription inscription){

        inscriptionRepository.save(inscription);
        return "redirect:/inscriptions";
    }

}