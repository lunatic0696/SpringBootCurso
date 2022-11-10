package com.example.vendas.rest.controller;

import com.example.vendas.domain.Entity.Cliente;
import com.example.vendas.domain.Repository.Clientes;
import io.swagger.annotations.*;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController //Bota @ResponseBody em todas as funções
@RequestMapping("/api/clientes")
@Api("API Clientes")
public class ClienteController {

    private Clientes clientes;

    public ClienteController(Clientes clientes) {
        this.clientes = clientes;
    }

    @GetMapping("{id}")
    @ApiOperation("Obter detalhes de um cliente")
    @ApiResponses({
            @ApiResponse(code =200, message = "Cliente encontrado"),
            @ApiResponse(code = 404, message = "Cliente não encontrado para o ID informado")
    })
    public Cliente getClienteById(@PathVariable("id") @ApiParam("ID do cliente") Integer id){//@PathVariable indica que a variável vem na URL
        return clientes.findById(id).
                orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Cliente não encontrado"));
    }

    @PostMapping
    //@ResponseBody // Serve pra indicar que o objeto da response deve ser mapeado para um objeto do domínio
    @ResponseStatus(HttpStatus.CREATED) //Permite escolher o código de status que retorna
    @ApiOperation("Salva um novo cliente") //Descrição pro Swagger
    @ApiResponses({
            @ApiResponse(code =201, message = "Cliente salvo com sucesso"),
            @ApiResponse(code = 400, message = "Erro de validação")
    })
    public Cliente save(@RequestBody @Valid Cliente cliente){ //@RequestBody serve pra indicar alterações no objeto do domínio
        return clientes.save(cliente);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
        Optional<Cliente> toDelete = clientes.findById(id);
        if (!toDelete.isEmpty()){
            clientes.delete(toDelete.get());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }

    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody @Valid Cliente cliente){
        clientes
                .findById(id)
                .map(clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    clientes.save(cliente);
                    return clienteExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @GetMapping
    public List<Cliente> find(Cliente filtro){ //Para fazer pesquisas
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        List<Cliente> lista = clientes.findAll(example);
        return lista;
    }

}
