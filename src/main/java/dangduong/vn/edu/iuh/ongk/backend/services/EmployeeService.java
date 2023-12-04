package dangduong.vn.edu.iuh.ongk.backend.services;

import dangduong.vn.edu.iuh.ongk.backend.models.Employee;
import dangduong.vn.edu.iuh.ongk.backend.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private EmployeeRepository empres;

    public EmployeeService() {
        empres = new EmployeeRepository();

    }
    public boolean create(Employee e){
        return empres.insertEmployee(e);

    }
    public boolean update(Employee e){
        return empres.updateEmployee(e);

    }
    public boolean delete(Long id){
        return empres.deleteEmployee(id);
    }
    public List<Employee> getAll(){
        return  empres.getAll();
    }
    public Optional<Employee> findById(long id){
        return empres.findById(id);
    }
}
