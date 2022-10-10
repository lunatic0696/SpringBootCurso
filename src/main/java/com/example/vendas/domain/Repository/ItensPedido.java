package com.example.vendas.domain.Repository;

import com.example.vendas.domain.Entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedido extends JpaRepository<ItemPedido, Integer> {
}
