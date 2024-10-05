package com.example.demo.repositorios;

import java.util.List;
import java.util.Set;

import com.example.demo.entities.Instrumento;
import com.example.demo.entities.Musico;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.MusicoTocaInstrumento;


@Repository
public interface MusicoTocaInstrumentoRepository extends JpaRepository<MusicoTocaInstrumento, Long> {

    List<MusicoTocaInstrumento> findByInstrumentoNombreInstrumento(String nombreInstrumento);

    MusicoTocaInstrumento findByMusicoIdMusicoAndInstrumentoIdInstrumento(Long musico, Long instrumento);
    @Transactional
    void deleteByMusicoIdMusico(Long musico);
}
