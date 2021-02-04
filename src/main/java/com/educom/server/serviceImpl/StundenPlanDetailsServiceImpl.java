package com.educom.server.serviceImpl;



import com.educom.server.dao.StundenPlanDetailsDao;
import com.educom.server.entity.StundenPlanDetails;
import com.educom.server.services.StundenPlanDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
@Component
public class StundenPlanDetailsServiceImpl implements StundenPlanDetailService<StundenPlanDetails> {
    private static final Logger LOGGER = Logger.getLogger(StundenPlanDetailsServiceImpl.class.getName());
    @Autowired
    private StundenPlanDetailsDao stundenPlanDetailsDao;
    @Override
    public List<StundenPlanDetails> getAll() {
        return stundenPlanDetailsDao.getAll();
    }

    @Override
    public String save(StundenPlanDetails stundenPlanDetails) {
        return stundenPlanDetailsDao.save(stundenPlanDetails);
    }

    @Override
    public StundenPlanDetails getById(Long id) {
        return (StundenPlanDetails) stundenPlanDetailsDao.getById(id);
    }

    @Override
    public String delete(Long id) {
        return stundenPlanDetailsDao.delete(id);
    }

    @Override
    public List<StundenPlanDetails> findByDate(LocalDate name) {
        return stundenPlanDetailsDao.findByDate(name);
    }

    @Override
    public String update(Long id, StundenPlanDetails stundenPlanDetails) {
        return stundenPlanDetailsDao.update(id,stundenPlanDetails);
    }
}
