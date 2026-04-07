package iuh.fit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDetail implements Serializable {
    private Integer quantity;
    private Double unitPrice;
    private Double discount;

    private transient Product product;
    private transient Order order;
}
