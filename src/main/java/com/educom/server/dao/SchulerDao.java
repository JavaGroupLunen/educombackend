package com.educom.server.dao;

import com.educom.server.entity.Schuler;

import java.util.List;

public interface SchulerDao {
    List<Schuler> getAll();
    String save(Schuler schuler);
    Schuler getById(Long id);
    String delete(Long id);
    List<Schuler> findByName(String name);
    String update(Long id,Schuler schuler);
    List<Schuler> findByLastName(String lastName);
    List<Schuler> findByEmail(String email);
}
