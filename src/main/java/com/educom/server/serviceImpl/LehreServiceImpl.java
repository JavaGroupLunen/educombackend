package com.educom.server.serviceImpl;

import com.educom.server.dao.LehreDao;
import com.educom.server.entity.Lehre;
import com.educom.server.services.LehreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class LehreServiceImpl implements LehreService {
    @Autowired
    LehreDao lehreDao;

    @Override
    public List<Lehre> getAllLehreList() {
        return lehreDao.getAllLehreList();
    }

    @Override
    public String saveLehreDetails(Lehre lehre) {

        return lehreDao.saveLehreDetails(lehre);
    }

    @Override
    public Lehre getLehre(Long id) {
        return lehreDao.getLehre(id);
    }

    @Override
    public String deleteLehre(Long id) {
      lehreDao.deleteLehre(id);
        return null;
    }

    @Override
    public List<Lehre> findByName(String firstName) {
        return lehreDao.findByName(firstName);
    }

    @Override
    public List<Lehre> findByLastName(String lastName) {
        return lehreDao.findByLastName(lastName);
    }

    @Override
    public List<Lehre> findByEmailId(String emailId) {
        return lehreDao.findByEmailId(emailId);
    }


}
