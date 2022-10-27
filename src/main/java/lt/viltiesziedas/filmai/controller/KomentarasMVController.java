package lt.viltiesziedas.filmai.controller;

import lt.viltiesziedas.filmai.model.entity.Filmas;
import lt.viltiesziedas.filmai.model.entity.Komentaras;
import lt.viltiesziedas.filmai.model.entity.Vartotojas;
import lt.viltiesziedas.filmai.model.repository.FilmasRepository;
import lt.viltiesziedas.filmai.model.repository.KomentarasRepository;
import lt.viltiesziedas.filmai.model.repository.VartotojasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KomentarasMVController {

    @Autowired
    KomentarasRepository komentarasRepository;
    @Autowired
    FilmasRepository filmasRepository;
    @Autowired
    VartotojasRepository vartotojasRepository;

    @PostMapping("/komentarai/naujas_komentaras/{filmoId}")
    String issaugotiKomentara(Model model, @ModelAttribute Komentaras pridedamasKomentaras, @PathVariable int filmoId){
        System.out.println("pridedamasKomentaras = " + pridedamasKomentaras.getId());
        pridedamasKomentaras.setVartotojoKomentaras(vartotojasRepository.findById(1));
        Filmas filmas = filmasRepository.findById(filmoId);
        pridedamasKomentaras.setKomentarasFilmui(filmas);
        komentarasRepository.save(pridedamasKomentaras);
        model.addAttribute("pavadinimas", filmas.getPavadinimas());
        return "pridetas_komentaras.html";
    }
}
