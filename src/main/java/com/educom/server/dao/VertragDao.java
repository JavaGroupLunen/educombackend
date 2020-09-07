package com.educom.server.dao;



import com.educom.server.entity.Vertrag;

import java.util.Date;
import java.util.List;

public interface VertragDao<T> {
    List<T> getAll();
    String save(T t);
    T getById(Long id);
    String delete(Long id);
    List<T> findByDate(Date vertragdate);
    String update(Long id,T t);
    List<T> getByEltern(String elternname);
    List<T> getByStatus(String status);
    List<T> getBySchuler(String name);
}
