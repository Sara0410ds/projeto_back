package com.Discount.controller;

import com.Discount.model.Oferta;
import com.Discount.repository.OfertaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ofertas")
public class OfertaController {

    private final OfertaRepository repository;

    public OfertaController(OfertaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Oferta> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Oferta buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Oferta criar(@RequestBody Oferta oferta) {
        return repository.save(oferta);
    }

    @PutMapping("/{id}")
    public Oferta atualizar(@PathVariable Long id, @RequestBody Oferta oferta) {
        oferta.setId(id);
        return repository.save(oferta);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

