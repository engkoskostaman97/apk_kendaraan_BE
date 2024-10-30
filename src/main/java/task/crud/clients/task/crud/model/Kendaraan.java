package task.crud.clients.task.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;


@Entity
@Table(name = "tbl_kendaraan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kendaraan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String noreg;
    private String name;
    @Column(length = 500)
    private String address;
    private String brand;
    @Column(length = 4)
    private int years;
    private int capacity;
    private String colour;
    private String fuel;
}
