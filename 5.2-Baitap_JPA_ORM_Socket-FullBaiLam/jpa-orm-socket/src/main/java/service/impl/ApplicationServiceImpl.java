package service.impl;

import dao.ApplicationDao;
import dao.impl.ApplicationDaoImpl;
import dto.ApplicationDto;
import entity.Application;
import entity.Candidate;
import mapper.Mapper;
import service.ApplicationService;

import java.time.LocalDate;
import java.util.List;

public class ApplicationServiceImpl implements ApplicationService {
    private ApplicationDao applicationDao;

    public ApplicationServiceImpl() {
        applicationDao = new ApplicationDaoImpl();
    }


    @Override
    public List<ApplicationDto> findBySkillInOpenJobs(String skill) {
        List<Object[]> list = applicationDao.findBySkillInOpenJobs("Java");
        return list.stream()
                .map(row -> {
                    Candidate candidate = (Candidate) row[0];
                    String jobTitle = (String) row[1];
                    LocalDate appliedDate = (LocalDate) row[2];
                    return ApplicationDto.builder()
                            .candidateId(candidate.getId())
                            .candidateName(candidate.getName())
                            .jobTitle(jobTitle)
                            .appliedDate(appliedDate)
                            .build();
                }).toList();
    }

    @Override
    public ApplicationDto findById(Application.ApplicationId applicationId) {
        Application application = applicationDao.findById(applicationId);
        return Mapper.map(application);
    }

    @Override
    public boolean delete(Application.ApplicationId applicationId) {
        return applicationDao.delete(applicationId);
    }

    @Override
    public List<ApplicationDto> loaddAll() {
        List<Application> applications = applicationDao.loadAll();
        return applications.stream()
                .map(application -> Mapper.map(application))
                .toList();
    }

    public static void main(String[] args) {
        ApplicationService applicationService = new ApplicationServiceImpl();

        applicationService.findBySkillInOpenJobs("Java")
                .forEach(app -> System.out.println(app));

//        applicationService.loaddAll()
//                .forEach(c -> System.out.println(c));

//        Application.ApplicationId applicationId = Application.ApplicationId.builder().candidate("C2").job("j2").build();
//        ApplicationDto applicationDto = applicationService.findById(applicationId);
//        System.out.println(applicationDto);
    }
}
