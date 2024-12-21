package repositorios;

import java.util.List;

import entities.MusicoTocaInstrumento;
import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface MusicoTocaInstrumentoRepository extends JpaRepository<MusicoTocaInstrumento, Long> {

    List<MusicoTocaInstrumento> findByInstrumentoNombreInstrumento(String nombreInstrumento);

    MusicoTocaInstrumento findByMusicoIdMusicoAndInstrumentoIdInstrumento(Long musico, Long instrumento);
    @Transactional
    void deleteByMusicoIdMusico(Long musico);
}
