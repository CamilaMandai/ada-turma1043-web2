package br.com.mtanuri.ada.t1043.web2.projeto.pedido;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService{

    private final PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
    }

    @Override
    public Pedido savePedido(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setItems(pedidoDTO.items());
        pedido.setUsuario(pedidoDTO.usuario());
        pedido.setStatus(Status.NOVO);
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido updatePedido(Long id, PedidoDTO pedidoDTO) {
        Pedido pedido = findById(id);
        pedido.setItems(pedidoDTO.items());
        pedido.setUsuario(pedidoDTO.idUsuario());
        pedido.setStatus(pedidoDTO.status());
        return pedidoRepository.save(pedido);
    }

    @Override
    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
