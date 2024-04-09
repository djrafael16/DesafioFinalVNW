package br.com.vainaweb.alunot3.Model;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

import br.com.vainaweb.alunot3.dto.DadosAluno;
import br.com.vainaweb.alunot3.dto.DadosAtualizados;
import br.com.vainaweb.alunot3.dto.EnderecoDTO;

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
@Table(name = "tb_aluno" )

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

//será a classe responsavel pela entidade
public class AlunoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incrementado
	public Long id;

	@Column(nullable = false)
	private String nome;

	@Email
	@Column(unique = true)
	private String email;

	@CPF
	@Column(unique = true)
	private String cpf;

	@Column(nullable = false)
	private String telefone;

	@Column(nullable = false)
	private Curso curso;

	@Embedded
	@Column(nullable = false)
	private Endereco endereco;

	public AlunoModel(DadosAluno dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.cpf = dados.cpf();
		this.telefone = dados.telefone();
		this.curso = dados.curso();
		this.endereco= new Endereco(dados.endereco().cep()
				, dados.endereco().logradouro(),
				dados.endereco().bairro(), 
				dados.endereco().cidade(), 
				dados.endereco().uf(),
				dados.endereco().complemento(),
				dados.endereco().numero());
	}


	
	public void atualizar(@Valid DadosAtualizados dados) {
		this.nome = dados.nome() != null ? dados.nome() : this.nome;
		this.email = dados.email() != null ? dados.email() : this.email;
		this.telefone = dados.telefone() != null ? dados.telefone() : this.telefone;
	}
	
	
}