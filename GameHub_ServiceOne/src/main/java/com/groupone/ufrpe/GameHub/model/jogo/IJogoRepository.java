package com.groupone.ufrpe.GameHub.model.jogo;

public interface IJogoRepository {
    void insert(Jogo jogo);

    void remove(Jogo jogo);

    Iterable<Jogo> getAllJogos();
}
