package com.br.questao4.prova4.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_empresas")
public class Empresas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int cnpj;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "produtos_empresas",
            joinColumns = @JoinColumn(
                    name = "empresa_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "produtos_id"))
    private List<Produtos> produtosList = new ArrayList<>();

    public Empresas(Empresas entity){
        id = entity.getId();
        nome = entity.getNome();
        cnpj = entity.getCnpj();
        produtosList = entity.getProdutosList().stream().map(produto -> new Produtos(produto)).collect(Collectors.toList());
    }
}
