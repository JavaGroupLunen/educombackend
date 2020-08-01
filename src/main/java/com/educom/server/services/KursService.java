package com.educom.server.services;

import com.educom.server.entity.Kurs;

import java.util.List;

public interface KursService {
    List<Kurs> getAllKurs();
    String saveKurs(Kurs kurs);
    Kurs getKurs(Long id);
    String deleteLehre(Long id);
    List<Kurs> findByKursName(String kursName);
    String updateKurs(Long id,Kurs kurs);
}
