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
            LOGGER.log(Level.SEVERE,"Schuler is null. ");
            return null;
        }
        entityManager.persist(schuler);
        return "success";
    }

    @Override
    public List<Schuler> getAll() {
        List<Schuler> schulerList=entityManager.createQuery("from Schuler").getResultList();
        if(schulerList.isEmpty()){
            LOGGER.log(Level.SEVERE,	"Keine Schuler in der Datenbank registriert");
            return null;
       }
        return schulerList;
    }


    @Override
    public Schuler getById(Long id) {
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



    public List<Schuler> findByLastName(String lastName) {
        return entityManager.createQuery(
                "from Schuler where lastName  LIKE CONCAT('%', :lastName,'%')")
                .setParameter("lastName", lastName)
                .getResultList();
    }

    public List<Schuler> findByEmail(String email) {
        return entityManager.createQuery(
                "from Schuler where email LIKE CONCAT('%',:email,'%')")
                .setParameter("email", email)
                .getResultList();
    }

    @Override
    public String delete(Long id) {
        Schuler schuler = getById(id);
        entityManager.remove(schuler);
        return "removed";
    }

    @Override
    public String update(Long id, Schuler schuler) {
        Schuler updateschuler =getById(id);
        updateschuler.setEmail(schuler.getEmail());
        updateschuler.setFirstName(schuler.getFirstName());
        updateschuler.setLastName(schuler.getLastName());
        updateschuler.setAdres(schuler.getAdres());
        updateschuler.setStadt(schuler.getStadt());
        updateschuler.setPhoneNumber(schuler.getPhoneNumber());
        updateschuler.setGeburstDatum(schuler.getGeburstDatum());
        updateschuler.setPlz(schuler.getPlz());
        entityManager.merge(updateschuler);
        return "updated";

    }
}
