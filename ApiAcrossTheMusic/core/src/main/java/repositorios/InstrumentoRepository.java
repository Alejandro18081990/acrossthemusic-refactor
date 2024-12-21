package repositorios;

import entities.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InstrumentoRepository extends JpaRepository<Instrumento, Long>{
    
}
