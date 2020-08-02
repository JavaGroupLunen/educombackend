package com.educom.server.daoImpl;

import com.educom.server.dao.SchulerDao;
import com.educom.server.entity.Schuler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Transactional
@Repository
public class SchulerDaoImpl implements SchulerDao {
    private static final Logger LOGGER = Logger.getLogger(SchulerDaoImpl.class.getName());
    @Autowired
    private EntityManager entityManager;

    @Override
    public String save(Schuler schuler) {
        if(schuler==null){
            LOGGER.log(Level.SEVERE,	"Schuler is null. ");
            return null;
        }
        entityManager.merge(schuler);
        return "success";
    }

    @Override
    public List<Schuler> getAllSchuler() {
        List<Schuler> schulerList=entityManager.createQuery("from Schuler").getResultList();
        if(schulerList.isEmpty()){
            LOGGER.log(Level.SEVERE,	"Keine Schuler in der Datenbank registriert");
            return null;
        }
        return schulerList;
    }

    @Override
    public Schuler getSchuler(Long id) {
        Schuler obj = entityManager.find(Schuler.class, id);
        if(obj==null){
            LOGGER.log(Level.SEVERE,	"Keine Schuler mit Id : "+id+" in der Datenbank registriert");
            return null;
        }
        return obj;
    }

    @Override
    public List<Schuler> findByName(String firstName) {
        try {
            return entityManager.createQuery(
                    "from Schuler where firstName LIKE CONCAT('%', :firstName,'%')")
                    .setParameter("firstName", firstName)
                    .getResultList();
        }catch(NullPointerException e){
            LOGGER.log(Level.SEVERE,	"Keine Schuler mit : "+firstName+" in der Datenbank registriert");
            e.getMessage();

        }
        return null;
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
        updateschuler.setEmail(schuler.getEmail());
        updateschuler.setFirstName(schuler.getFirstName());
        updateschuler.setLastName(schuler.getLastName());
        entityManager.merge(updateschuler);

    }
}
