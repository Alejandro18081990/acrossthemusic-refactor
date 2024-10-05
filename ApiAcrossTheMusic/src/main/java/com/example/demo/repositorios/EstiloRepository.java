package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Estilo;
import org.springframework.stereotype.Repository;


@Repository
public interface EstiloRepository extends JpaRepository<Estilo, Long> {

}
