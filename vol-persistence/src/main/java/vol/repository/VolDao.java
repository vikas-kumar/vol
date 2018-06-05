package vol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vol.model.Vol;

public interface VolDao extends JpaRepository<Vol, Long> {

}
