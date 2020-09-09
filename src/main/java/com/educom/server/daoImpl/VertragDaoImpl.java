package com.educom.server.daoImpl;

import com.educom.server.dao.VertragDao;
import com.educom.server.dao.VertragDao;
import com.educom.server.entity.Vertrag;
import com.educom.server.entity.Vertrag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

import static org.apache.tomcat.jni.Time.now;

@Component
@Transactional
@Repository
public class VertragDaoImpl implements VertragDao<Vertrag> {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Vertrag> getAll() {
        List<Vertrag> vertragList=entityManager.createQuery("from Vertrag").getResultList();
        return vertragList;
    }

    @Override
    public String save(Vertrag vertrag) {
        vertrag.setVertragsdatum(new Date());
        entityManager.merge(vertrag);
        System.out.println(vertrag);
        return "success";
    }

    @Override
    public Vertrag getById(Long id) {
        Vertrag obj = entityManager.find(Vertrag.class, id);
        return obj;
    }

    @Override
    public String delete(Long id) {
        Vertrag vertrag = getById(id);
        entityManager.remove(vertrag);
        return "removed";
    }

    @Override
    public List<Vertrag> findByDate(Date vertragdate) {
        return entityManager.createQuery(
                "from Vertrag where vertragdate LIKE CONCAT('%', :vertragdate,'%')")
                .setParameter("vertragdate", vertragdate)
                .getResultList();
    }

    @Override
    public String update(Long id, Vertrag vertrag) {
        Vertrag updateVertrag = getById(id);
        updateVertrag.setAnmeldegebuhr(vertrag.getAnmeldegebuhr());
        updateVertrag.setZahlungstype(vertrag.getZahlungstype());
        System.out.println(updateVertrag.getId());
        entityManager.merge(updateVertrag);
        return "success";
    }

    @Override
    public List<Vertrag> getByEltern(String elternname) {
          return entityManager.createQuery(
                "select v from Vertrag v inner join v.schuler s where s.vater LIKE CONCAT('%', :elternname,'%') OR  s.mutter LIKE CONCAT('%', :elternname,'%')")
                .setParameter("elternname", elternname)
                .getResultList();
    }
    //TODO:Buraya status e göre arama eklenecek
    @Override
    public List<Vertrag> getByStatus(String status) {
        return null;
    }

    @Override
    public List<Vertrag> getBySchuler(String name) {
         return entityManager.createQuery(
                "select v from Vertrag v join v.schuler s where s.lastName LIKE CONCAT('%', :name,'%') OR  s.firstName LIKE CONCAT('%', :name,'%')")
                .setParameter("name", name)
                .getResultList();
    }
}
