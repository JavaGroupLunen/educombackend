package com.educom.server.controller;

import com.educom.server.dao.KursRepo;
import com.educom.server.dao.VertragDao;
import com.educom.server.entity.Kurs;
import com.educom.server.entity.Vertrag;
import com.educom.server.services.VertragService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/vertrag")
public class VertragController {
    @Autowired
    private VertragService vertragService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(@RequestBody Vertrag requestparam) {
        //Kurs kurs = new Kurs(requestparam.get("name").toString(), requestparam.get("raum").toString());
        return vertragService.save(requestparam);
    }

    @RequestMapping(value = "/vertraglist", method = RequestMethod.GET)
    public ResponseEntity<List<Vertrag>> showList() {
        List<Vertrag> vertragList = vertragService.getAll();
        return new ResponseEntity<List<Vertrag>>(vertragList, HttpStatus.OK);
    }

    @RequestMapping(value = "/getbyId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Vertrag> getLehre(@PathVariable("id") Long id) {
        Vertrag vertrag = (Vertrag) vertragService.getById(id);
        return new ResponseEntity<Vertrag>(vertrag, HttpStatus.OK);
    }
    @RequestMapping(value = "/findByName/{firstname}", method = RequestMethod.GET)
    public ResponseEntity<List<Vertrag>> lehreFindByName(@PathVariable("firstname") Date vertragDate) {
        List<Vertrag> vertragList = vertragService.findByDate(vertragDate);
        return new ResponseEntity<List<Vertrag>>(vertragList, HttpStatus.OK);
    }

    @RequestMapping(value = "/findbyelternname/{elternname}", method = RequestMethod.GET)
    public ResponseEntity<List<Vertrag>> lehreFindByName(@PathVariable("elternname") String elternname) {
        List<Vertrag> vertragList = vertragService.findByEltern(elternname);
        return new ResponseEntity<List<Vertrag>>(vertragList, HttpStatus.OK);
    }
    @RequestMapping(value = "/deletebyId/{id}", method = RequestMethod.DELETE)
    public String  delete(@PathVariable Long id) {
        return vertragService.delete(id);

    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Vertrag> updateLehre(@PathVariable("id") Long id,@RequestBody Vertrag vertrag) {
        vertragService.update(id,vertrag);
        return new ResponseEntity<Vertrag>(vertrag, HttpStatus.OK);

    }

}
