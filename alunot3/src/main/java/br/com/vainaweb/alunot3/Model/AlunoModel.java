package br.com.vainaweb.alunot3.Model;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

import br.com.vainaweb.alunot3.dto.DadosAtualizados;
import br.com.vainaweb.alunot3.dto.Endereco;

import br.com.vainaweb.alunot3.enums.Curso;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Anotação que diz que essa classe é uma entidade
@Entity
@Table(name = "tb_colaboradores" )

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//será a classe responsavel pela entidade
public class AlunoModel {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Column(unique = true)
	private String email;
	
	
	@Column(unique = true)
	private String cpf;
	private Cargo cargo;
	
	@Embedded //Diz que o atributo será incorporado NESSA tabela
	private Endereco endereco;
	
	// |------------------------------------------CONSTRUTORES--------------------------------------|
	public AlunoModel(String nome, String email, String cpf, Curso curso, Endereco endereco) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.endereco = new Endereco(endereco.cep(), endereco.logradouro(), endereco.bairro(), endereco.cidade(),
				endereco.uf(), endereco.complemento(), endereco.numero());
		
	}

	public void atualizarInfo(@Valid DadosAtualizados dados) {
		this.nome = dados.nome() != null? dados.nome():this.nome;
		this.email = dados.email() != null? dados.email():this.email;
		
	}
	
}