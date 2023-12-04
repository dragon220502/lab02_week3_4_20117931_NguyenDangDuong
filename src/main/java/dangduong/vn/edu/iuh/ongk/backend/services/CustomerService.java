package dangduong.vn.edu.iuh.ongk.backend.services;

import dangduong.vn.edu.iuh.ongk.backend.models.Customer;
import dangduong.vn.edu.iuh.ongk.backend.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(){
        this.customerRepository = new CustomerRepository();
    }

    public boolean create(Customer customer){
        return customerRepository.create(customer);
    }
    public boolean update(Customer customer){
        return customerRepository.updateId(customer);
    }
    public boolean delete(long custId) {
        return customerRepository.delete(custId);
    }
    public Optional<Customer>   findOne(long custId){
        return customerRepository.findId(custId);
    }
    public List<Customer> getAll(){
        return customerRepository.getAll();

    }

}
