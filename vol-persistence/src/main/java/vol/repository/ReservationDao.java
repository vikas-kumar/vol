package vol.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import vol.model.Reservation;

public interface ReservationDao extends JpaRepository<Reservation, Long> {
}
