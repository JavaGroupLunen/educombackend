package com.educom.server.services;

import com.educom.server.entity.Lehre;

import java.util.List;

public interface LehreService {
    public List<Lehre> getAllLehreList();
    public String saveLehreDetails(Lehre lehre);
    public Lehre getLehre(Long id);
    public String deleteLehre(Long id);
    public List<Lehre> findByName(String firstName);
    public List<Lehre> findByLastName(String lastName);
    List<Lehre> findByEmailId(String emailId);
}
