package com.groupone.ufrpe.GameHub.model.jogo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface JogoDAO extends CrudRepository<Jogo, Long> {
    @Query("SELECT j FROM Jogo j")
    List<Jogo> getAllJogos();
}