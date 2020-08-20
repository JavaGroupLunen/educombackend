package com.educom.server.controller;
import com.educom.server.auth.AuthenticationRequest;
import com.educom.server.auth.MyUserDetailsService;
import com.educom.server.auth.jwt.AuthenticationResponse;
import com.educom.server.auth.jwt.JwtUtil;
import com.educom.server.entity.EducomUser;
import com.educom.server.entity.Schuler;
import com.educom.server.serviceImpl.EducomUserServiceImpl;
import com.educom.server.services.EducomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class HomeController {
@Autowired
private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private EducomUserService educomUserService;

    @RequestMapping(value="/register", method= RequestMethod.POST)
    public String save(@RequestBody EducomUser educomUser) {
        System.out.println(educomUser.toString());
        return educomUserService.save(educomUser);
    }

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ResponseEntity<List<EducomUser>> showList() {
        List<EducomUser> educomUserList = educomUserService.getAll();
//       schulerList.forEach((e)->{
//           System.out.println(e.toString());
//       });
        return new ResponseEntity<List<EducomUser>>(educomUserList, HttpStatus.OK);
    }

    @RequestMapping(value = "/getbyId/{id}", method = RequestMethod.GET)
    public ResponseEntity<EducomUser> getById(@PathVariable("id") Long id) {
        EducomUser educomUser = (EducomUser) educomUserService.getById(id);
        return new ResponseEntity<EducomUser>(educomUser, HttpStatus.OK);
    }
    @RequestMapping(value = "/findbyusername/{userName}", method = RequestMethod.GET)
    public ResponseEntity<EducomUser> findByName(@PathVariable("firstname") String userName) {
       Optional<EducomUser> educomUser = educomUserService.findByUserName(userName);
        return new ResponseEntity<EducomUser>(educomUser.get(), HttpStatus.OK);
    }


    @RequestMapping(value="/signin",method= RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
