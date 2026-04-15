package dao.impl;

import dao.ApplicationDao;
import entity.Application;
import entity.JobStatus;

import java.util.List;

public class ApplicationDaoImpl extends AbstractGenericDao<Application, Application.ApplicationId> implements ApplicationDao {

    public ApplicationDaoImpl (){
        super(Application.class);
    }


    @Override
    public List<Object[]> findBySkillInOpenJobs(String skill) {
        String query = "select distinct c, j.title, app.appliedDate " +
                "from Candidate c " +
                "join c.applications app " +
                "join app.job j " +
                "join j.skills jsk " +
                "join c.skills csk " +
                "where j.status = :status " +
                "and jsk.name = :skill " +
                "and csk.name = :skill ";
        return doInTransaction(em -> {
           return em.createQuery(query)
                   .setParameter("status", JobStatus.OPEN)
                   .setParameter("skill", skill)
                   .getResultList();
        });
    }

    public static void main(String[] args) {

        ApplicationDao applicationDao = new ApplicationDaoImpl();

        List<Object[]> list = applicationDao.findBySkillInOpenJobs("Java");
        for(Object[] row : list){
            System.out.println(row[0]);
            System.out.println(row[1]);
            System.out.println(row[2]);
            System.out.println("====");
        }


//        Application.ApplicationId applicationId = Application.ApplicationId.builder().candidate("C2").job("j2").build();
//
//        Application application = applicationDao.findById(applicationId);
//        System.out.println(application);

    }


}
