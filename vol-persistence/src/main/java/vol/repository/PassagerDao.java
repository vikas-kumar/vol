package vol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vol.model.Passager;

public interface PassagerDao extends JpaRepository<Passager, Long> {
}
