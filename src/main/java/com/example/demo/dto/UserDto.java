package com.example.demo.dto;

import com.example.demo.entity.TipoPessoa;

public record UserDto(
        String nome,
        String cpf,
        String estado,
        int idade,
        TipoPessoa tipoPessoa
) {
}
