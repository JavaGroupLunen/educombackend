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
        return lehreDao.getAll();
    }

    @Override
    public String saveLehreDetails(Lehre lehre) {

        return lehreDao.save(lehre);
    }

    @Override
    public Lehre getLehre(Long id) {
        return (Lehre) lehreDao.getById(id);
    }

    @Override
    public String deleteLehre(Long id) {
      lehreDao.delete(id);
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
    public List<Lehre> findByEmailId(String email) {
        return lehreDao.findByEmail(email);
    }

    @Override
    public String updateLehre(Long id,Lehre lehre) {
        return lehreDao.update(id,lehre);
    }


}
