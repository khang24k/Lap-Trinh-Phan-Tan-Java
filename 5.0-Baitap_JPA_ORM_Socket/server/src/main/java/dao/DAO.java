package dao;

import db.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.stream.Collectors;

public class DAO {
    public List<Object[]> findBySkillInOpenJobs(String skill){
        try(EntityManager em = JPAUtil.getEntityManager()){
            String jpql = """
                    
                    """;
            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
            return query.getResultList()
        }
    }
}
