package com.example.vendas.domain.Repository;

import com.example.vendas.domain.Entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes_old {

    //Strings do JDBC
    //private static String INSERT = "INSERT INTO CLIENTE (NOME) VALUES(?)";
    //private static String SELECT_ALL = "SELECT * FROM CLIENTE";
    //private static String UPDATE = "UPDATE CLIENTE SET NOME = ? WHERE ID = ?";
    //private static String DELETE = "DELETE FROM CLIENTE WHERE ID = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    EntityManager entityManager;

    @Transactional
    public Cliente salvar(Cliente cliente){
        entityManager.persist(cliente);
        //jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
        return cliente;
    }

    @Transactional
    public List<Cliente> obterTodos(){
        return entityManager.createQuery("from Cliente", Cliente.class).getResultList();
        //return jdbcTemplate.query(SELECT_ALL, obterClienteMapper());
    }

    //Usa o RowMapper toda vez que buscar mais de um Cliente (JDBC)
    private static RowMapper<Cliente> obterClienteMapper() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                return new Cliente(id, nome);
            }
        };
    }

    @Transactional
    public Cliente atualizar(Cliente cliente){
        //jdbcTemplate.update(UPDATE, new Object[]{
        //        cliente.getNome(), cliente.getId()} );
        entityManager.merge(cliente);
        return cliente;
    }

    @Transactional
    public void deletar(Cliente cliente){
        if (!entityManager.contains(cliente)){
            entityManager.merge(cliente);
        }
        entityManager.remove(cliente);
        //deletar(cliente.getId());
    }

    @Transactional
    public void deletar(Integer id){
        Cliente cliente = entityManager.find(Cliente.class, id);
        deletar(cliente);
        //jdbcTemplate.update(DELETE, new Object[]{id});
    }

    @Transactional(readOnly = true)
    public List<Cliente> buscarPorNome(String nome){
        String jpql = "select c from Cliente c where c.nome like :nome";
        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
        query.setParameter("nome","%"+nome+"%");
        return query.getResultList();
        //return jdbcTemplate.query(SELECT_ALL.concat(" WHERE NOME LIKE ?"),
        //        new Object[]{"%"+nome+"%"},
        //        obterClienteMapper());
    }

}
