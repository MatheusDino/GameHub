package com.groupone.ufrpe.GameHub.model.conquista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConquistaJPARepository implements IConquistaRepository {
    @Autowired private ConquistaDAO conquistaDAO;

    @Override
    public void insert(Conquista conquista) {
        conquistaDAO.save(conquista);
    }

    @Override
    public void remove(Conquista conquista) {
        conquistaDAO.delete(conquista);
    }

    @Override
    public Iterable<Conquista> getAllConquistas() {
        return conquistaDAO.findAll();
    }

    @Override
    public Conquista getConquista(Long id) {
        return conquistaDAO.findById(id).get();
    }
}
