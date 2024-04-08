package br.com.vainaweb.alunot3.dto;

import br.com.vainaweb.alunot3.enums.Curso;
import br.com.vainaweb.alunot3.dto.Endereco;
import jakarta.validation.Valid;

public record DadosAluno(String nome, String cpf, String email, Curso cargo, @Valid Endereco endereco) {

}
