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
public class Supplier implements Serializable {
    private String supplierID;
    private String companyName;
    private String contactName;
    private String country;

    private transient List<Product> products;
}
