package com.example.projeto.controller;

import com.example.projeto.model.Produto;
import com.example.projeto.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final ProdutoRepository repo;
    public ProdutoController(ProdutoRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Produto> listar() { return repo.findAll(); }

    @PostMapping
    public Produto criar(@RequestBody Produto p) { return repo.save(p); }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) { return repo.findById(id).orElse(null); }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto p) { p.setId(id); return repo.save(p); }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { repo.deleteById(id); }
}