package com.groupone.ufrpe.GameHub.model.jogo;

import com.groupone.ufrpe.GameHub.model.conquista.ConquistaCollection;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JogoController {

    @Autowired private ConquistaCollection conquistaCollection;
    @Autowired private JogoCollection jogoCollection;

    public Iterable<Jogo> getJogos() {
        return jogoCollection.getAllJogos();
    }

    //todo yet
}
