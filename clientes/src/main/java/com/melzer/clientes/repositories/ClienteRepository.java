package com.melzer.clientes.repositories;
import com.melzer.clientes.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findById(int id);
}