package com.leodelmiro.estabelecimento.dataprovider.repository.entity;

import com.leodelmiro.estabelecimento.core.domain.ItemPedido;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_item_pedido")
public class ItemPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;

    private int quantidade;

    public ItemPedidoEntity() {
    }

    public ItemPedidoEntity(PedidoEntity pedido, ProdutoEntity produto, int quantidade) {
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ItemPedidoEntity(Long id, PedidoEntity pedido, ProdutoEntity produto, int quantidade) {
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public static ItemPedidoEntity doDominio(ItemPedido itemPedido, ProdutoEntity produtoEntity) {
        return new ItemPedidoEntity(null, produtoEntity, itemPedido.getQuantidade());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PedidoEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEntity pedido) {
        this.pedido = pedido;
    }

    public ProdutoEntity getProduto() {
        return produto;
    }

    public void setProduto(ProdutoEntity produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
