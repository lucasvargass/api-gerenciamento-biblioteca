package com.lucasvargas.dev.api_gerenciamento_biblioteca.controller;

import com.lucasvargas.dev.api_gerenciamento_biblioteca.model.AutorModel;
import com.lucasvargas.dev.api_gerenciamento_biblioteca.service.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/autor")
@RequiredArgsConstructor
public class AutorController {

    private final AutorService autorService;

    @PostMapping
    public ResponseEntity<String> cadastrarAutor(@RequestBody AutorModel autorCadastrado){
        autorService.cadastrarAutor(autorCadastrado);
        return ResponseEntity.ok("O Autor criado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<AutorModel>> buscarAutor(){
        return ResponseEntity.ok(autorService.listarTodosAutores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorModel> buscarAutorById(@PathVariable Long id){
        return ResponseEntity.ok(autorService.buscarAutorPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarAutor(@PathVariable Long id, @RequestBody AutorModel autorAtualizar){
        autorService.atualizarAutor(id, autorAtualizar);
        return ResponseEntity.ok("O Autor editado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAutor(@PathVariable Long id){
        autorService.deletarAutor(id);
        return ResponseEntity.ok("O Autor deletado com sucess!");
    }

}
