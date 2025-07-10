package com.groupone.ufrpe.GameHub.model.jogo;

import lombok.Data;

@Data
public class JogoDTO {
    private String NomeJogo;
    private String Genero;
    private String Publisher;

    public Jogo toEntity() {
        return Jogo.builder()
                .NomeJogo(this.NomeJogo)
                .Genero(this.Genero)
                .Publisher(this.Publisher)
                .build();
    }
}
