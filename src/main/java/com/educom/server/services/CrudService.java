package com.educom.server.services;

import java.util.List;

   public interface CrudService<Lehre> {
        List<Lehre> getAll();
        String save(Lehre t);
       Lehre getById(Long id);
        String delete(Long id);
        List<Lehre> findByName(String kursName);
        String update(Long id, Lehre t);

    }

