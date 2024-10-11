package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "Usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gerador_mentoria")
    @SequenceGenerator(name = "gerador_mentoria", sequenceName = "mentoria_seq", allocationSize = 1)
    private Integer id;

    private String nome;
    private String cpf;
    private String estado;
    private int idade;
    private TipoPessoa tipoPessoa;

    public User() {
    }


}
