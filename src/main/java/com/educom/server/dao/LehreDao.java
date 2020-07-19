package com.educom.server.dao;

import com.educom.server.entity.Lehre;

import java.util.List;

public interface LehreDao {
    public List<Lehre> getAllLehreList();
    public String saveLehreDetails(Lehre lehre);
    Lehre getLehre(Long id);
    public String deleteLehre(Long id);
    public List<Lehre> findByName(String firstName);
    public List<Lehre> findByLastName(String lastName);
    List<Lehre> findByEmailId(String emailId);

}
