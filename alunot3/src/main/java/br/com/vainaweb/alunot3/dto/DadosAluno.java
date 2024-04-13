package br.com.vainaweb.alunot3.dto;

import br.com.vainaweb.alunot3.enums.Curso;
import jakarta.validation.Valid;

public record DadosAluno(String nome, String cpf, String telefone, String email, Curso curso, @Valid EnderecoDTO endereco) {


     
}
