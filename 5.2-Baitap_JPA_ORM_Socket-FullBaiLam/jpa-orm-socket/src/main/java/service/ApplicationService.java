package service;

import dto.ApplicationDto;
import entity.Application;

import java.util.List;

public interface ApplicationService {

    List<ApplicationDto> findBySkillInOpenJobs(String skill);
    ApplicationDto findById(Application.ApplicationId applicationId);

    boolean delete(Application.ApplicationId applicationId);

    List<ApplicationDto> loaddAll();


}
