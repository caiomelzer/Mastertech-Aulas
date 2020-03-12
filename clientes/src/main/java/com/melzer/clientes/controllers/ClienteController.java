package com.melzer.clientes.controllers;
import com.melzer.clientes.models.Cliente;
import com.melzer.clientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
@RestController
public class ClienteController {
    @Autowired
    ClienteService clienteService;


    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> listarClientes()
    {
        return clienteService.listarClientes();
    }

    @GetMapping("/clientes/{id}/")
    public ResponseEntity<Cliente> listarCliente(@PathVariable(value="id") int id)
    {
        return clienteService.listarCliente(id);
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> cadastrarUsuario(@RequestBody Cliente cliente)
    {
        return clienteService.cadastrarCliente(cliente);
    }

    @PutMapping("/clientes")
    public ResponseEntity<Cliente> editarCliente(@RequestBody Cliente cliente)
    {
        return clienteService.editarCliente(cliente);
    }
}