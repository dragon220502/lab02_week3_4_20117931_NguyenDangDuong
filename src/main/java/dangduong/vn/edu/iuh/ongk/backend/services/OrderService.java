package dangduong.vn.edu.iuh.ongk.backend.services;

import dangduong.vn.edu.iuh.ongk.backend.models.Order;
import dangduong.vn.edu.iuh.ongk.backend.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

public class OrderService {
    private OrderRepository orderRepository;

    public OrderService() {
        this.orderRepository = new OrderRepository();
    }
    public boolean add(Order order){
        return orderRepository.taoMoi(order);
    }
    public boolean update(Order order){
        return orderRepository.updateId(order);
    }
    public Optional<Order> findOne(long id){
        return orderRepository.findId(id);
    }
    public boolean delete(long id){
        return orderRepository.delete(id);
    }
    public List<Order> findAll(){
        return orderRepository.getAll();
    }

}
