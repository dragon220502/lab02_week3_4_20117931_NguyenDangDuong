package dangduong.vn.edu.iuh.ongk.backend.models;

import dangduong.vn.edu.iuh.ongk.backend.enums.EmployeeStatus;
import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name ="employee")
@NamedQueries(@NamedQuery(name = "Employee.getALL",query = "SELECT E FROM Employee E WHERE E.status = ?1 "))
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id", columnDefinition = "BIGINT(20)", insertable = false, updatable = false)
    private long empId;
    @Column(columnDefinition = "varchar(150)", nullable = false)
    private String full_name;
    @Column(columnDefinition = "varchar(150)", nullable = false)
    private String email;
    @Column(columnDefinition = "varchar(15)", nullable = false)
    private String phone;
    @Column(columnDefinition = "varchar(250)", nullable = false)
    private String address;
    @Column (columnDefinition = "DATE",nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate dob;
    @Column (columnDefinition = "int(11)" ,nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private EmployeeStatus status;
    @OneToMany(mappedBy = "employeeId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> listOrder;

    public Employee(long empId) {
        this.empId = empId;
    }

    public Employee(String full_name, String email, String phone, String address, LocalDate dob, EmployeeStatus status) {

        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
        this.status = status;
    }
    public Employee(Long id,String full_name, String email, String phone, String address, LocalDate dob, EmployeeStatus status) {
        this.empId = id;
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
        this.status = status;
    }
    public Employee(long id, String fullname, String email, String phone, String address, LocalDate dob, EmployeeStatus status, List<Order> lstOrder) {
        this.empId = id;
        this.full_name= fullname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
        this.status = status;
        this.listOrder = lstOrder;
    }
}
