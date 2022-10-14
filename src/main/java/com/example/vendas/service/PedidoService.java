package com.example.vendas.service;

import com.example.vendas.domain.Entity.Pedido;
import com.example.vendas.rest.dto.PedidoDTO;

public interface PedidoService {

    Pedido salvar(PedidoDTO dto);

}
