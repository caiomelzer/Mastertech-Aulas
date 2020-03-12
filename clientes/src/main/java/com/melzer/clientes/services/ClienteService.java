package com.melzer.clientes.services;
import com.melzer.clientes.models.Cliente;
import com.melzer.clientes.repositories.ClienteRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public ResponseEntity<List<Cliente>> listarClientes()
    {
        return new ResponseEntity<List<Cliente>>(clienteRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Cliente> listarCliente(int id)
    {
        Cliente cliente = clienteRepository.findById(id);
        if(cliente != null)
        {
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        }
        else
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado - Verifique o parâmetro Id informado");
        }
    }

    public ResponseEntity<Cliente> cadastrarCliente(Cliente cliente)
    {
        if(cliente.getId() != 0)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cadastro não efetuado - Parametros incorretos.");
        }
        return new ResponseEntity<Cliente>(clienteRepository.save(cliente), HttpStatus.CREATED);
    }

    public ResponseEntity<Cliente> editarCliente(Cliente cliente)
    {
        Cliente clienteOld = clienteRepository.findById(cliente.getId());
        if(clienteOld == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não encontrado - Verifique o parâmetro Id informado.");
        }
        return new ResponseEntity<Cliente>(clienteRepository.save(cliente), HttpStatus.OK);
    }
}