package dangduong.vn.edu.iuh.ongk.backend.services;

import dangduong.vn.edu.iuh.ongk.backend.models.Employee;
import dangduong.vn.edu.iuh.ongk.backend.repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    private EmployeeRepository empres;

    public EmployeeService() {
        empres = new EmployeeRepository();

    }
    public boolean insert(Employee e){
        return empres.insertEmployee(e);

    }
    public boolean update(Employee e){
        return empres.updateEmployee(e);

    }
    public boolean delete(Employee e){
        return empres.deleteEmployee(e);

    }
    public List<Employee> getAll(){
        return  empres.getAll();
    }
    public Employee find(long id){
        return empres.findById(id);
    }
}
