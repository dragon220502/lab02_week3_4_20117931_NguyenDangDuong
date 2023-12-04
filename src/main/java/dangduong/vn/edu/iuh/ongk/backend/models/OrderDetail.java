package dangduong.vn.edu.iuh.ongk.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
        @Table(name = "order_detaiil")
@NamedQueries(
        {@NamedQuery(name = "OrderDetail.find", query = "SELECT od from OrderDetail od where od.product.id = :product and od.order.id = :order"),
                @NamedQuery(name = "OrderDetail.findAllByOrderId", query = "select o from OrderDetail o where o.order.orderId =:orderId")

        }
)
public class OrderDetail {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String note;
    @Column(columnDefinition = "Double",nullable = false)
    private double price;
    @Column(columnDefinition = "Double",nullable = false)
    private double quantity;


    public OrderDetail(Product product, Order order, double quantity, double price, String additionalNote) {
        this.product = product;
        this.order = order;
        this.quantity = quantity;
        this.price = price;
        this.note = additionalNote;
    }
}
