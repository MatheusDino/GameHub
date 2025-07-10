package com.groupone.ufrpe.GameHub.model.jogo;

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
public class Jogo {
    @Id
    @GeneratedValue
    Long ID_Jogo;
    private String NomeJogo;
    private String Genero;
    private String Publisher;

//    public Jogo() {}
//
//    public Jogo(String nomeJogo, String genero, String publisher) {
//        this.NomeJogo = nomeJogo;
//        this.Genero = genero;
//        this.Publisher = publisher;
//    }
//
//    public Long getID_Jogo() {
//        return ID_Jogo;
//    }
//
//    public void setID_Jogo(Long ID_Jogo) {
//        this.ID_Jogo = ID_Jogo;
//    }
//
//    public String getNomeJogo() {
//        return NomeJogo;
//    }
//
//    public void setNomeJogo(String nomeJogo) {
//        NomeJogo = nomeJogo;
//    }
//
//    public String getGenero() {
//        return Genero;
//    }
//
//    public void setGenero(String genero) {
//        Genero = genero;
//    }
//
//    public String getPublisher() {
//        return Publisher;
//    }
//
//    public void setPublisher(String publisher) {
//        Publisher = publisher;
//    }
}
