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
    @Override
    public String updateLehre(Lehre lehre) {
//        Lehre updatelehre =getLehre(lehre.getId());
//        updatelehre.setId(lehre.getId());
//        updatelehre.setEmailId(lehre.getEmailId());
//        updatelehre.setFirstName(lehre.getFirstName());
//        updatelehre.setLastName(lehre.getLastName());
//        System.out.println(lehre.getId());
        entityManager.merge(lehre);

        return "success";
    }

    @Override
    public Lehre getLehre(Long id) {

        Lehre obj = entityManager.find(Lehre.class, id);
        return obj;
    }

    @Override
    public String deleteLehre(Long id) {
        Lehre lehre = getLehre(id);
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
    @Override
    public List<Lehre> findByLastName(String lastName) {
        return entityManager.createQuery(
                "from Lehre where lastName  LIKE CONCAT('%', :lastName,'%')")
                .setParameter("lastName", lastName)
                .getResultList();
    }
    @Override
    public List<Lehre> findByEmailId(String emailId) {
        return entityManager.createQuery(
                "from Lehre where emailId LIKE CONCAT('%',:emailId,'%')")
                .setParameter("emailId", emailId)
                .getResultList();
    }

}
