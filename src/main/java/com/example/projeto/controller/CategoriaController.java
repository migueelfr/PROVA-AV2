package com.example.projeto.controller;

import com.example.projeto.model.Categoria;
import com.example.projeto.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    private final CategoriaRepository repo;
    public CategoriaController(CategoriaRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Categoria> listar() { return repo.findAll(); }

    @PostMapping
    public Categoria criar(@RequestBody Categoria c) { return repo.save(c); }

    @GetMapping("/{id}")
    public Categoria buscar(@PathVariable Long id) { return repo.findById(id).orElse(null); }

    @PutMapping("/{id}")
    public Categoria atualizar(@PathVariable Long id, @RequestBody Categoria c) { c.setId(id); return repo.save(c); }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { repo.deleteById(id); }
}