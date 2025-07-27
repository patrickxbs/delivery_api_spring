CREATE TABLE usuarios (
	id              bigint              primary key     auto_increment,
	nome            varchar(100)        not null,
	telefone        varchar(20)         not null        unique,
    email           varchar(255)        not null        unique,
	senha           varchar(150)        not null,
	role            enum('ADMIN', 'CLIENTE')            not null
);

CREATE TABLE enderecos (
    id              bigint              primary key     auto_increment,
    cep             varchar(10)         not null,
    cidade          varchar(50)         not null,
    bairro          varchar(50)         not null,
    numero          varchar(10)         not null,
    logradouro      varchar(50)         not null,
    complemento     varchar(100),
    usuario_id      bigint              not null,
    foreign key(usuario_id)             references usuarios(id)     ON DELETE CASCADE
);

CREATE TABLE categorias (
    id              bigint              primary key     auto_increment,
    nome            varchar(20)         not null        unique
);

CREATE TABLE produtos (
    id              bigint              primary key     auto_increment,
    nome            varchar(30)         not null        unique,
    quantidade      int                 not null,
    preco           decimal(10,2)       not null,
    descricao       varchar(255)        not null,
    categoria_id    bigint              not null,
    foreign key(categoria_id)           references categorias(id)
);

CREATE TABLE pedidos (
    id                  bigint            primary key     auto_increment,
    data_pedido         timestamp         not null,
    data_entregue       timestamp,
    status_pedido       enum('PENDENTE', 'PREPARANDO', 'ENVIADO', 'ENTREGUE', 'CANCELADO')      not null,
    descricao           varchar(255),
    preco_total         decimal(10, 2),
    usuario_id          bigint             not null,
    endereco_id         bigint             not null,
    foreign key(usuario_id)                references usuarios(id),
    foreign key(endereco_id)               references enderecos(id)
);

CREATE TABLE itens_pedidos (
    id                  bigint              primary key     auto_increment,
    quantidade          int                 not null,
    preco_unitario      decimal(10,2)       not null,
    produto_id          bigint              not null,
    pedido_id            bigint             not null,
    foreign key(produto_id)                 references produtos(id),
    foreign key(pedido_id)                  references pedidos(id)      ON DELETE CASCADE
);