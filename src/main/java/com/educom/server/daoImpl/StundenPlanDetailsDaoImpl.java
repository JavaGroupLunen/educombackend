package com.educom.server.daoImpl;

import com.educom.server.dao.StundenPlanDao;
import com.educom.server.entity.StundenPlanDetails;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class StundenPlanDetailsDaoImpl implements StundenPlanDao<StundenPlanDetails> {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<StundenPlanDetails> getAll() {
        List<StundenPlanDetails> stundenPlanList=entityManager.createQuery("from StundenPlanDetails").getResultList();
        return stundenPlanList;
    }

    @Override
    public String save(StundenPlanDetails stundenPlanDetails) {
        entityManager.merge(stundenPlanDetails);
        System.out.println(stundenPlanDetails);
        return "success";
    }

    @Override
    public StundenPlanDetails getById(Long id) {
        StundenPlanDetails obj = entityManager.find(StundenPlanDetails.class, id);
        return obj;
    }

    @Override
    public String delete(Long id) {
        StundenPlanDetails stundenPlan = getById(id);
        entityManager.remove(stundenPlan);
        return "removed";
    }

    @Override
    public List<StundenPlanDetails> findByDate(LocalDate name) {
        return null;
    }


    @Override
    public String update(Long id, StundenPlanDetails stundenPlan) {
        StundenPlanDetails stundenPlanDetails = getById(id);
        entityManager.merge(stundenPlanDetails);
        return "success";
    }

}
