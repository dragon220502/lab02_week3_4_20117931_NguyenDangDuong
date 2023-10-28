package dangduong.vn.edu.iuh.ongk.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
        @Table(name ="customer")
@NamedQueries(@NamedQuery(name = "Customer.getAll", query = "SELECT C FROM Customer C"))
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;
    @Column(columnDefinition = "varchar(250)")

    private String address;
    @Column(columnDefinition = "varchar(150)")
    private String email;
    @Column(columnDefinition = "varchar(150)")
    private String custName;
    @Column(columnDefinition = "varchar(15)")
    private String phone;



}
