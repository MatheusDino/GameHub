package com.groupone.ufrpe.GameHub.model.jogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JogoJPARepository implements IJogoRepository {
    @Autowired
    private JogoDAO jogoDAO;

    @Override
    public void insert(Jogo jogo) {
        jogoDAO.save(jogo);
    }

    @Override
    public void remove(Jogo jogo) {
        jogoDAO.delete(jogo);
    }

    @Override
    public List<Jogo> getAllJogos() {
        return jogoDAO.getAllJogos();
    }
}