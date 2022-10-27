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

    @PostMapping("/komentarai/naujas_komentaras/{id}")
    String issaugotiKomentara(@ModelAttribute Komentaras pridedamasKomentaras, @RequestParam String komentaras, @PathVariable int id){
        pridedamasKomentaras.setVartotojoKomentaras(vartotojasRepository.findById(1));
        pridedamasKomentaras.setKomentaras(komentaras);
        pridedamasKomentaras.setKomentarasFilmui(filmasRepository.findById(id));
        komentarasRepository.save(pridedamasKomentaras);
        return "filmo_informacija";
    }
}
