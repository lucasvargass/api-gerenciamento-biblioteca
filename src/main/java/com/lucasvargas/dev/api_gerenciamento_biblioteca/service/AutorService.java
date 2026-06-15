package com.lucasvargas.dev.api_gerenciamento_biblioteca.service;

import com.lucasvargas.dev.api_gerenciamento_biblioteca.model.AutorModel;
import com.lucasvargas.dev.api_gerenciamento_biblioteca.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;

    public void cadastrarAutor(AutorModel autorModel){
        autorRepository.save(autorModel);
    }

    public List<AutorModel> listarTodosAutores(){
        return autorRepository.findAll();
    }

    public AutorModel buscarAutorPorId(Long id){
        return autorRepository.findById(id).orElseThrow(() ->
                new RuntimeException("O autor não encontrado!"));
    }

    public void atualizarAutor(Long id, AutorModel autorAtualizar){
        AutorModel autorBase = buscarAutorPorId(id);
        autorBase.setNome(autorAtualizar.getNome());
        autorBase.setSobre(autorAtualizar.getSobre());
        autorBase.setDataDeNascimento(autorAtualizar.getDataDeNascimento());
        autorBase.setNacionalidade(autorAtualizar.getNacionalidade());
        autorRepository.save(autorBase);
    }

    public void deletarAutor(Long id){
        Optional<AutorModel> autorDeletado = autorRepository.findById(id);
        if (autorDeletado.isEmpty()){
            throw new RuntimeException("O autor não foi encontrado!");
        }else {
            autorRepository.deleteById(id);
        }
    }
}
