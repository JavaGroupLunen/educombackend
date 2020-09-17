package com.educom.server.controller;

import com.educom.server.entity.Vertrag;
import com.educom.server.services.VertragService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/vertrag")
public class VertragController {
    @Autowired
    private VertragService vertragService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(@RequestBody Vertrag requestparam) {
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
    @RequestMapping(value = "/findbyschuler/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Vertrag>> lehreFindBySchulerName(@PathVariable("name") String name) {
        List<Vertrag> vertragList = vertragService.findBySchuler(name);
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
        return new ResponseEntity<>(vertrag, HttpStatus.OK);

    }

}
