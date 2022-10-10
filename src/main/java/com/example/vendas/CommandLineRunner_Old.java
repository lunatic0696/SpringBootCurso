package com.example.vendas;

import com.example.vendas.domain.Repository.Clientes;
import com.example.vendas.domain.Repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class CommandLineRunner_Old {

    //@Bean
    //public CommandLineRunner init(@Autowired Clientes clientes, @Autowired Pedidos pedidos){
    //    return args -> {
            //Cliente paulo = clientes.save(new Cliente("Paulo"));
            //Cliente hermano = clientes.save(new Cliente("Hermano"));
//
            //Pedido p = new Pedido();
            //p.setCliente(paulo);
            //p.setDataPedido(LocalDate.now());
            //p.setTotal(BigDecimal.valueOf(100));
            //pedidos.save(p);
//
            //pedidos.findByCliente(paulo).forEach(System.out::println);

            //Cliente cliente = clientes.findClienteFetchPedidos(paulo.getId()); //Pega um cliente com os pedidos
            //System.out.println(cliente);
            //System.out.println(cliente.getPedidos());

            //List<Cliente> result = clientes.encontrarPorNome("Paulo");
            //System.out.println(result);
            //clientes.encontrarPorNome("Paulo");
            //result = clientes.encontrarPorNome("Paulo");
            //System.out.println(result);

            //System.out.println("Atualizando clientes");
            //todosClientes.forEach(c -> {
            //	c.setNome(c.getNome() + " atualizado.");
            //	clientes.save(c);
            //	System.out.println(c);
            //});
            //
            //System.out.println("Buscando Cliente");
            //List<Cliente> busca = clientes.findByNomeLike("%Herm%");
            //System.out.println(busca);

            //System.out.println("Deletando clientes");
            //todosClientes = clientes.findAll();
            //todosClientes.forEach(c ->{
            //	clientes.delete(c.getId());
            //});
            //todosClientes = clientes.findAll();
            //if (todosClientes.isEmpty()){
            //	System.out.println("Nenhum cliente encontrado");}
            //else {
            //	todosClientes.forEach(System.out::println);
            //}
       // };
    //}
}
