package dao.impl;

import dao.CompanyDao;
import entity.Company;

public class ComapanyDaoImpl extends AbstractGenericDao<Company, String> implements CompanyDao {

    public ComapanyDaoImpl(){
        super(Company.class);
    }

    public static void main(String[] args) {
        CompanyDao companyDao = new ComapanyDaoImpl();

        Company company = companyDao.findById("CP2");
        System.out.println(company);

//        companyDao.loadAll()
//                .forEach(c -> System.out.println(c));
    }
}
