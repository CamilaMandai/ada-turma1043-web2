package br.com.mtanuri.ada.t1043.web2.projeto.pedido;


import java.util.List;

public interface PedidoService {
    List<Pedido> findAll();
    Pedido findById(Long id);

    Pedido savePedido(PedidoDTO pedidoDTO);

    Pedido updatePedido(Long id, PedidoDTO pedidoDTO);

    void deletePedido(Long id);
}
