package com.educom.server.dao;



import java.util.List;

public interface KursDao<Lehre> {
    List<Lehre> getAll();
    String save(Lehre t);
    Lehre getById(Long id);
    String delete(Long id);
    List<Lehre> findByName(String name);
    String update(Long id,Lehre t);
}
