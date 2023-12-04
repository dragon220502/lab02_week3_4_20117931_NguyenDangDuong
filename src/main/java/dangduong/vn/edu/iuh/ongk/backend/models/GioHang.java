package dangduong.vn.edu.iuh.ongk.backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GioHang {
    private long id;
    private int quantity;
    private double totalPrice;
}
