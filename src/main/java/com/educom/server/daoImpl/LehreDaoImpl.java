package com.educom.server.daoImpl;

import com.educom.server.dao.KursDao;
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
public class LehreDaoImpl implements LehreDao<Lehre> {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Lehre> getAll() {
        List<Lehre> lehreList = entityManager.createQuery("from Lehre").getResultList();
        return lehreList;
    }

    @Override
    public String save(Lehre lehre) {
        entityManager.merge(lehre);
        return "success";
    }

    @Override
    public String update(Long id, Lehre lehre) {
        Lehre updatelehre = getById(id);
        updatelehre.setEmail(lehre.getEmail());
        updatelehre.setFirstName(lehre.getFirstName());
        updatelehre.setLastName(lehre.getLastName());
        System.out.println(lehre.getId());
        entityManager.merge(updatelehre);
        return "success";
    }

    @Override
    public Lehre getById(Long id) {
        Lehre obj = entityManager.find(Lehre.class, id);
        return obj;
    }

    @Override
    public String delete(Long id) {
        Lehre lehre = getById(id);
        entityManager.remove(lehre);
        return "removed";
    }

    @Override
    public List<Lehre> findByName(String firstName) {
        return entityManager.createQuery(
                "from Lehre where firstName LIKE CONCAT('%', :firstName,'%')")
                .setParameter("firstName", firstName)
                .getResultList();
    }


    public List<Lehre> findByLastName(String lastName) {
        return entityManager.createQuery(
                "from Lehre where lastName  LIKE CONCAT('%', :lastName,'%')")
                .setParameter("lastName", lastName)
                .getResultList();
    }

    public List<Lehre> findByEmail(String email) {
        return entityManager.createQuery(
                "from Lehre where email LIKE CONCAT('%',:email,'%')")
                .setParameter("emailId", email)
                .getResultList();
    }

}
