package br.com.mtanuri.ada.t1043.web2.projeto.pedido;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;
    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
        var pedidos = pedidoService.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id){
        var pedido = pedidoService.findById(id);
        return ResponseEntity.ok(pedido);
    }

    @PostMapping
    public ResponseEntity<Pedido> savePedido(@RequestBody PedidoDTO pedidoDTO, UriComponentsBuilder uriBuilder){
        var novoPedido = pedidoService.savePedido(pedidoDTO);
        var uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(novoPedido.getId()).toUri();
        return ResponseEntity.created(uri).body(novoPedido);
    }

    @PutMapping("{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO){
        var updatedPedido = pedidoService.updatePedido(id, pedidoDTO);
        return ResponseEntity.ok(updatedPedido);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePedido(@PathVariable Long id){
        pedidoService.deletePedido(id);
        return ResponseEntity.noContent().build();
    }
}
