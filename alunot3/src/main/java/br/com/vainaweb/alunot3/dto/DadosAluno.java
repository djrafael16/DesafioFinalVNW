package br.com.vainaweb.alunot3.dto;

import br.com.vainaweb.alunot3.enums.Curso;

public record DadosAluno(String nome, String cpf, String email, Curso cargo) {

}
