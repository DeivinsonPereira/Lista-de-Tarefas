package com.deivinson.listatarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deivinson.listatarefas.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}