package br.com.vainaweb.alunot3.Repository;



import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.vainaweb.alunot3.Model.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository <AlunoModel, Long> {
	
	// SELECT * FROM tb_aluno WHERE cpf =
	Optional<AlunoModel> findByCpf(String cpf);
	
	
  boolean existsByCpf(String cpf);
	
	boolean existsByEmail(String email);
}