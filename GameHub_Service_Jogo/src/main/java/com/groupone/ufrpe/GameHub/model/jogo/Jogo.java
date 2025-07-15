package com.groupone.ufrpe.GameHub.model.jogo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Jogo;

    private String nomeJogo;
    private String genero;
    private String publisher;
}
