package com.example.vendas.domain.Repository;

import com.example.vendas.domain.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    @Query(value = "select * from cliente c where c.nome like '%:nome%'", nativeQuery = true) //SQL Nativo
    List<Cliente> encontrarPorNome(@Param("nome") String nome);

    @Query(value = "delete from Cliente c where c.nome = :nome") //JPQL
    @Modifying
    void deletarPorNome(@Param("nome") String nome);

    Boolean existsByNome(String nome);

    @Query(value = "select c from Cliente c left join fetch c.pedidos where c.id = :id")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);
}
