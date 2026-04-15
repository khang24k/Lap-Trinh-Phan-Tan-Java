package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product implements Serializable {
    private String productID;
    private String productName;
    private String unit;
    private Double unitPrice;
    private Integer unitslnStock;

    private transient Supplier supplier;

    private transient List<OrderDetail> orderDetails;
}
