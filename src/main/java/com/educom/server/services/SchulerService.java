package com.educom.server.services;

import com.educom.server.entity.Schuler;

import java.util.List;

public interface SchulerService {
    List<Schuler> findByLastName(String lastName);
    List<Schuler> findByEmail(String email);
    List<Schuler> getAll();
    String save(Schuler schuler);
    Schuler getById(Long id);
    String delete(Long id);
    List<Schuler> findByName(String kursName);
    String update(Long id, Schuler schuler);
}
