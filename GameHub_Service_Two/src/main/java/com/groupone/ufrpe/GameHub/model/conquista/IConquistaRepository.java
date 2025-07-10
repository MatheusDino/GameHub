package com.groupone.ufrpe.GameHub.model.conquista;

public interface IConquistaRepository {
    void insert(Conquista conquista);

    void remove(Conquista conquista);

    Iterable<Conquista> getAllConquistas();

    Conquista getConquista(Long id);
}
