package task.crud.clients.task.crud.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import task.crud.clients.task.crud.model.Kendaraan;
import task.crud.clients.task.crud.service.KendaraanService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/kendaraan")
@CrossOrigin(origins = "http://localhost:3000")
public class KendaraanController {

    @Autowired
    private KendaraanService kendaraanService;

    // Create or Update
    @PostMapping
    public ResponseEntity<Kendaraan> createKendaraan(@RequestBody Kendaraan kendaraan) {
        Kendaraan savedKendaraan = kendaraanService.saveKendaraan(kendaraan);
        return ResponseEntity.ok(savedKendaraan);
    }

    @PutMapping
    public ResponseEntity<Kendaraan> updateKendaraan(@RequestBody Kendaraan kendaraan) {
        Kendaraan savedKendaraan = kendaraanService.updateKendaraan(kendaraan);
        return ResponseEntity.ok(savedKendaraan);
    }

    // Read - Get by ID
    @GetMapping("/{noreg}")
    public ResponseEntity<Kendaraan> getKendaraanById(@PathVariable String noreg) {
        return kendaraanService.getKendaraanById(noreg)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Read - Get all
    @GetMapping
    public List<Kendaraan> getAllKendaraan() {
        return kendaraanService.getAllKendaraan();
    }

    // Delete
    @DeleteMapping("/{noreg}")
    public ResponseEntity<String> deleteKendaraan(@PathVariable String noreg) {
        kendaraanService.deleteKendaraan(noreg);
        return ResponseEntity.ok("Data dengan noreg " + noreg + " berhasil dihapus");
    }
    
}
