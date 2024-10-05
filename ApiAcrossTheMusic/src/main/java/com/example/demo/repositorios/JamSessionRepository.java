package com.example.demo.repositorios;

import com.example.demo.entities.Musico;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.JamSession;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JamSessionRepository extends JpaRepository<JamSession,Long> {

}
