package vol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vol.model.Aeroport;

public interface AeroportDao extends JpaRepository<Aeroport, Long> {

}
