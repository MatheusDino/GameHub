package com.groupone.ufrpe.GameHub.model.conquista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConquistaCollection {

    @Autowired private IConquistaRepository conquistaRepository;

    public void insert(Conquista conquista) {
        conquistaRepository.insert(conquista);
    }

    public void remove(Conquista conquista) {
        conquistaRepository.remove(conquista);
    }

    public Iterable<Conquista> getAllConquistas() {
        return conquistaRepository.getAllConquistas();
    }

    public Conquista getConquista(Long id) {
        return conquistaRepository.getConquista(id);
    }
}
