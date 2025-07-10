package com.groupone.ufrpe.GameHub.model.conquista;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Conquista {
    @Id
    @GeneratedValue
    private Long ID_Conquista;
//    private Jogo Jogo_Pertencentente;
    private String NomeConquista;
    private int Progresso;
    private boolean Concluida;
}
