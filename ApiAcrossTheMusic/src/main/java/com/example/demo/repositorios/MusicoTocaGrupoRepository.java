package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Grupo;

public interface MusicoTocaGrupoRepository extends JpaRepository<Grupo, Long> {

}
