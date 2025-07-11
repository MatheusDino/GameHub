package com.groupone.ufrpe.GameHub.model.conquista;

import lombok.Data;

@Data
public class ConquistaDTO {
    private Long id;
    private String nomeConquista;
    private int progresso;
    private boolean concluida;
    private Long jogoId;
}
