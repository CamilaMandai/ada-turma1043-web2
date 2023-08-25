package br.com.mtanuri.ada.t1043.web2.projeto.produto;

import br.com.mtanuri.ada.t1043.web2.projeto.pedido.Pedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private Integer quantidadeEstoque;

    @ManyToMany(mappedBy = "items")
    List<Pedido> pedidos;
}
