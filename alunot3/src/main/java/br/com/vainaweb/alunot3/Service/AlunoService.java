package br.com.vainaweb.alunot3.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vainaweb.alunot3.Model.AlunoModel;
import br.com.vainaweb.alunot3.Repository.AlunoRepository;
import br.com.vainaweb.alunot3.dto.DadosAluno;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service// Classe de serviço gerenciada pelo Spring
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	public List<AlunoModel> encontrarTodosOsAlunos() {
		return repository.findAll(); // SELECT * FROM tb_colaboradores;
	}

public String cadastrar(DadosAluno dados) {
		
		var colaborador = repository.findByCpf(dados.cpf());
	
		if(colaborador.isPresent()) {
			return "CPF Já cadastrado";
		}else {
			repository.save(new AlunoModel(dados.nome(), dados.cpf(), dados.email(), dados.cargo(), dados.endereco())); //INSERT 
			return "Cadastro efetuado com sucesso";
		
		}
	
		
	}
}