package com.educom.server.daoImpl;

import com.educom.server.dao.Dao;
import com.educom.server.entity.Kurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Component
@Transactional
@Repository
public class KursDaoImpl implements Dao<Kurs> {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Kurs> getAll() {
        List<Kurs> kursList=entityManager.createQuery("from Kurs").getResultList();
        return kursList;
    }

    @Override
    public String save(Kurs kurs) {
        entityManager.merge(kurs);

        return "success";
    }

    @Override
    public Kurs getById(Long id) {
        Kurs obj = entityManager.find(Kurs.class, id);
        return obj;
    }

    @Override
    public String delete(Long id) {
        Kurs kurs = getById(id);
        entityManager.remove(kurs);
        return "removed";
    }

    @Override
    public List<Kurs> findByName(String name) {
        return entityManager.createQuery(
                "from Kurs where name LIKE CONCAT('%', :name,'%')")
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public String update(Long id, Kurs kurs) {
        Kurs updatekurs = getById(id);
        updatekurs.setName(kurs.getName());
        updatekurs.setRaum(kurs.getRaum());
        System.out.println(updatekurs.getId());
        entityManager.merge(updatekurs);
        return "success";
    }
}
