package com.example.vendas;

import com.example.vendas.domain.Entity.Cliente;
import com.example.vendas.domain.Repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

	@Value("${application.name}")
	private String applicationName;

	@Cachorro
	private Animal animal;

	@Bean(name = "executarAnimal")
	public CommandLineRunner executar(){
		return args -> {
			this.animal.fazerBarulho();
		};
	}

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes){
		return args -> {
			clientes.save(new Cliente("Paulo"));
			clientes.save(new Cliente("Hermano"));

			List<Cliente> result = clientes.encontrarPorNome("Paulo");
			System.out.println(result);
			clientes.encontrarPorNome("Paulo");
			result = clientes.encontrarPorNome("Paulo");
			System.out.println(result);

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
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

	@GetMapping("/hello")
	public String helloWorld(){
		return applicationName;
	}
}
