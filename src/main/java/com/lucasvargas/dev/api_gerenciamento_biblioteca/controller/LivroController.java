package com.lucasvargas.dev.api_gerenciamento_biblioteca.controller;

import com.lucasvargas.dev.api_gerenciamento_biblioteca.model.LivroModel;
import com.lucasvargas.dev.api_gerenciamento_biblioteca.repository.LivroRepository;
import com.lucasvargas.dev.api_gerenciamento_biblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.LongFunction;

@RestController
@RequestMapping("/v1/livro")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<String> cadastrarLivro(@RequestBody LivroModel livroCadastrado){
        livroService.cadastrarLivro(livroCadastrado);
        return ResponseEntity.ok("O Livro foi cadastrado com sucesso");
    }

    @GetMapping
    public ResponseEntity<List<LivroModel>> buscarLivro(){
        return ResponseEntity.ok(livroService.listarTodosLivros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroModel> buscarLivroById (@PathVariable Long id){
        return ResponseEntity.ok(livroService.buscarLivroPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarLivro(@PathVariable Long id, @RequestBody LivroModel livroAtualizar){
        livroService.atualizarLivro(id, livroAtualizar);
        return ResponseEntity.ok("O Livro foi atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarLivro(@PathVariable Long id){
        livroService.deletarLivro(id);
        return ResponseEntity.ok("O Livro foi deletado com sucesso!");
    }
}
