package br.com.vainaweb.alunot3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.alunot3.dto.DadosColaborador;
import br.com.vainaweb.alunot3.model.ColaboradorModel;
import br.com.vainaweb.alunot3.repository.ColaboradorRepository;
import br.com.vainaweb.alunot3.service.ColaboradorService;

public class AlunoController {
	
	RestController
	@RequestMapping("/colaborador-teste")

	// Classe responsavel por receber requisições e retornar respostas
	public class AlunoController {

		@Autowired
		private AlunoService service;
		
		private AlunoRepository repository;

		@GetMapping
		public List<AlunoModel> listarTodosColaboradores() {
		      return service.encontrarTodos();
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<AlunoModel> listarPorId(@PathVariable Long id) {
			var response = repository.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
					.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
			return response;
		
			
		}

		@ResponseStatus(code = HttpStatus.CREATED)
		@PostMapping
		public String cadastrarColaborador(@RequestBody DadosAluno dados) {
			service.cadastrar(dados);
			return "ok";
		}
		


	}

}
