package com.educom.server.dao;

import com.educom.server.entity.Schuler;

import java.util.List;

public interface SchulerDao {
    String save(Schuler schuler);

    List<Schuler> getAllSchuler();

    Schuler getSchuler(Long id);

    List<Schuler> findByName(String firstName);

    List<Schuler> findByLastName(String lastName);

    List<Schuler> findByEmailId(String emailId);

    String deleteSchuler(Long id);

    void updateSchuler(Long id, Schuler schuler);
}
