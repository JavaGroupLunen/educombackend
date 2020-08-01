package com.educom.server.controller;

import com.educom.server.entity.Kurs;
import com.educom.server.entity.Schuler;
import com.educom.server.services.KursService;
import com.educom.server.services.SchulerService;
import org.json.simple.JSONObject;
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
    public String saveSchuler(@RequestBody JSONObject requestparam) {
        Kurs kurs = new Kurs(requestparam.get("name").toString(), requestparam.get("raum").toString());
        return kursService.saveKurs(kurs);
    }
//
//    @RequestMapping(value = "/schulerlist", method = RequestMethod.GET)
//    public ResponseEntity<List<Schuler>> showSchulerList() {
//        List<Schuler> schulerList = schulerService.getAllSchuler();
//        return new ResponseEntity<List<Schuler>>(schulerList, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/getbyId/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Schuler> getLehre(@PathVariable("id") Long id) {
//        Schuler schuler = schulerService.getSchuler(id);
//        return new ResponseEntity<Schuler>(schuler, HttpStatus.OK);
//    }
//    @RequestMapping(value = "/findByName/{firstname}", method = RequestMethod.GET)
//    public ResponseEntity<List<Schuler>> lehreFindByName(@PathVariable("firstname") String firstName) {
//        List<Schuler> schulerList = schulerService.findByName(firstName);
//        return new ResponseEntity<List<Schuler>>(schulerList, HttpStatus.OK);
//    }
//    @RequestMapping(value = "/findByLastName/{lastName}", method = RequestMethod.GET)
//    public ResponseEntity<List<Schuler>> lehreFindByLastName(@PathVariable("lastName") String lastName) {
//        List<Schuler> schulerList = schulerService.findByLastName(lastName);
//        return new ResponseEntity<List<Schuler>>(schulerList, HttpStatus.OK);
//    }
//    @RequestMapping(value = "/findByEmailId/{emailId}", method = RequestMethod.GET)
//    public ResponseEntity<List<Schuler>> lehreFindByEmailId(@PathVariable("emailId") String emailId) {
//        List<Schuler> lehreList = schulerService.findByEmailId(emailId);
//        return new ResponseEntity<List<Schuler>>(lehreList, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/deletebyId/{id}", method = RequestMethod.DELETE)
//    public String  deleteLehre(@PathVariable Long id) {
//        return schulerService.deleteSchuler(id);
//
//    }
//    @RequestMapping(value = "/updateschuler/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Schuler> updateLehre(@PathVariable("id") Long id,@RequestBody Schuler schuler) {
//        schulerService.updateSchuler(id,schuler);
//        return new ResponseEntity<Schuler>(schuler, HttpStatus.OK);
//
//    }

}
