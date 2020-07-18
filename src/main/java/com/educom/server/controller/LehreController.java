package com.educom.server.controller;

import com.educom.server.entity.Lehre;
import com.educom.server.services.LehreService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class LehreController {
    @Autowired
    private LehreService lehreService;

    @RequestMapping(value = "/lehre", method = RequestMethod.POST)
    public String saveLehre(@RequestBody JSONObject requestparam) {
        Lehre lehre = new Lehre(requestparam.get("firstName").toString(), requestparam.get("lastName").toString(), requestparam.get("emailId").toString());
        return lehreService.saveLehreDetails(lehre);
    }

    @RequestMapping(value = "/lehrelist", method = RequestMethod.GET)
    public ResponseEntity<List<Lehre>> showLehreList() {
        List<Lehre> lehrelist = lehreService.getAllLehreList();
        return new ResponseEntity<List<Lehre>>(lehrelist, HttpStatus.OK);
    }

    @RequestMapping(value = "/getbyId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Lehre> getLehre(@PathVariable("id") Long id) {
        Lehre lehre = lehreService.getLehre(id);
        return new ResponseEntity<Lehre>(lehre, HttpStatus.OK);
    }

    //@DeleteMapping("/employees/{id}")
    @RequestMapping(value = "/getbyId/{id}", method = RequestMethod.DELETE)
    void  deleteLehre(@PathVariable Long id) {
        lehreService.deleteLehre(id);
    }


}
