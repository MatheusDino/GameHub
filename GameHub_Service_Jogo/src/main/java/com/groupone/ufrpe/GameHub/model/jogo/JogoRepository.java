package com.groupone.ufrpe.GameHub.model.jogo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
    List<Jogo> findByNomeJogoContainingIgnoreCase(String nomeJogo);
    List<Jogo> findByGeneroIgnoreCase(String genero);
    List<Jogo> findByPublisherIgnoreCase(String publisher);
}
