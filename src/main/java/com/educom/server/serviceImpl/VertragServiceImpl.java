package com.educom.server.serviceImpl;

import com.educom.server.dao.KursDao;
import com.educom.server.dao.VertragDao;
import com.educom.server.entity.Kurs;
import com.educom.server.entity.Vertrag;
import com.educom.server.services.KursService;
import com.educom.server.services.VertragService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class VertragServiceImpl implements VertragService<Vertrag> {
    @Autowired
    VertragDao vertragDao;


    @Override
    public List<Vertrag> getAll() {
        return vertragDao.getAll();
    }

    @Override
    public String save(Vertrag vertrag) {
        return vertragDao.save(vertrag);
    }

    @Override
    public Vertrag getById(Long id) {
        return (Vertrag) vertragDao.getById(id);
    }

    @Override
    public String delete(Long id) {
        return vertragDao.delete(id);
    }

    @Override
    public List<Vertrag> findByDate(Date vertragdate) {
        return vertragDao.findByDate(vertragdate);
    }

    @Override
    public String update(Long id, Vertrag vertrag) {
        return vertragDao.update(id,vertrag);
    }
}
