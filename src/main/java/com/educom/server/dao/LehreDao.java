package com.educom.server.dao;

import com.educom.server.entity.Lehre;

import java.util.List;

public interface LehreDao<Lehre> {
    List<Lehre> getAll();
    String save(Lehre t);
    Lehre getById(Long id);
    String delete(Long id);
    List<Lehre> findByName(String name);
    String update(Long id,Lehre t);
    List<Lehre> findByLastName(String lastName);
    List<Lehre> findByEmail(String email);


}
