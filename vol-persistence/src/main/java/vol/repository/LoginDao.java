package vol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vol.model.Login;

public interface LoginDao extends JpaRepository<Login, Long> {

}
