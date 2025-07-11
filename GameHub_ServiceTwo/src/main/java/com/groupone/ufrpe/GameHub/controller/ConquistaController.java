package com.groupone.ufrpe.GameHub.controller;

import com.groupone.ufrpe.GameHub.model.conquista.Conquista;
import com.groupone.ufrpe.GameHub.model.conquista.ConquistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conquistas")
public class ConquistaController {
    @Autowired
    private ConquistaRepository conquistaRepository;

    @GetMapping
    public List<Conquista> getAllConquistas() {
        return conquistaRepository.findAll();
    }

    @PostMapping
    public Conquista createConquista(@RequestBody Conquista conquista) {
        return conquistaRepository.save(conquista);
    }
}
