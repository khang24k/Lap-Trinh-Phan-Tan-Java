package service.impl;

import dao.CompanyDao;
import dao.impl.ComapanyDaoImpl;
import dto.CompanyDto;
import entity.Company;
import mapper.Mapper;
import service.CompanyService;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {
    private CompanyDao companyDao;

    public CompanyServiceImpl(){
        companyDao = new ComapanyDaoImpl();
    }

    @Override
    public CompanyDto create(CompanyDto companyDto) {
        return null;
    }

    @Override
    public CompanyDto update(CompanyDto companyDto) {
        return null;
    }

    @Override
    public boolean delete(String companyId) {
        return false;
    }

    @Override
    public CompanyDto findById(String companyId) {
        Company company = companyDao.findById(companyId);
        return Mapper.map(company, CompanyDto.class);
    }

    @Override
    public List<CompanyDto> loadAll() {
        List<Company> companies = companyDao.loadAll();
        return companies
                .stream()
                .map(c -> Mapper.map(c, CompanyDto.class))
                .toList();
    }

    public static void main(String[] args) {
        CompanyService companyService = new CompanyServiceImpl();
        List<CompanyDto> dtoList = companyService.loadAll();
        dtoList.forEach(c -> System.out.println(c));
    }
}
