package dangduong.vn.edu.iuh.ongk.backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductEnum {

    TAMNGUNG(0),
    DANGKINHDOANG(1),
    KHONGKINHDOANG(-1);
    private int status;
}
