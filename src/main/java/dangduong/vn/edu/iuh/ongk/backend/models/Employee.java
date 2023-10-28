package dangduong.vn.edu.iuh.ongk.backend.models;

import dangduong.vn.edu.iuh.ongk.backend.enums.EmployeeStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name ="employee")
@NamedQueries(@NamedQuery(name = "Employee.getALL",query = "SELECT E FROM Employee E WHERE E.status = ?1 "))
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long empId;
    @Column(columnDefinition = "varchar(150)", nullable = false)
    private String full_name;
    @Column(columnDefinition = "varchar(150)", nullable = false)
    private String email;
    @Column(columnDefinition = "varchar(15)", nullable = false)
    private String phone;
    @Column(columnDefinition = "varchar(250)", nullable = false)
    private String address;
    @Column (columnDefinition = "datetime(6)")
    private LocalDate dob;
    @Column (columnDefinition = "int(11)" ,nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private EmployeeStatus status;

    public Employee(String full_name, String email, String phone, String address, LocalDate dob, EmployeeStatus status) {
        this.empId = empId;
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
        this.status = status;
    }
}
