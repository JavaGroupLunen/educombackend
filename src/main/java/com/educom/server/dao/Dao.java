package com.educom.server.dao;

import com.educom.server.entity.Kurs;
import com.educom.server.entity.Lehre;

import java.util.List;

public interface Dao<T> {
    List<T> getAll();
    String save(T t);
    T getById(Long id);
    String delete(Long id);
    List<T> findByName(String name);
    String update(Long id,T t);
}
