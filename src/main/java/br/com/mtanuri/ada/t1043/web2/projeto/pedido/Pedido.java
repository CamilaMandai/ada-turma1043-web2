package br.com.mtanuri.ada.t1043.web2.projeto.pedido;

import br.com.mtanuri.ada.t1043.web2.projeto.produto.Produto;
import br.com.mtanuri.ada.t1043.web2.projeto.usuario.Endereco;
import br.com.mtanuri.ada.t1043.web2.projeto.usuario.Usuario;
import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
            name="tb_produto_pedido",
            joinColumns = @JoinColumn(name="pedido_id"),
            inverseJoinColumns = @JoinColumn(name="produto_id"))
    List<Produto> items;
}
