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
        return kursDao.getAllKurs();
    }

    @Override
    public String saveKurs(Kurs kurs) {
        return kursDao.saveKurs(kurs);
    }

    @Override
    public Kurs getKurs(Long id) {
        return kursDao.getKurs(id);
    }

    @Override
    public String deleteLehre(Long id) {
        return kursDao.deleteKurs(id);
    }

    @Override
    public List<Kurs> findByKursName(String kursName) {
        return kursDao.findByKursName(kursName);
    }

    @Override
    public String updateKurs(Long id, Kurs kurs) {
        return kursDao.updateKurs(id,kurs);
    }
}
