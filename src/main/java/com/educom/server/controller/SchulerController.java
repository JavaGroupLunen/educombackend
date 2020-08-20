package com.educom.server.controller;


import com.educom.server.entity.Schuler;
import com.educom.server.services.SchulerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/schuler")
public class SchulerController {
    @Autowired
    private SchulerService schulerService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(@RequestBody Schuler schuler) {
        System.out.println(schuler.toString());
        return schulerService.save(schuler);
    }

    @RequestMapping(value = "/schulerlist", method = RequestMethod.GET)
    public ResponseEntity<List<Schuler>> showList() {
        List<Schuler> schulerList = schulerService.getAll();
//       schulerList.forEach((e)->{
//           System.out.println(e.toString());
//       });
        return new ResponseEntity<List<Schuler>>(schulerList, HttpStatus.OK);
    }

    @RequestMapping(value = "/getbyId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Schuler> getById(@PathVariable("id") Long id) {
        Schuler schuler = (Schuler) schulerService.getById(id);
        return new ResponseEntity<Schuler>(schuler, HttpStatus.OK);
    }
    @RequestMapping(value = "/findByName/{firstname}", method = RequestMethod.GET)
    public ResponseEntity<List<Schuler>> findByName(@PathVariable("firstname") String firstName) {
        List<Schuler> schulerList = schulerService.findByName(firstName);
        return new ResponseEntity<List<Schuler>>(schulerList, HttpStatus.OK);
    }
    @RequestMapping(value = "/findByLastName/{lastName}", method = RequestMethod.GET)
    public ResponseEntity<List<Schuler>> findByLastName(@PathVariable("lastName") String lastName) {
        List<Schuler> schulerList = schulerService.findByLastName(lastName);
        return new ResponseEntity<List<Schuler>>(schulerList, HttpStatus.OK);
    }
    @RequestMapping(value = "/findByEmail/{email}", method = RequestMethod.GET)
    public ResponseEntity<List<Schuler>> findByEmail(@PathVariable("email") String email) {
        List<Schuler> lehreList = schulerService.findByEmail(email);
        return new ResponseEntity<List<Schuler>>(lehreList, HttpStatus.OK);
    }

    @RequestMapping(value = "/deletebyId/{id}", method = RequestMethod.DELETE)
    public String  deleteLehre(@PathVariable Long id) {
        return schulerService.delete(id);

    }
    @RequestMapping(value = "/updateschuler/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Schuler> updateLehre(@PathVariable("id") Long id,@RequestBody Schuler schuler) {
        schulerService.update(id,schuler);
        return new ResponseEntity<Schuler>(schuler, HttpStatus.OK);

    }


}
