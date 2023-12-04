package dangduong.vn.edu.iuh.ongk.backend.services;

import dangduong.vn.edu.iuh.ongk.backend.models.OrderDetail;

import java.util.List;
import java.util.Optional;

public class OrderDetailService {

    private OrderDetailService orderDetailRepository;

    public OrderDetailService(){
        this.orderDetailRepository = new OrderDetailService();
    }
    public boolean insert(OrderDetail orderDetail){
        return orderDetailRepository.insert(orderDetail);
    }
    public boolean update(OrderDetail orderDetail){
        return orderDetailRepository.update(orderDetail);
    }
    public boolean delete(long orderId, long productId){
        return orderDetailRepository.delete(orderId, productId);
    }
    public Optional<OrderDetail> findOne(long orderId, long productId){
        return orderDetailRepository.findOne(orderId, productId);
    }
    public List<OrderDetail> findAll(){
        return orderDetailRepository.findAll();
    }
    public List<OrderDetail> getOrderDetailsByOrderId(long orderID){
        return orderDetailRepository.getOrderDetailsByOrderId(orderID);
    }
}
