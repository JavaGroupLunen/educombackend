package com.educom.server.services;

import com.educom.server.entity.Lehre;

import java.util.List;

public interface LehreService {
    List<Lehre> getAllLehreList();
    String saveLehreDetails(Lehre lehre);
    Lehre getLehre(Long id);
    String deleteLehre(Long id);
    List<Lehre> findByName(String firstName);
    List<Lehre> findByLastName(String lastName);
    List<Lehre> findByEmailId(String emailId);
    String updateLehre(Long id,Lehre lehre);
}
