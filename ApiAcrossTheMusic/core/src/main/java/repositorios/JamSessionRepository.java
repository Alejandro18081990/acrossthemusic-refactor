package repositorios;

import entities.JamSession;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface JamSessionRepository extends JpaRepository<JamSession,Long> {

}
