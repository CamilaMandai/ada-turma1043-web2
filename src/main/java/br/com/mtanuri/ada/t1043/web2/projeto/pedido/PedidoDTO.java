package br.com.mtanuri.ada.t1043.web2.projeto.pedido;

import br.com.mtanuri.ada.t1043.web2.projeto.produto.Produto;
import br.com.mtanuri.ada.t1043.web2.projeto.usuario.Usuario;

import java.util.List;

public record PedidoDTO (Long idUsuario, List<ProdutoQuantidade> items, Status status){}
