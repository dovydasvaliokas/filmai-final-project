package lt.viltiesziedas.filmai.controller;

import lt.viltiesziedas.filmai.model.entity.Filmas;
import lt.viltiesziedas.filmai.model.entity.Rezisierius;
import lt.viltiesziedas.filmai.model.repository.RezisieriusRepository;
import lt.viltiesziedas.filmai.model.repository.ZanrasRepository;
import lt.viltiesziedas.filmai.model.repository.FilmasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FilmasMVController{

    @Autowired
    FilmasRepository filmasRepository;
    @Autowired
    ZanrasRepository zanrasRepository;
    @Autowired
    RezisieriusRepository rezisieriusRepository;

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

    @GetMapping("/filmai/rasti")
    String rastiFilma(Model model){
        return "rasti_filma";
    }

    @GetMapping("/filmai/idejimas")
    String filmoIdejimas(Model model){
        Filmas filmas = new Filmas();
        model.addAttribute("filmas", filmas);
        model.addAttribute("filmoZanrai", zanrasRepository.findAll());
        return "prideti_filma";
    }

    @PostMapping("/filmai/pridetas_filmas")
        String pridetiFilma(@ModelAttribute Filmas pridedamasFilmas, @RequestParam String rastiRezisieriu){
            Rezisierius rezisierius = rezisieriusRepository.findByVardasPavarde(rastiRezisieriu);
            System.out.println(rastiRezisieriu);
            pridedamasFilmas.setFilmoRezisierius(rezisierius);
            filmasRepository.save(pridedamasFilmas);
            return "idetas_filmas";
    }

    @GetMapping("/filmai/filmo_redagavimas/{id}")
        String redaguotiFilma(Model model, @ModelAttribute Filmas redaguojamasFilmas, @RequestParam String rastiRezisieriu, @PathVariable int id){
            Filmas filmas = filmasRepository.findById(id);
            model.addAttribute("filmas", filmas);
            model.addAttribute("filmoZanrai", zanrasRepository.findAll());
            Rezisierius rezisierius = rezisieriusRepository.findByVardasPavarde(rastiRezisieriu);
            redaguojamasFilmas.setFilmoRezisierius(rezisierius);
            filmasRepository.save(redaguojamasFilmas);
            return "filmo_redagavimas";
    }
}
