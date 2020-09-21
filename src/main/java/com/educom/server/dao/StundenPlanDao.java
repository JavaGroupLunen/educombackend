package com.educom.server.dao;

import java.time.LocalDate;
import java.util.List;

public interface StundenPlanDao<T> {
    List<T> getAll();
    String save(T t);
    T getById(Long id);
    String delete(Long id);
    List<T> findByDate(LocalDate name);
    String update(Long id,T t);
}
