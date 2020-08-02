package com.educom.server.serviceImpl;

import com.educom.server.dao.Dao;
import com.educom.server.entity.Kurs;
import com.educom.server.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class KursServiceImpl implements CrudService<Kurs> {
    @Autowired
    Dao kursDao;

    @Override
    public List<Kurs> getAll() {
        return kursDao.getAll();
    }

    @Override
    public String save(Kurs kurs) {
        return kursDao.save(kurs);
    }

    @Override
    public Kurs getById(Long id) {
        return (Kurs) kursDao.getById(id);
    }

    @Override
    public String delete(Long id) {
        return kursDao.delete(id);
    }

    @Override
    public List<Kurs> findByName(String kursName) {
        return kursDao.findByName(kursName);
    }

    @Override
    public String update(Long id, Kurs kurs) {
        return kursDao.update(id,kurs);
    }
}
