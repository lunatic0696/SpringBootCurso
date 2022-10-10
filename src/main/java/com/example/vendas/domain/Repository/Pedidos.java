package com.example.vendas.domain.Repository;

import com.example.vendas.domain.Entity.Cliente;
import com.example.vendas.domain.Entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pedidos extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);

}
