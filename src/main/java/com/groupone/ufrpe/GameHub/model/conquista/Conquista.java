package com.groupone.ufrpe.GameHub.model.conquista;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Conquista {
    @Id
    @GeneratedValue
    private Long ID_Conquista;
    private String NomeConquista;
    private int Progresso;
    private boolean Concluida;
}
