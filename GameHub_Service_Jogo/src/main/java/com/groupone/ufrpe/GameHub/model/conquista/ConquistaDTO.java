package com.groupone.ufrpe.GameHub.model.conquista;

import lombok.Data;

@Data
public class ConquistaDTO {
    private String nomeConquista;
    private int progresso;
    private boolean concluida;
    private Long jogoId;
}
