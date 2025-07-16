package com.groupone.ufrpe.GameHub.model.conquista;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conquista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Conquista;

    private String nomeConquista;
    private int progresso;
    private boolean concluida;

    private Long jogoId;
}