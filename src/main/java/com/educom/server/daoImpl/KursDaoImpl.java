package com.educom.server.daoImpl;

import com.educom.server.dao.KursDao;
import com.educom.server.entity.Kurs;
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
public class KursDaoImpl implements KursDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Kurs> getAllKurs() {
        List<Kurs> kursList=entityManager.createQuery("from Kurs").getResultList();

        return kursList;
    }

    @Override
    public String saveKurs(Kurs kurs) {
        entityManager.merge(kurs);

        return "success";
    }

    @Override
    public Kurs getKurs(Long id) {
        Kurs obj = entityManager.find(Kurs.class, id);
        return obj;
    }

    @Override
    public String deleteKurs(Long id) {
        Kurs kurs = getKurs(id);
        entityManager.remove(kurs);
        return "removed";
    }

    @Override
    public List<Kurs> findByKursName(String name) {
        return entityManager.createQuery(
                "from Kurs where name LIKE CONCAT('%', :name,'%')")
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public String updateKurs(Long id, Kurs kurs) {
        Kurs updatekurs = getKurs(id);
        updatekurs.setName(kurs.getName());
        updatekurs.setRaum(kurs.getRaum());
        System.out.println(updatekurs.getId());
        entityManager.merge(updatekurs);
        return "success";
    }
}
