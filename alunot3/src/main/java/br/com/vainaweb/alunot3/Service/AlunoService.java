package br.com.vainaweb.alunot3.Service;

import java.util.List;
import java.util.Optional;

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

public Optional<AlunoModel> cadastrar(DadosAluno dados) {
		
		var aluno = repository.findByCpf(dados.cpf());
		
		if(aluno.get().getCpf() != null || aluno.get().getEmail() != null) {
			return Optional.empty();
		}
		else {
			return Optional.of(repository.save(new AlunoModel(dados)));
		}
}

}