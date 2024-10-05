package com.example.demo.repositorios;

import com.example.demo.entities.MusicoMensaje;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicoMensajeRepository extends JpaRepository<MusicoMensaje, Long> {

    List<MusicoMensaje> findMusicoMensajeByMusicoDestinatarioIdMusico(Long id);

    List<MusicoMensaje> findMusicoMensajeByMusicoRemitenteIdMusico(Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM musico_mensaje mm WHERE mm.musicoDestinatario.idMusico = :id OR mm.musicoRemitente.idMusico = :id")
    void deleteMusicoMensajeByIdMusico(Long id);
}
