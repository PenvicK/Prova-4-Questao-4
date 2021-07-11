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
@Table(name = "tb_produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double preco;

    @JsonIgnore
    @ManyToMany(mappedBy = "produtosList", fetch = FetchType.EAGER)
    private List<Empresas> empresasList = new ArrayList<>();

    public Produtos(Produtos entity){
        id = entity.getId();
        nome = entity.getNome();
        preco = entity.getPreco();
//        empresasList = entity.getEmpresasList().stream().map(empresa -> new Empresas(empresa)).collect(Collectors.toList());
    }
}
