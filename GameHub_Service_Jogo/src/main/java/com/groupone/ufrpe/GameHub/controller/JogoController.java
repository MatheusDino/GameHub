package com.groupone.ufrpe.GameHub.controller;


import com.groupone.ufrpe.GameHub.model.conquista.ConquistaDTO;
import com.groupone.ufrpe.GameHub.model.jogo.Jogo;
import com.groupone.ufrpe.GameHub.model.jogo.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private final DiscoveryClient discoveryClient;

    @Autowired
    public JogoController(JogoRepository jogoRepository, RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.jogoRepository = jogoRepository;
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
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
            List<ServiceInstance> instances = discoveryClient.getInstances("conquista-service");
            if (instances.isEmpty()) {
                return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                        .body("Conquista service not available");
            }
            ServiceInstance instance = instances.get(0);
            String url = String.format("%s/conquistas/by-jogo/%d",
                    instance.getUri().toString(),
                    id);

            System.out.println("Attempting to call: " + url); //debug

            ResponseEntity<List<ConquistaDTO>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    }
            );

            System.out.println("Received response: " + response.getStatusCode()); //debug
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

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> getJogoById(@PathVariable Long id) {
        return jogoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> updateJogo(@PathVariable Long id, @RequestBody Jogo jogoDetails) {
        return jogoRepository.findById(id)
                .map(existingJogo -> {
                    existingJogo.setNomeJogo(jogoDetails.getNomeJogo());
                    existingJogo.setGenero(jogoDetails.getGenero());
                    existingJogo.setPublisher(jogoDetails.getPublisher());
                    Jogo updatedJogo = jogoRepository.save(existingJogo);
                    return ResponseEntity.ok(updatedJogo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJogo(@PathVariable Long id) {
        return jogoRepository.findById(id)
                .map(jogo -> {
                    jogoRepository.delete(jogo);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Jogo> searchJogosByName(@RequestParam String nome) {
        return jogoRepository.findByNomeJogoContainingIgnoreCase(nome);
    }

    @GetMapping("/genre/{genero}")
    public List<Jogo> getJogosByGenre(@PathVariable String genero) {
        return jogoRepository.findByGeneroIgnoreCase(genero);
    }

    @GetMapping("/publisher/{publisher}")
    public List<Jogo> getJogosByPublisher(@PathVariable String publisher) {
        return jogoRepository.findByPublisherIgnoreCase(publisher);
    }

    @GetMapping("/count")
    public Long getJogoCount() {
        return jogoRepository.count();
    }

    @GetMapping("/paginated")
    public Page<Jogo> getPaginatedJogos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return jogoRepository.findAll(PageRequest.of(page, size));
    }
}
