package repositorios;


import entities.MusicoTocaJam;
import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

@Repository
public interface MusicoTocaJamRepository extends JpaRepository<MusicoTocaJam, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM musico_toca_jam mtj WHERE mtj.musicoTocaJam.idMusico = :idMusico AND mtj.jamSession.idJamSession = :idJamSession")
    void deleteMusicoJam(long idMusico, long idJamSession);

    @Transactional
    @Modifying
    @Query("DELETE FROM musico_toca_jam mtj WHERE mtj.musicoTocaJam.idMusico = :id")
    void deleteMusicoJamByMusicoIdMusico(Long id);
}
