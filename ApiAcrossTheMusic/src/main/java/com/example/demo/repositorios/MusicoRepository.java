package com.example.demo.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Musico;


@Repository
public interface MusicoRepository extends JpaRepository<Musico, Long> {

    @Query("SELECT m FROM Musico m " +
            "JOIN m.musicoTocaInstrumento mti " +
            "JOIN mti.instrumento i " +
            "JOIN m.musicoTocaEstilo mte " +
            "JOIN mte.estilo e " +
            "WHERE i.nombreInstrumento LIKE :nombreInstrumento " +
            "AND e.nombreEstilo LIKE :nombreEstilo " +
            "AND m.aniosExperiencia >= :aniosExperiencia")
    List<Musico> findByInstrumentoAndEstilo(@Param("nombreInstrumento") String nombreInstrumento,
                                            @Param("nombreEstilo") String nombreEstilo,
                                            @Param("aniosExperiencia") int aniosExperiencia);


    @Query("SELECT m FROM Musico m " +
            "JOIN m.musicoTocaJam mtj " +
            "JOIN mtj.jamSession js " +
            "WHERE js.id = :idJam")
    List<Musico> findMusicoByMusicoTocaJam(@Param("idJam") Long idJam);

    Musico findMusicoByEmail(String email);
}
