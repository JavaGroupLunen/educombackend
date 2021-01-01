package com.educom.server.controller;
import com.educom.server.auth.jwt.model.AuthenticationRequest;
import com.educom.server.auth.MyUserDetailsService;
import com.educom.server.auth.jwt.model.AuthenticationResponse;
import com.educom.server.auth.jwt.JwtUtil;
import com.educom.server.auth.jwt.model.SignupRequest;
import com.educom.server.auth.jwt.model.EducomUser;
import com.educom.server.services.EducomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
public class AuthController {
@Autowired
private AuthenticationManager authenticationManager;
    @Autowired
    private Environment env;
    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private EducomUserService educomUserService;

    @GetMapping("/status/check")
    public String status() {
        return "working on port " + env.getProperty("local.server.port")+", with token ="+env.getProperty("token.secret");
    }

    @RequestMapping(value="/register", method= RequestMethod.POST)
    public String save(@RequestBody SignupRequest signupRequest) {
        return educomUserService.save(signupRequest);
    }

    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public ResponseEntity<List<EducomUser>> showList() {
        List<EducomUser> educomUserList = educomUserService.getAll();
        return new ResponseEntity<>(educomUserList, HttpStatus.OK);
    }

    @RequestMapping(value = "/getbyId/{id}", method = RequestMethod.GET)
    public ResponseEntity<EducomUser> getById(@PathVariable("id") Long id) {
        EducomUser educomUser = (EducomUser) educomUserService.getById(id);
        return new ResponseEntity<>(educomUser, HttpStatus.OK);
    }
    @RequestMapping(value = "/findbyusername/{userName}", method = RequestMethod.GET)
    public ResponseEntity<EducomUser> findByName(@PathVariable("username") String userName) {
       Optional<EducomUser> educomUser = educomUserService.findByUserName(userName);
      if(educomUser.isPresent()){
          return new ResponseEntity<>(educomUser.get(), HttpStatus.OK);
      }
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @RequestMapping(value="/signin",method= RequestMethod.POST)
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            System.out.println(authenticationRequest.toString());
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
