package tech.nveces.quarkus.fog.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "operation")
public class Operation extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, length = 100)
    public String product;

    @Column(name = "monto_eur", nullable = false, precision = 15, scale = 2)
    public BigDecimal amountEur;

    @Column(name = "usuario_id", length = 50)
    public String userId;

    @Column(name = "date_creation", updatable = false)
    public LocalDateTime dateCreation = LocalDateTime.now();
    public LocalDateTime dateUpdate = LocalDateTime.now();

    // filter by product
    public static List<Operation> findByProduct(String product) {
        return list("product", product);
    }

    // V2
    /*
    @Column(name="currency_id", nullable = false, length = 3)
    public String currencyId;
    */

}