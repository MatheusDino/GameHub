package com.groupone.ufrpe.GameHub.model.conquista;

import com.groupone.ufrpe.GameHub.model.jogo.JogoCollection;
import lombok.Value;

@Value
public class ConquistaDTO {
    private String NomeConquista;
    private int Progresso;
    private boolean Concluida;

    public Conquista toEntity() {
        return Conquista.builder()
                .NomeConquista(NomeConquista)
                .Progresso(Progresso)
                .Concluida(Concluida)
                .build();
    }
}
