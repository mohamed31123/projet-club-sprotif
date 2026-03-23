package ma.fstg.projet.controller;


import ma.fstg.projet.entities.Membre;
import ma.fstg.projet.repositoy.MembreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MembreController {

    private final MembreRepository membreRepository;

    public MembreController(MembreRepository membreRepository){
        this.membreRepository = membreRepository;
    }

    @GetMapping("/membres")
    public String list(Model model){
        model.addAttribute("membres",membreRepository.findAll());
        return "membres";
    }

    @PostMapping("/membres")
    public String save(Membre membre){
        membreRepository.save(membre);
        return "redirect:/membres";
    }

}