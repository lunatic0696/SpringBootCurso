package com.example.vendas.domain.Repository;

import com.example.vendas.domain.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}
