package com.educom.server.daoImpl;

import com.educom.server.dao.LehreDao;
import com.educom.server.entity.Lehre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Component
@Transactional
@Repository
public class LehreDaoImpl implements LehreDao {

    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Lehre> getAllLehreList() {

        List<Lehre> lehreList=entityManager.createQuery("from Lehre").getResultList();

        return lehreList;
    }

    @Override
    public String saveLehreDetails(Lehre lehre) {

        entityManager.merge(lehre);

        return "success";
    }
}
