package vol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vol.model.Ville;


public interface VilleDao extends JpaRepository<Ville, Long> {
}
