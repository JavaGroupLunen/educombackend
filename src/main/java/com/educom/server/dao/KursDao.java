package com.educom.server.dao;

import com.educom.server.entity.Kurs;
import com.educom.server.entity.Lehre;

import java.util.List;

public interface KursDao {
    List<Kurs> getAllKurs();
    String saveKurs(Kurs kurs);
    Kurs getKurs(Long id);
    String deleteKurs(Long id);
    List<Kurs> findByKursName(String kursName);
    String updateKurs(Long id,Kurs kurs);
}
