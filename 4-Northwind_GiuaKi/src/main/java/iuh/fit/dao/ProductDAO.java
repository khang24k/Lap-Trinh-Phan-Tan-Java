package iuh.fit.dao;

import iuh.fit.model.Product;
import iuh.fit.util.AppUtils;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.types.Node;

import java.util.List;
import java.util.Map;

public class ProductDAO {
    public List<Product> listProductsBySupplier (String companyName, int page, int size) {
        // 1. Kiểm tra điều kiện đầu vào (Validation)
        if (companyName == null || companyName.trim().isEmpty()) {
//            throw new IllegalArgumentException("Tên nhà cung cấp không được null hoặc rỗng.");
            throw new RuntimeException("Tên nhà cung cấp không được null hoặc rỗng.");
        }
        if (page < 1) {
            throw new IllegalArgumentException("Số trang (page) phải là số nguyên dương (>= 1).");
        }
        if (size < 1) {
            throw new IllegalArgumentException("Kích thước trang (size) phải là số nguyên dương (>= 1).");
        }
        String query = """
                MATCH (s:Supplier)-[r:SUPPLIES]->(p:Product)
                WHERE s.company_name = "Pavlova Ltd."
                ORDER BY p.product_name ASC
                SKIP $skip
                LIMIT $size
                RETURN p
                """;
        Map<String, Object> params = Map.of(
                "skip", (page-1)*size,
                "size", size
        );
        try(Session session = AppUtils.getSession()) {
            return session.executeRead(tx -> {
                Result result = tx.run(query, params);
                return result.stream().map(
                        record -> {
                            Node node = record.get("p").asNode();
                            return Product.builder()
                                    .productID(node.get("product_id").asString())
                                    .productName(node.get("product_name").asString())
                                    .unit(node.get("unit").asString())
                                    .unitPrice(node.get("unit_price").asDouble())
                                    .unitslnStock(node.get("units_in_stock").asInt())
                                    .build();

                        }
                ).toList();
            });
        }
    }
//    public List<Product> listProductsBySupplier (companyName: String, int page, int size) {
//        String query = """
//
//                """;
//        Map<String, Object> params = Map.of(
//
//        );
//        try(Session session = AppUtils.getSession()) {
//
//        }
//    }
//

}
