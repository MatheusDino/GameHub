package com.groupone.ufrpe.GameHub.model.conquista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConquistaController {

    @Autowired
    private ConquistaCollection conquistaCollection;

    public void create(ConquistaDTO conquistaDTO) {
        conquistaCollection.insert(conquistaDTO.toEntity());
    }

    public Iterable<Conquista> getAllConquistas() {
        return conquistaCollection.getAllConquistas();
    }
}
