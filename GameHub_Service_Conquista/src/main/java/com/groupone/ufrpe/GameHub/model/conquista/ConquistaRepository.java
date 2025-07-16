package com.groupone.ufrpe.GameHub.model.conquista;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConquistaRepository  extends JpaRepository<Conquista, Long> {
    List<Conquista> findByJogoId(Long jogoId);
    List<Conquista> findByNomeConquistaContainingIgnoreCase(String nomeConquista);
    List<Conquista> findByConcluida(boolean concluida);
    List<Conquista> findByProgressoBetween(int min, int max);
    List<Conquista> findByProgressoGreaterThanEqual(int min);
    List<Conquista> findByProgressoLessThanEqual(int max);
}
