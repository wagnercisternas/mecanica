package com.wasc.mecanica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wasc.mecanica.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Long> {

}
