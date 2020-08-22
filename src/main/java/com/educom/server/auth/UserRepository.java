package com.educom.server.auth;

import com.educom.server.entity.EducomUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<EducomUser,Long> {
    Optional<EducomUser> findByUserName(String userName);

    Optional<EducomUser> findByEmail(String s);
}
