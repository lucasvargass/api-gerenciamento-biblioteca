package com.lucasvargas.dev.api_gerenciamento_biblioteca.service;

import com.lucasvargas.dev.api_gerenciamento_biblioteca.model.AutorModel;
import com.lucasvargas.dev.api_gerenciamento_biblioteca.model.LivroModel;
import com.lucasvargas.dev.api_gerenciamento_biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.apache.el.lang.ELArithmetic;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.LongFunction;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorService autorService;

    public void cadastrarLivro(LivroModel livroModel){
        livroRepository.save(livroModel);
    }

    public List<LivroModel> listarTodosLivros(){
        return livroRepository.findAll();
    }

    public LivroModel buscarLivroPorId(Long id){
        return livroRepository.findById(id).orElseThrow(() ->
                new RuntimeException("O livro não foi encontrado!")
        );
    }

    public void atualizarLivro(Long id, LivroModel livroAtualizar){
        LivroModel livroBase = buscarLivroPorId(id);
        livroBase.setTitulo(livroAtualizar.getTitulo());
        livroBase.setAnoPublicacao(livroAtualizar.getAnoPublicacao());
        livroBase.setSobre(livroAtualizar.getSobre());
        livroBase.setLinguaOriginal(livroAtualizar.getLinguaOriginal());
        livroBase.setQuantidadePaginas(livroAtualizar.getQuantidadePaginas());

        AutorModel autorBanco = autorService.buscarAutorPorId(livroAtualizar.getAutorModel().getId());
        livroBase.setAutorModel(autorBanco);

        livroRepository.save(livroBase);
    }

    public void deletarLivro(Long id){
        Optional<LivroModel> livroDeletado = livroRepository.findById(id);
        if (livroDeletado.isEmpty()){
            throw new RuntimeException("O livro não foi encontrado!");
        }else {
            livroRepository.deleteById(id);
        }
    }
}
