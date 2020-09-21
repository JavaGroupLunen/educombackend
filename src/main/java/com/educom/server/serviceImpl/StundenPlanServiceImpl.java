package com.educom.server.serviceImpl;

import com.educom.server.dao.StundenPlanDao;
import com.educom.server.entity.StundenPlan;
import com.educom.server.services.StundenPlanService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

public class StundenPlanServiceImpl implements StundenPlanService<StundenPlan> {
    private static final Logger LOGGER = Logger.getLogger(SchulerServiceImpl.class.getName());
    @Autowired
    private StundenPlanDao stundenPlanDao;
    @Override
    public List<StundenPlan> getAll() {
        return stundenPlanDao.getAll();
    }

    @Override
    public String save(StundenPlan stundenPlan) {
        return stundenPlanDao.save(stundenPlan);
    }

    @Override
    public StundenPlan getById(Long id) {
        return (StundenPlan) stundenPlanDao.getById(id);
    }

    @Override
    public String delete(Long id) {
        return stundenPlanDao.delete(id);
    }

    @Override
    public List<StundenPlan> findByDate(LocalDate date) {
        return stundenPlanDao.findByDate(date);
    }

    @Override
    public String update(Long id, StundenPlan stundenPlan) {
        return stundenPlanDao.update(id,stundenPlan);
    }
}
