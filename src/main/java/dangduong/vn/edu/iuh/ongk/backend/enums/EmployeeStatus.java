package dangduong.vn.edu.iuh.ongk.backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EmployeeStatus {
    TAMNGUNG(0),
    DANGLAM(1),
    NGHI(-1);
    private int status;
}
