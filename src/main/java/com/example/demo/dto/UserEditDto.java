package com.example.demo.dto;

import com.example.demo.entity.TipoPessoa;

public record UserEditDto(
        String nome,
        int idade,
        TipoPessoa tipoPessoa
) {
}
