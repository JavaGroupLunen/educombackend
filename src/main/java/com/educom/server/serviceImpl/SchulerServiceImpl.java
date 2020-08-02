package com.educom.server.serviceImpl;


import com.educom.server.dao.SchulerDao;
import com.educom.server.entity.Schuler;
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
    public List<Schuler> getAllSchuler() {
        return schulerDao.getAllSchuler();
    }

    @Override
    public String save(Schuler schuler) {
        return schulerDao.save(schuler);
    }

    @Override
    public Schuler getSchuler(Long id) {
        return schulerDao.getSchuler(id);
    }

    @Override
    public String deleteSchuler(Long id) {
        schulerDao.deleteSchuler(id);
        return null;
    }

    @Override
    public List<Schuler> findByName(String firstName) {
        return schulerDao.findByName(firstName);
    }

    @Override
    public List<Schuler> findByLastName(String lastName) {
        return schulerDao.findByLastName(lastName);
    }

    @Override
    public List<Schuler> findByEmailId(String emailId) {
        return schulerDao.findByEmailId(emailId);
    }

    @Override
    public void updateSchuler(Long id,Schuler schuler) {
         schulerDao.updateSchuler(id,schuler);
    }

}
