package task.crud.clients.task.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.crud.clients.task.crud.model.Kendaraan;

@Repository
public interface KendaraanRepository extends JpaRepository<Kendaraan, Long> {
  Kendaraan findByNoreg(String noreg); // Sesuaikan dengan nama field
}


