package com.educom.server.controller;

import com.educom.server.entity.Lehre;
import com.educom.server.services.LehreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/lehre")
public class LehreController {
    @Autowired
    private LehreService lehreService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveLehre(@RequestBody Lehre requestparam) {
       // Lehre lehre = new Lehre(requestparam.get("firstName").toString(), requestparam.get("lastName").toString(), requestparam.get("emailId").toString());
        return lehreService.saveLehreDetails(requestparam);
    }

    @RequestMapping(value = "/lehrelist", method = RequestMethod.GET)
    public ResponseEntity<List<Lehre>> showLehreList() {
        List<Lehre> lehrelist = lehreService.getAllLehreList();
        return new ResponseEntity<>(lehrelist, HttpStatus.OK);
    }

    @RequestMapping(value = "/getbyId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Lehre> getLehre(@PathVariable("id") Long id) {
        Lehre lehre = lehreService.getLehre(id);
        return new ResponseEntity<>(lehre, HttpStatus.OK);
    }
    @RequestMapping(value = "/findByName/{firstname}", method = RequestMethod.GET)
    public ResponseEntity<List<Lehre>> lehreFindByName(@PathVariable("firstname") String firstName) {
        List<Lehre> lehreList = lehreService.findByName(firstName);
        return new ResponseEntity<>(lehreList, HttpStatus.OK);
    }
    @RequestMapping(value = "/findByLastName/{lastName}", method = RequestMethod.GET)
    public ResponseEntity<List<Lehre>> lehreFindByLastName(@PathVariable("lastName") String lastName) {
        List<Lehre> lehreList = lehreService.findByLastName(lastName);
        return new ResponseEntity<>(lehreList, HttpStatus.OK);
    }
    @RequestMapping(value = "/findByEmail/{email}", method = RequestMethod.GET)
    public ResponseEntity<List<Lehre>> lehreFindByEmailId(@PathVariable("email") String email) {
        List<Lehre> lehreList = lehreService.findByEmailId(email);
        return new ResponseEntity<>(lehreList, HttpStatus.OK);
    }


    @RequestMapping(value = "/deletebyId/{id}", method = RequestMethod.DELETE)
    public String  deleteLehre(@PathVariable Long id) {
        return lehreService.deleteLehre(id);

    }

    @RequestMapping(value = "/updatelehre/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Lehre> updateLehre(@PathVariable("id") Long id,@RequestBody Lehre lehre) {
        lehreService.updateLehre(id,lehre);
        return new ResponseEntity<Lehre>(lehre, HttpStatus.OK);

    }



    }
