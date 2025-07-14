package com.groupone.ufrpe.GameHub.controller;

import com.groupone.ufrpe.GameHub.model.conquista.Conquista;
import com.groupone.ufrpe.GameHub.model.conquista.ConquistaRepository;
import com.groupone.ufrpe.GameHub.model.conquista.ConquistaRequest;
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
    public Conquista createConquista(@RequestBody ConquistaRequest request) {
        Conquista conquista = new Conquista();
        conquista.setNomeConquista(request.getNomeConquista());
        conquista.setProgresso(request.getProgresso());
        conquista.setConcluida(request.isConcluida());
        conquista.setJogoId(request.getJogoId());
        System.out.println("THE VALUE COMING FROM FRONTED IS --->" + request.getJogoId());
        return conquistaRepository.save(conquista);
    }

    @GetMapping("/by-jogo/{jogoId}")
    public List<Conquista> getByJogoId(@PathVariable Long jogoId) {
        return conquistaRepository.findByJogoId(jogoId);
    }
}
