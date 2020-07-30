package com.educom.server.daoImpl;

import com.educom.server.dao.SchulerDao;
import com.educom.server.entity.Schuler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Component
@Transactional
@Repository
public class SchulerDaoImpl implements SchulerDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public String save(Schuler schuler) {
        entityManager.merge(schuler);
        return "success";
    }

    @Override
    public List<Schuler> getAllSchuler() {
        List<Schuler> schulerList=entityManager.createQuery("from Schuler").getResultList();

        return schulerList;
    }

    @Override
    public Schuler getSchuler(Long id) {
        Schuler obj = entityManager.find(Schuler.class, id);
        return obj;
    }

    @Override
    public List<Schuler> findByName(String firstName) {
        return entityManager.createQuery(
                "from Schuler where firstName LIKE CONCAT('%', :firstName,'%')")
                .setParameter("firstName", firstName)
                .getResultList();
    }
    @Override
    public List<Schuler> findByLastName(String lastName) {
        return entityManager.createQuery(
                "from Schuler where lastName  LIKE CONCAT('%', :lastName,'%')")
                .setParameter("lastName", lastName)
                .getResultList();
    }
    @Override
    public List<Schuler> findByEmailId(String emailId) {
        return entityManager.createQuery(
                "from Schuler where emailId LIKE CONCAT('%',:emailId,'%')")
                .setParameter("emailId", emailId)
                .getResultList();
    }

    @Override
    public String deleteSchuler(Long id) {
        Schuler schuler = getSchuler(id);
        entityManager.remove(schuler);
        return "removed";
    }

    @Override
    public void updateSchuler(Long id, Schuler schuler) {
        Schuler updateschuler =getSchuler(id);
        updateschuler.setEmailId(schuler.getEmailId());
        updateschuler.setFirstName(schuler.getFirstName());
        updateschuler.setLastName(schuler.getLastName());
        System.out.println(schuler.getId());
        entityManager.merge(updateschuler);
    }
}
