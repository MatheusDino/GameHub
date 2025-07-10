package com.groupone.ufrpe.GameHub.model;

import com.groupone.ufrpe.GameHub.model.conquista.Conquista;
import com.groupone.ufrpe.GameHub.model.conquista.ConquistaController;
import com.groupone.ufrpe.GameHub.model.conquista.ConquistaDTO;
import com.groupone.ufrpe.GameHub.model.jogo.Jogo;
import com.groupone.ufrpe.GameHub.model.jogo.JogoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Facade {

    @Autowired private JogoController jogoController;
    @Autowired private ConquistaController conquistaController;

    public void insertConquista(ConquistaDTO conquistaDTO) {
        conquistaController.create(conquistaDTO);
    }

    public Iterable<Conquista> getConquistas() {
        return conquistaController.getAllConquistas();
    }

    public void insertJogo(Jogo jogo) {
        jogoController.create(jogo);
    }

    public Iterable<Jogo> getJogos() {
        return jogoController.getJogos();
    }
}
