package dangduong.vn.edu.iuh.ongk.backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductEnum {
    DANG(1),
    NGUNG(0),
    KHONG(-1);

    private int status;
}
