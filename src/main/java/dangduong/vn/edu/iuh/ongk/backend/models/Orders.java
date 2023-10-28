package dangduong.vn.edu.iuh.ongk.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "orders")
public class Orders {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)

    private long orderId;
    @Column(columnDefinition = "datetime(6)")
    private LocalDateTime orderDate;
    @ManyToOne
    private Customer custId;
    @ManyToOne
    private Employee employeeId;

}
