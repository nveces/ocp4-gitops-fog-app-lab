package tech.nveces.quarkus.fog.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "advisor")
public class Advisor extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name= "license_number",nullable = false, length = 100)
    public String licenseNumber;

    @Column(name = "full_name", length = 50)
    public String fullName;

    @Column(name = "status", length = 20, nullable = false)
    public String status;

    @Column(name = "created_at", updatable = false)
    public LocalDateTime dateCreation = LocalDateTime.now();

    // filter by product
    public static List<Advisor> findByName(String nameadvisor) {
        return list("fullName", nameadvisor);
    }

}