package dangduong.vn.edu.iuh.ongk.backend.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
        @Table(name = "orders")
@NamedQueries(
        @NamedQuery(name = "Order.getAll", query = "select o from Order o")
)
public class Order {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "order_id",columnDefinition = "BIGINT(20)", insertable = false, updatable = false)
    private long orderId;
    @Column (columnDefinition = "DATE",nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate orderDate;
    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer custId;
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "emp_id")
    private Employee employeeId;
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    public Order(Customer custId, Employee employeeId,LocalDate orderDate) {

        this.custId = custId;
        this.employeeId = employeeId;
        this.orderDate = orderDate;
    }

    public Order(long orderId, LocalDate orderDate, Customer custId, Employee employeeId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.custId = custId;
        this.employeeId = employeeId;
    }
}
