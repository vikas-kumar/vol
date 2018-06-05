package vol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vol.model.Client;

public interface ClientDao extends JpaRepository<Client, Long> {

}
