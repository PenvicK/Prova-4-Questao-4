package com.br.questao4.prova4.services;

import com.br.questao4.prova4.entities.Empresas;
import com.br.questao4.prova4.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    public List<Empresas> findAll() {
        List<Empresas> result = repository.findAll();
        return result.stream().map(e -> new Empresas(e)).collect(Collectors.toList());
    }

    public Empresas findById(Long id) {
        Optional<Empresas> result = repository.findById(id);
        return result.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "COMPANY NOT FOUND"));
    }

    public Empresas saveEmpresas(Empresas entity){
        repository.save(entity);
        return entity;
    }

    public Empresas editEmpresas(Long id, Empresas entity){
        Empresas obj = findById(id);
        obj.setNome(entity.getNome());
        obj.setCnpj(entity.getCnpj());
        obj.setProdutosList(entity.getProdutosList());

        repository.save(obj);
        return obj;
    }


    public void deleteByID(Long id){
        repository.delete(findById(id));
    }

}
