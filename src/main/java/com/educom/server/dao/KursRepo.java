package com.educom.server.dao;

import com.educom.server.entity.Kurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KursRepo extends JpaRepository<Kurs, Long> {
}
