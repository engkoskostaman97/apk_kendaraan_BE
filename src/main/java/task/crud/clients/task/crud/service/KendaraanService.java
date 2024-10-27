package task.crud.clients.task.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import task.crud.clients.task.crud.model.Kendaraan;
import task.crud.clients.task.crud.repository.KendaraanRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KendaraanService {

    @Autowired
    private KendaraanRepository kendaraanRepository;

    // Create or Update
    public Kendaraan saveKendaraan(Kendaraan kendaraan) {
        return kendaraanRepository.save(kendaraan);
    }

    public Kendaraan updateKendaraan(Kendaraan kendaraan) {
        return kendaraanRepository.save(kendaraan);
    }

    // Read - Get by ID
    public Optional<Kendaraan> getKendaraanById(String noreg) {
        return kendaraanRepository.findById(noreg);
    }

    // Read - Get all
    public List<Kendaraan> getAllKendaraan() {
        return kendaraanRepository.findAll();
    }

    // Delete
    public void deleteKendaraan(String noreg) {
        kendaraanRepository.deleteById(noreg);
    }
}
