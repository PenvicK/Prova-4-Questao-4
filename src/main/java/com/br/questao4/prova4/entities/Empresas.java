package com.br.questao4.prova4.entities;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
            name = "produtos_empresas",
            joinColumns = @JoinColumn(
                    name = "empresa_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "produtos_id"))
    private List<Produtos> produtosList = new ArrayList<>();
}
