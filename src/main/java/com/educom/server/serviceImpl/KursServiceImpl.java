package com.educom.server.serviceImpl;

import com.educom.server.dao.KursDao;
import com.educom.server.entity.Kurs;
import com.educom.server.services.KursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class KursServiceImpl implements KursService {
    @Autowired
    KursDao kursDao;


    @Override
    public List<Kurs> getAllKurs() {
        return kursDao.getAll();
    }

    @Override
    public String saveKurs(Kurs kurs) {
        return kursDao.save(kurs);
    }

    @Override
    public Kurs getKurs(Long id) {
        return (Kurs) kursDao.getById(id);
    }

    @Override
    public String deleteLehre(Long id) {
        return kursDao.delete(id);
    }

    @Override
    public List<Kurs> findByKursName(String kursName) {
        return kursDao.findByName(kursName);
    }

    @Override
    public String updateKurs(Long id, Kurs kurs) {
        return kursDao.update(id,kurs);
    }
}
