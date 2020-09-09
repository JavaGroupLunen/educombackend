package com.educom.server.auth;

import com.educom.server.auth.jwt.model.EducomUser;
import com.educom.server.auth.jwt.model.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
      Optional<EducomUser> user= userRepository.findByUserName(s);
      user.orElseThrow(()->new UsernameNotFoundException("Not found: "+ s));
      return user.map(MyUserDetails::new).get();

    }

    public UserDetails loadUserByEmail(String s) throws UsernameNotFoundException {
        Optional<EducomUser> user= userRepository.findByEmail(s);
        user.orElseThrow(()->new UsernameNotFoundException("Not found: "+ s));
        return user.map(MyUserDetails::new).get();

    }
}
