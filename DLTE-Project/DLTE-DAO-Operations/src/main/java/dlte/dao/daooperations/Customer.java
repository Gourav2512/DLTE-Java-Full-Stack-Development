package dlte.dao.daooperations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int customer_id;
    private String customer_name;
    private String customer_address;
    private String customer_status;
    private long contact;
    private String username;
    private String password;
}
