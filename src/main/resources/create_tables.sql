
CREATE TABLE tb_produto(
    id int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    descricao VARCHAR(255),
    valor FLOAT,
    quantidade_estoque INTEGER
);
-- Create the tb_endereco table
CREATE TABLE tb_endereco (
    id int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    logradouro VARCHAR(255),
    numero INTEGER,
    complemento VARCHAR(255),
    bairro VARCHAR(45),
    cidade VARCHAR(45),
    uf VARCHAR(45),
    cep INTEGER
);

-- Create the tb_usuario table with a foreign key to tb_endereco
CREATE TABLE tb_usuario (
    id int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nome VARCHAR(255),
    cpf VARCHAR(14),
    email VARCHAR(255),
    endereco_id INT UNIQUE REFERENCES tb_endereco(id)
);

CREATE TABLE tb_pedido(
    id int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    usuario_id INT UNIQUE REFERENCES tb_usuario(id),
    data_pedido timestamp DEFAULT current_timestamp,
    status VARCHAR(45)
)

CREATE TABLE tb_produto_pedido (
  produto_id int NOT NULL,
  pedido_id int NOT NULL,
  PRIMARY KEY (produto_id, pedido_id),
  FOREIGN KEY (produto_id) REFERENCES tb_produto (id) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY (pedido_id) REFERENCES tb_pedido (id) ON DELETE RESTRICT ON UPDATE CASCADE
);