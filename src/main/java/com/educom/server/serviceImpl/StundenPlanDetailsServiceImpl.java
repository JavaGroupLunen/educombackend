package com.educom.server.serviceImpl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedTimestamp;
import com.educom.server.dao.StundenPlanDao;
import com.educom.server.dao.StundenPlanDetailsDao;
import com.educom.server.entity.StundenPlan;
import com.educom.server.entity.StundenPlanDetails;
import com.educom.server.services.StundenPlanDetailService;
import com.educom.server.services.StundenPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
@Component
public class StundenPlanDetailsServiceImpl implements StundenPlanService<StundenPlanDetails> {
    private static final Logger LOGGER = Logger.getLogger(SchulerServiceImpl.class.getName());
    @Autowired
    private StundenPlanDetailsDao stundenPlanDetailsDao;
    @Override
    public List<StundenPlanDetails> getAll() {
        return null;
    }

    @Override
    public String save(StundenPlanDetails stundenPlanDetails) {
        return null;
    }

    @Override
    public StundenPlanDetails getById(Long id) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public List<StundenPlanDetails> findByDate(LocalDate name) {
        return null;
    }

    @Override
    public String update(Long id, StundenPlanDetails stundenPlanDetails) {
        return null;
    }
}
