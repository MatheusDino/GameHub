package com.groupone.ufrpe.GameHub.controller;


import com.groupone.ufrpe.GameHub.model.jogo.Jogo;
import com.groupone.ufrpe.GameHub.model.jogo.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jogos")
public class JogoController {
    @Autowired
    private JogoRepository jogoRepository;

    @GetMapping
    public List<Jogo> getAllJogos() {
        return jogoRepository.findAll();
    }

    @PostMapping
    public Jogo createJogo(@RequestBody Jogo jogo) {
        return jogoRepository.save(jogo);
    }
}
