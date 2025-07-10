package com.groupone.ufrpe.GameHub.controller;

import com.groupone.ufrpe.GameHub.model.Facade;
import com.groupone.ufrpe.GameHub.model.jogo.Jogo;
import com.groupone.ufrpe.GameHub.model.jogo.JogoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/jogo")
public class JogoRestController {

//    @Autowired private Facade facade;

    @Autowired private JogoController jogoController;
    @Autowired private DiscoveryClient discoveryClient;

    @Value("${base_url}")
    private String baseUrl;

    @ModelAttribute("baseUrl")
    public String getUrl() {
        return this.baseUrl;
    }

    @ModelAttribute("conquistaUrl")
    private String getConquistaUrl() {
        ServiceInstance sInstance = discoveryClient.getInstances("conquista").iterator().next();
        return String.format("%s://%s:%s", sInstance.getScheme(), sInstance.getHost(), sInstance.getPort());
    }

    @GetMapping("/home")
    public String getJogos(Model model) {
        model.addAttribute("jogos", jogoController.getJogos());
        return "jogos";
    }

    @PostMapping("/home")
    public String newJogo(@ModelAttribute Jogo jogo) {
        jogoController.create(jogo);
        return "redirect:/jogo";
    }
}
