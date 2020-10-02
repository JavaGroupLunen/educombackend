package com.educom.server.daoImpl;

import com.educom.server.dao.StundenPlanDao;
import com.educom.server.entity.StundenPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

@Component
@Transactional
@Repository
public class StundenPlanDaoImpl implements StundenPlanDao<StundenPlan> {
@Autowired
private EntityManager entityManager;

@Override
public List<StundenPlan> getAll() {
        List<StundenPlan> stundenPlanList=entityManager.createQuery("from StundenPlan").getResultList();
        return stundenPlanList;
        }

@Override
public String save(StundenPlan stundenPlan) {
        entityManager.merge(stundenPlan);
        System.out.println(stundenPlan);
        return "success";
        }

@Override
public StundenPlan getById(Long id) {
        StundenPlan obj = entityManager.find(StundenPlan.class, id);
        return obj;
        }

@Override
public String delete(Long id) {
        StundenPlan stundenPlan = getById(id);
        entityManager.remove(stundenPlan);
        return "removed";
        }

@Override
public List<StundenPlan> findByDate(LocalDate stundenPlandate) {
        return entityManager.createQuery(
        "from StundenPlan where datum = :stundenPlandate",StundenPlan.class)
        .setParameter("stundenPlandate", stundenPlandate)
        .getResultList();
        }

        public List<StundenPlan> findByBegin(LocalDate begin) {
                return entityManager.createQuery(
                        "from StundenPlan where begin=:begin", StundenPlan.class)
                        .setParameter("begin", begin)
                        .getResultList();
        }
@Override
public String update(Long id, StundenPlan stundenPlan) {
        StundenPlan updateStundenPlan = getById(id);
        updateStundenPlan.setBeginn(stundenPlan.getBeginn());
        updateStundenPlan.setDatum(stundenPlan.getDatum());
        updateStundenPlan.setEnde(stundenPlan.getEnde());
        updateStundenPlan.setKurs(stundenPlan.getKurs());
        updateStundenPlan.setVertretung(stundenPlan.getVertretung());
        updateStundenPlan.setDetail(stundenPlan.getDetail());
        entityManager.merge(updateStundenPlan);
        return "success";
        }


}
