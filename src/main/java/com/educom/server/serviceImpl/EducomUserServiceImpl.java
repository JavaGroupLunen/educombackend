package com.educom.server.serviceImpl;

import com.educom.server.auth.RefreshTokenRepository;
import com.educom.server.auth.RoleRepository;
import com.educom.server.auth.UserRepository;
import com.educom.server.auth.jwt.model.*;
import com.educom.server.entity.ERole;
import com.educom.server.entity.Role;
import com.educom.server.services.EducomUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.*;

@Component
@AllArgsConstructor
public class EducomUserServiceImpl implements EducomUserService<EducomUser> {
    @Autowired
    private final  UserRepository userRepository;
    @Autowired
    private final  PasswordEncoder encoder;
    @Autowired
    private final   RoleRepository roleRepository;
    @Autowired
    private final RefreshTokenRepository refreshTokenRepository;
    @Override
    public List<EducomUser> getAll() {
        return userRepository.findAll();
    }

    @Override
    public String save(SignupRequest signupRequest) {
        EducomUser user= new EducomUser();
        user.setUserName(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setActive(true);
        user.setRoles(getUserRole(signupRequest));
        user.setPassword(encoder.encode(signupRequest.getPassword()));
//        user.setRoles("Admin");
         userRepository.save(user);
        return "Succecefull";
    }

    @Override
    public EducomUser getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public String delete(Long id) {
         userRepository.deleteById(id);
        return "Successefull";
    }

    @Override
    public Optional<EducomUser> findByUserName(String username) {
        return userRepository.findByUserName(username);
    }
    //TODO: Update muss ändern
    @Override
    public String update(Long id, EducomUser educomUser) {
         userRepository.saveAndFlush(educomUser);
         return "updated";
    }


    private Set<Role> getUserRole(SignupRequest signupRequest){

    Set<String> strRoles = signupRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
    } else {
        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);

                    break;
                case "mod":
                    Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(modRole);

                    break;
                default:
                    Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
            }
        });
    }
    return roles;
}


}
