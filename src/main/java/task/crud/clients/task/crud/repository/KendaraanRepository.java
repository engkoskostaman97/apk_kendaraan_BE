package task.crud.clients.task.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.crud.clients.task.crud.model.Kendaraan;
import java.util.Optional;

@Repository
public interface KendaraanRepository extends JpaRepository<Kendaraan, String> {
  Optional<Kendaraan> findByNoreg(String noreg);

}

