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
    public Lehre getLehre(Long id) {

        Lehre obj = entityManager.find(Lehre.class, id);
        return obj;
    }

    @Override
    public void deleteLehre(Long id) {
        Lehre lehre = getLehre(id);
        entityManager.remove(lehre);
    }

    public List<Lehre> findWithName(String name) {
        return entityManager.createQuery(
                "from Lehre where name LIKE ?1")
                .setParameter(1, name)
                .getResultList();
    }

}
