package com.groupone.ufrpe.GameHub.model.conquista;

import lombok.Data;

@Data
public class ConquistaRequest {
    private String NomeConquista;
    private int Progresso;
    private boolean Concluida;
    private Long jogoId;
}
