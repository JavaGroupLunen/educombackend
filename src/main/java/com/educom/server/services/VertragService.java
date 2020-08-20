package com.educom.server.services;

import com.educom.server.entity.Schuler;

import java.util.Date;
import java.util.List;

public interface VertragService<T> {
    List<T> getAll();
    String save(T t);
    T getById(Long id);
    String delete(Long id);
    List<T> findByDate(Date vertragdate);
    String update(Long id,T t);
}
