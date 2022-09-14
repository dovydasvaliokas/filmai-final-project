package lt.viltiesziedas.filmai.controller;

import lt.viltiesziedas.filmai.model.entity.Filmas;
import lt.viltiesziedas.filmai.model.repository.FilmasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FilmasMVController {

    @Autowired
    FilmasRepository filmasRepository;

    @GetMapping("/test/sveikinimas")
    String testineFunkcija(Model model, @RequestParam String vardas){
        model.addAttribute("vardas",vardas);
        return "testinis_puslapis.html";
    }

    @GetMapping("/test/visi_filmaiCat")
    String rodytiVisusFilmuKazka(Model model){
        List<Filmas> visiFilmaiCat = filmasRepository.findAll();
        model.addAttribute("visiFilmaiCat", visiFilmaiCat);
        return "visi_filmaiCat";
    }

    @GetMapping("/filmai/informacija")
    String rodytiFilmoInformacija(Model model, @RequestParam String pavadinimas){
        Filmas filmas = filmasRepository.findByPavadinimas(pavadinimas);
        model.addAttribute("pavadinimas", filmas.getPavadinimas());
        model.addAttribute("metai", filmas.getMetai());
        model.addAttribute("filmoRezisierius", filmas.getFilmoRezisierius());
        model.addAttribute("filmoZanrai", filmas.getFilmoZanrai());
        model.addAttribute("trukmeMin", filmas.getTrukmeMin());
        model.addAttribute("imdbRating", filmas.getImdbRating());
        model.addAttribute("aprasymas", filmas.getAprasymas());
        return "filmo_informacija";
    }
}