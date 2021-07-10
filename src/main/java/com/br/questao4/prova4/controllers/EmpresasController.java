package com.br.questao4.prova4.controllers;

import com.br.questao4.prova4.entities.Empresas;
import com.br.questao4.prova4.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresasController {

    @Autowired
    private EmpresaService service;

    @GetMapping
    public ResponseEntity<List<Empresas>> findAll(){
        List<Empresas> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Empresas> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Empresas> save(@RequestBody Empresas entity){
        Empresas obj = service.saveEmpresas(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Empresas> edit(@PathVariable Long id, @RequestBody Empresas update){
        return ResponseEntity.ok(service.editEmpresas(id, update));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.deleteByID(id);
        return ResponseEntity.ok("Empresas " + id + " deletado!");
    }
}
