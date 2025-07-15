package com.groupone.ufrpe.GameHub.model.conquista;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConquistaRepository  extends JpaRepository<Conquista, Long> {
    List<Conquista> findByJogoId(Long jogoId);
}
