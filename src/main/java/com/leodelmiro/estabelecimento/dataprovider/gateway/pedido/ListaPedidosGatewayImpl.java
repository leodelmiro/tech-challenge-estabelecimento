package com.leodelmiro.estabelecimento.dataprovider.gateway.pedido;

import com.leodelmiro.estabelecimento.dataprovider.repository.PedidoRepository;
import com.leodelmiro.estabelecimento.dataprovider.repository.entity.PedidoEntity;
import com.leodelmiro.estabelecimento.dataprovider.repository.mapper.PedidoEntityMapper;
import com.leodelmiro.estabelecimento.core.domain.Pedido;
import com.leodelmiro.estabelecimento.core.dataprovider.pedido.ListaPedidosGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ListaPedidosGatewayImpl implements ListaPedidosGateway {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoEntityMapper pedidoEntityMapper;

    @Override
    public Set<Pedido> listarTodos() {
        List<PedidoEntity> pedidosEntity = pedidoRepository.findAll();
        return transformarListaPedidosEntityParaSetPedidos(pedidosEntity);
    }

    @Override
    public Set<Pedido> listarPedidosNaFila() {
        List<PedidoEntity> pedidosEntity = pedidoRepository.findPedidosPagosEPendentesDeFinalizacao();
        return transformarListaPedidosEntityParaSetPedidos(pedidosEntity);
    }

    private Set<Pedido> transformarListaPedidosEntityParaSetPedidos(List<PedidoEntity> pedidosEntity) {
        return pedidosEntity.stream()
                .map(produtoEntity -> pedidoEntityMapper.toPedido(produtoEntity))
                .collect(Collectors.toSet());
    }
}
