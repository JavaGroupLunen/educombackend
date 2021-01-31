package com.educom.server.controller;


import com.educom.server.entity.StundenPlan;
import com.educom.server.services.StundenPlanDetailService;
import com.educom.server.services.StundenPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/stundenplan")
public class StundenPlanController {
    @Autowired
    private StundenPlanService stundenPlanService;

    @Autowired
    private StundenPlanDetailService stundenPlanDetailService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPlan(@RequestBody StundenPlan stundenPlan) {
        return stundenPlanService.save(stundenPlan);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<StundenPlan>> stundenPlanList() {
        List<StundenPlan> stundenPlans = stundenPlanService.getAll();
        return new ResponseEntity<>(stundenPlans, HttpStatus.OK);
    }

    @RequestMapping(value = "/deletebyId/{id}", method = RequestMethod.DELETE)
    public String  delete(@PathVariable Long id) {
        return stundenPlanService.delete(id);

    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<StundenPlan> update(@PathVariable("id") Long id,@RequestBody StundenPlan stundenPlan) {
        stundenPlanService.update(id,stundenPlan);
        return new ResponseEntity<>(stundenPlan, HttpStatus.OK);
    }

}
