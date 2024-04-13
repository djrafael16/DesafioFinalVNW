CREATE TABLE tb_aluno(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(255),
	email VARCHAR(255) NOT NULL,
	telefone VARCHAR(15) NOT NULL,
	cpf VARCHAR(155) NOT NULL,
	curso INT,
	cep VARCHAR(20),
	logradouro VARCHAR(155),
	bairro VARCHAR(155),
	cidade VARCHAR(155),
	uf VARCHAR(3),
	complemento VARCHAR(155),
	numero BIGINT
	);