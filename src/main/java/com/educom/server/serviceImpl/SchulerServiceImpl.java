package com.educom.server.serviceImpl;


import com.educom.server.dao.KursDao;
import com.educom.server.dao.SchulerDao;
import com.educom.server.entity.Schuler;
import com.educom.server.services.CrudService;
import com.educom.server.services.SchulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class SchulerServiceImpl implements SchulerService {
    private static final Logger LOGGER = Logger.getLogger(SchulerServiceImpl.class.getName());
    @Autowired
    private SchulerDao schulerDao;

    @Override
    public List<Schuler> findByLastName(String lastName) {
        return schulerDao.findByLastName(lastName);
    }

    @Override
    public List<Schuler> findByEmail(String email) {
        return schulerDao.findByEmail(email);
    }

    @Override
    public List<Schuler> getAll() {
        return schulerDao.getAll();
    }

    @Override
    public String save(Schuler schuler) {
        return schulerDao.save(schuler);
    }

    @Override
    public Schuler getById(Long id) {
        return (Schuler) schulerDao.getById(id);
    }

    @Override
    public String delete(Long id) {
        schulerDao.delete(id);
        return null;
    }

    @Override
    public List<Schuler> findByName(String firstName) {
        return schulerDao.findByName(firstName);
    }
//
//    @Override
//    public List<Schuler> findByLastName(String lastName) {
//        return schulerDao.findByLastName(lastName);
//    }
//
//    @Override
//    public List<Schuler> findByEmailId(String emailId) {
//        return schulerDao.findByEmailId(emailId);
//    }
//
    @Override
    public String update(Long id, Schuler schuler) {
         return schulerDao.update(id,schuler);

    }

}
