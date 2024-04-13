package br.com.vainaweb.alunot3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vainaweb.alunot3.Model.AlunoModel;
import br.com.vainaweb.alunot3.Repository.AlunoRepository;
import br.com.vainaweb.alunot3.dto.DadosAluno;


@Service// Classe de serviço gerenciada pelo Spring
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	public List<AlunoModel> encontrarTodosOsAlunos() {
		return repository.findAll(); // SELECT * FROM tb_aluno;
	}

       public Optional<AlunoModel> cadastrar(DadosAluno dados) {
		
    	   var cpfExistente = repository.existsByCpf(dados.cpf());
   		   var emailExistente = repository.existsByEmail(dados.email());

   		if (cpfExistente || emailExistente) {
   			return Optional.empty();
   		}

   		return Optional.of(repository.save(new AlunoModel(dados)));
   		
   	}
		
}

