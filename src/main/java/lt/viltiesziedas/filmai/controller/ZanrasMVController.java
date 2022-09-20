package lt.viltiesziedas.filmai.controller;

import lt.viltiesziedas.filmai.model.entity.Zanras;
import lt.viltiesziedas.filmai.model.repository.ZanrasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ZanrasMVController {
    @Autowired
    ZanrasRepository zanrasRepository;

    @GetMapping("/zanrai/visi_zanrai")
    String rodytiVisusZanrus(Model model){
        List<Zanras> filmoZanrai = zanrasRepository.findAll();
        model.addAttribute("filmoZanrai", filmoZanrai);
        return "visi_zanrai";
    }

    @GetMapping("/zanrai/rodyti_filmus")
    String rodytiZanroFilmus(Model model, @RequestParam int id){
        Zanras zanras = zanrasRepository.findById(id);
        model.addAttribute("zanroFilmai", zanras.getZanroFilmai());
        model.addAttribute("zanroPavadinimas", zanras.getPavadinimas());
        return "zanro_filmai";
    }

    @GetMapping("/zanrai/prideti_zanra")
    String pridetiZanra(Model model){
        return "prideti_zanra";
    }

    @PostMapping("/zanrai/pridetas_zanras")
    String pridetasZanras(@RequestParam String pavadinimas){
        Zanras naujasZanras = new Zanras();
        naujasZanras.setPavadinimas(pavadinimas);
        zanrasRepository.save(naujasZanras);
        return "sekmingai_pridetas_zanras";
    }
}
