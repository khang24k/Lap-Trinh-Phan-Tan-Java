package iuh.fit;

import iuh.fit.dao.ProductDAO;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //CREATE RANGE INDEX range_CompanyName
        //FOR (s:Supplier)
        //ON s.company_name
        ProductDAO productDAO = new ProductDAO();

        productDAO.listProductsBySupplier("", 2, 2)
                .forEach(product -> System.out.println(product));
    }
}