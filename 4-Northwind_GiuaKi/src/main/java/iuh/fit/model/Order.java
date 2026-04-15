package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order implements Serializable {
    private String orderID;
    private LocalDate orderDate;
    private String customerName;
    private String employeeName;
    private Status status;

    private transient List<OrderDetail> orderDetails;
}
