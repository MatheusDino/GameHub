package com.groupone.ufrpe.GameHub.controller;


import com.groupone.ufrpe.GameHub.model.conquista.ConquistaDTO;
import com.groupone.ufrpe.GameHub.model.jogo.Jogo;
import com.groupone.ufrpe.GameHub.model.jogo.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("jogos")
public class JogoController {

    private final JogoRepository jogoRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public JogoController(JogoRepository jogoRepository, RestTemplate restTemplate) {
        this.jogoRepository = jogoRepository;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<Jogo> getAllJogos() {
        return jogoRepository.findAll();
    }

    @PostMapping
    public Jogo createJogo(@RequestBody Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    @GetMapping("/{id}/conquistas")
    public ResponseEntity<?> getConquistasByJogo(@PathVariable Long id) {
        try {
            String url = "http://CONQUISTA-SERVICE/conquistas/by-jogo/" + id;

            // Add debug logging
            System.out.println("Attempting to call: " + url);

            ResponseEntity<List<ConquistaDTO>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<ConquistaDTO>>() {
                    }
            );

            System.out.println("Received response: " + response.getStatusCode());
            return ResponseEntity.ok(response.getBody());

        } catch (HttpClientErrorException e) {
            System.err.println("Client error: " + e.getRawStatusCode() + " - " + e.getResponseBodyAsString());
            return ResponseEntity.status(e.getRawStatusCode()).body(e.getResponseBodyAsString());
        } catch (Exception e) {
            System.err.println("Communication failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("Conquista service communication error: " + e.getMessage());
        }
    }
}
