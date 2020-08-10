package com.educom.server.dao;



import java.util.List;

public interface KursDao<T> {
    List<T> getAll();
    String save(T t);
    T getById(Long id);
    String delete(Long id);
    List<T> findByName(String name);
    String update(Long id,T t);
}
