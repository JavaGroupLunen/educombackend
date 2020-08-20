package com.educom.server.serviceImpl;

import com.educom.server.auth.UserRepository;
import com.educom.server.dao.VertragDao;
import com.educom.server.entity.EducomUser;
import com.educom.server.entity.Vertrag;
import com.educom.server.services.EducomUserService;
import com.educom.server.services.VertragService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class EducomUserServiceImpl implements EducomUserService<EducomUser> {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<EducomUser> getAll() {
        return userRepository.findAll();
    }

    @Override
    public String save(EducomUser educomUser) {
        EducomUser user= new EducomUser();
        user.setUserName(educomUser.getUserName());
        user.setEmail(educomUser.getEmail());
        user.setActive(true);
        user.setPassword(educomUser.getPassword());
        user.setRoles("Admin");
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
}
