package repositorios;


import entities.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicoTocaGrupoRepository extends JpaRepository<Grupo, Long> {

}
