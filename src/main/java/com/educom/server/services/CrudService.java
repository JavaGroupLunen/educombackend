package com.educom.server.services;

import java.util.List;

   public interface CrudService<T> {
        List<T> getAll();
        String save(T t);
        T getById(Long id);
        String delete(Long id);
        List<T> findByName(String kursName);
        String update(Long id,T t);

    }

