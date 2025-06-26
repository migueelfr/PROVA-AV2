package com.example.projeto.service;

import com.example.projeto.model.Categoria;
import com.example.projeto.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public List<Categoria> listarTodos() {
        return listarTodas();
    }

    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(Long id, Categoria categoriaAtualizada) {
        return categoriaRepository.findById(id)
                .map(categoria -> {
                    categoria.setNome(categoriaAtualizada.getNome());
                    categoria.setDescricao(categoriaAtualizada.getDescricao());
                    return categoriaRepository.save(categoria);
                })
                .orElse(null);
    }

    public boolean deletar(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
} 