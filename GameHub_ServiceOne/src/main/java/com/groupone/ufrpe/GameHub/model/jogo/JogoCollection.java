package com.groupone.ufrpe.GameHub.model.jogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JogoCollection {

    @Autowired private IJogoRepository jogoRepository;

    public void insert(Jogo jogo) {
        jogoRepository.insert(jogo);
    }
    public void remove(Jogo jogo) {
        jogoRepository.remove(jogo);
    }
    public Iterable<Jogo> getAllJogos() {
        return jogoRepository.getAllJogos();
    }
}
