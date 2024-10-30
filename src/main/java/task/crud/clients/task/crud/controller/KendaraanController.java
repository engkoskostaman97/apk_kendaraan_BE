package task.crud.clients.task.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import task.crud.clients.task.crud.model.Kendaraan;
import task.crud.clients.task.crud.service.KendaraanService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/kendaraan")
@CrossOrigin(origins = "https://apk-kendaraan-fe.vercel.app")
public class KendaraanController {

    @Autowired
    private KendaraanService kendaraanService;

    // Create or Update
    @PostMapping
    public ResponseEntity<?> saveKendaraan(@RequestBody Kendaraan kendaraan) {
        Object response = kendaraanService.saveKendaraan(kendaraan);
        
        if (response instanceof String) {
            return ResponseEntity.badRequest().body(response); // Respons jika noreg sudah ada
        }
        
        return ResponseEntity.ok(response); // Respons jika penyimpanan sukse
        
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

