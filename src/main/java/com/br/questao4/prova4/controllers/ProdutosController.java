package com.br.questao4.prova4.controllers;

import com.br.questao4.prova4.entities.Produtos;
import com.br.questao4.prova4.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produtos>> findAll(){
        List<Produtos> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Produtos> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Produtos> save(@RequestBody Produtos entity){
        Produtos obj = service.saveProdutos(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Produtos> edit(@PathVariable Long id, @RequestBody Produtos update){
        return ResponseEntity.ok(service.editProdutos(id, update));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.deleteByID(id);
        return ResponseEntity.ok("Produto " + id + " deletado!");
    }
}
