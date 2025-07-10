package com.groupone.ufrpe.GameHub.controller;

import com.groupone.ufrpe.GameHub.model.conquista.ConquistaController;
import com.groupone.ufrpe.GameHub.model.conquista.ConquistaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/conquista")
@Slf4j
public class ConquistaRestController {

    @Autowired private ConquistaController conquistaController;

    @Value("$${base_url")
    private String baseUrl;

    @ModelAttribute("baseUrl")
    public String getUrl() {
        return this.baseUrl;
    }

//    @GetMapping("/jogo/{jogoId}")
//    public String getConquistas(@PathVariable(name = "jogoId") Long jogoId, Model model) {
//        model.addAttribute("conquista", conquistaController);
//    }
    @GetMapping("/jogo")
    public String getConquistas(Model model) {
        model.addAttribute("conquistas", conquistaController.getAllConquistas());
        return "conquistas";
    }

    @PostMapping("/home")
    public String newConquista(@ModelAttribute ConquistaDTO conquistaDTO) {
//            log.info(conquistaDTO.toString());
            try {
                conquistaController.create(conquistaDTO);
            } catch (Exception e) {
//                log.error(e.getMessage());
                return "redirect:/conquista/home";
            }
            return "redirect:/conquista/home";
    }
}