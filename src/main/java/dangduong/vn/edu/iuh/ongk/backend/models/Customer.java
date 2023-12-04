package dangduong.vn.edu.iuh.ongk.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
        @Table(name ="customer")
@NamedQueries(@NamedQuery(name = "Customer.getAll", query = "SELECT C FROM Customer C"))
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id", insertable = false, updatable = false)
    private Long custId;
    @Column(columnDefinition = "varchar(250)")

    private String address;
    @Column(columnDefinition = "varchar(150)")
    private String email;
    @Column(columnDefinition = "varchar(150)")
    private String custName;
    @Column(columnDefinition = "varchar(15)")
    private String phone;
    @OneToMany(mappedBy = "custId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> listOrder;

    public Customer(long custId) {
        this.custId = custId;
    }

    public Customer(long id, String name, String address, String phone, String email) {
        this.custId = id;
        this.custName = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    public Customer( String name, String address, String phone, String email) {
        this.custName = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    public Customer(long id, String name, String address, String phone, String email, List<Order> orderList) {
        this.custId = id;
        this.custName = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.listOrder = orderList;
    }
}
