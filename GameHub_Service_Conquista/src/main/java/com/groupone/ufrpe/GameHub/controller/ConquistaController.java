package com.groupone.ufrpe.GameHub.controller;

import com.groupone.ufrpe.GameHub.model.conquista.Conquista;
import com.groupone.ufrpe.GameHub.model.conquista.ConquistaRepository;
import com.groupone.ufrpe.GameHub.model.conquista.ConquistaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conquistas")
public class ConquistaController {
    @Autowired
    private ConquistaRepository conquistaRepository;

    @GetMapping
    public List<Conquista> getAllConquistas() {
        return conquistaRepository.findAll();
    }

    @PostMapping
    public Conquista createConquista(@RequestBody ConquistaRequest request) {
        Conquista conquista = new Conquista();
        conquista.setNomeConquista(request.getNomeConquista());
        conquista.setProgresso(request.getProgresso());
        conquista.setConcluida(request.isConcluida());
        conquista.setJogoId(request.getJogoId());
        System.out.println("THE VALUE COMING FROM FRONTED IS --->" + request.getJogoId());
        return conquistaRepository.save(conquista);
    }

    @GetMapping("/by-jogo/{jogoId}")
    public List<Conquista> getByJogoId(@PathVariable Long jogoId) {
        return conquistaRepository.findByJogoId(jogoId);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Conquista> getConquistaById(@PathVariable Long id) {
        return conquistaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conquista> updateConquista(
            @PathVariable Long id,
            @RequestBody ConquistaRequest request) {
        return conquistaRepository.findById(id)
                .map(existing -> {
                    existing.setNomeConquista(request.getNomeConquista());
                    existing.setProgresso(request.getProgresso());
                    existing.setConcluida(request.isConcluida());
                    existing.setJogoId(request.getJogoId());
                    return ResponseEntity.ok(conquistaRepository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteConquista(@PathVariable Long id) {
        return conquistaRepository.findById(id)
                .map(conquista -> {
                    conquistaRepository.delete(conquista);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Conquista> searchConquistas(@RequestParam String nome) {
        return conquistaRepository.findByNomeConquistaContainingIgnoreCase(nome);
    }

    @GetMapping("/status/{concluida}")
    public List<Conquista> getByCompletionStatus(@PathVariable boolean concluida) {
        return conquistaRepository.findByConcluida(concluida);
    }

    @GetMapping("/progress")
    public List<Conquista> getByProgressRange(
            @RequestParam(required = false) Integer min,
            @RequestParam(required = false) Integer max) {
        if (min != null && max != null) {
            return conquistaRepository.findByProgressoBetween(min, max);
        } else if (min != null) {
            return conquistaRepository.findByProgressoGreaterThanEqual(min);
        } else if (max != null) {
            return conquistaRepository.findByProgressoLessThanEqual(max);
        }
        return conquistaRepository.findAll();
    }

    @GetMapping("/count")
    public Long getConquistaCount() {
        return conquistaRepository.count();
    }

    @GetMapping("/paginated")
    public Page<Conquista> getPaginatedConquistas(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return conquistaRepository.findAll(PageRequest.of(page, size));
    }
}
