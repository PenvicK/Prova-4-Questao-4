package com.br.questao4.prova4.services;

import com.br.questao4.prova4.entities.Produtos;
import com.br.questao4.prova4.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produtos> findAll() {
        List<Produtos> result = repository.findAll();
        return result.stream().map(p -> new Produtos(p)).collect(Collectors.toList());
    }

    public Produtos findById(Long id) {
        Optional<Produtos> result = repository.findById(id);
        return result.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "PRODUCT NOT FOUND"));
    }

    public Produtos saveProdutos(Produtos entity){
        repository.save(entity);
        return entity;
    }

    public Produtos editProdutos(Long id, Produtos entity){
        Produtos obj = findById(id);
        obj.setNome(entity.getNome());
        obj.setPreco(entity.getPreco());
        obj.setEmpresasList(entity.getEmpresasList());

        repository.save(obj);
        return obj;
    }


    public void deleteByID(Long id){
        repository.delete(findById(id));
    }
}
