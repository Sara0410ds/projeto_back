package com.Discount.controller;

import com.Discount.model.Grupo;
import com.Discount.repository.GrupoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    private final GrupoRepository repository;

    public GrupoController(GrupoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Grupo> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Grupo buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Grupo criar(@RequestBody Grupo grupo) {
        return repository.save(grupo);
    }

    @PutMapping("/{id}")
    public Grupo atualizar(@PathVariable Long id, @RequestBody Grupo grupo) {
        grupo.setId(id);
        return repository.save(grupo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

