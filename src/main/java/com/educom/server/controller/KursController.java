package com.educom.server.controller;

import com.educom.server.dao.KursRepo;
import com.educom.server.entity.Kurs;
import com.educom.server.services.KursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/kurs")
public class KursController {
    @Autowired
    private KursService kursService;


    @RequestMapping(value = "/kurs", method = RequestMethod.POST)
    public String savekurs(@RequestBody Kurs requestparam) {
        return kursService.saveKurs(requestparam);
    }

    @RequestMapping(value = "/kurslist", method = RequestMethod.GET)
    public ResponseEntity<List<Kurs>> showkursList() {
        List<Kurs> kursList = kursService.getAllKurs();
        return new ResponseEntity<List<Kurs>>(kursList, HttpStatus.OK);
    }

    @RequestMapping(value = "/getbyId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Kurs> getLehre(@PathVariable("id") Long id) {
        Kurs kurs = (Kurs) kursService.getKurs(id);
        return new ResponseEntity<Kurs>(kurs, HttpStatus.OK);
    }
    @RequestMapping(value = "/findByName/{firstname}", method = RequestMethod.GET)
    public ResponseEntity<List<Kurs>> lehreFindByName(@PathVariable("firstname") String firstName) {
        List<Kurs> kursList = kursService.findByKursName(firstName);
        return new ResponseEntity<List<Kurs>>(kursList, HttpStatus.OK);
    }


    @RequestMapping(value = "/deletebyId/{id}", method = RequestMethod.DELETE)
    public String  delete(@PathVariable Long id) {
        return kursService.deleteLehre(id);

    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Kurs> updateLehre(@PathVariable("id") Long id,@RequestBody Kurs kurs) {
        kursService.updateKurs(id,kurs);
        return new ResponseEntity<Kurs>(kurs, HttpStatus.OK);

    }

}
