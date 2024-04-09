package br.com.vainaweb.alunot3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.vainaweb.alunot3.dto.DadosAluno;
import br.com.vainaweb.alunot3.dto.DadosAtualizados;
import br.com.vainaweb.alunot3.dto.EnderecoDTO;
import jakarta.validation.Valid;
import br.com.vainaweb.alunot3.Model.AlunoModel;
import br.com.vainaweb.alunot3.Repository.AlunoRepository;
import br.com.vainaweb.alunot3.Service.AlunoService;

	
	@RestController
	@RequestMapping("/colaborador-teste")

	// Classe responsavel por receber requisições e retornar respostas
	public class AlunoController {

		@Autowired
		private AlunoService service;
		
		private AlunoRepository repository;

		@GetMapping
		public List<AlunoModel> listarTodosColaboradores() {
		      return service.encontrarTodosOsAlunos();	
		      }
		
		@GetMapping("/{id}")
		public ResponseEntity<AlunoModel> listarPorId(@PathVariable Long id) {
			var response = repository.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
					.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
			return response;
		
			
		}

		
		@PostMapping
		public ResponseEntity<Object> cadastrar(@RequestBody DadosAluno dados) {
			return service.cadastrar(dados).map(resposta -> ResponseEntity.status(HttpStatus.CREATED).build())
					.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
			
		}
		
		
		
		@PutMapping("/{id}")
		public ResponseEntity<Object> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizados dados) {
			var aluno = repository.getReferenceById(id);
			aluno.atualizar(dados);
			repository.save(aluno);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		@DeleteMapping("/{id}")
		public String deletar(@PathVariable Long id) {
			repository.deleteById(id);
			return "Deletado com sucesso";
		}


	}

