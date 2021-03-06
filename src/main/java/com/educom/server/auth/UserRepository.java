package com.educom.server.auth;

import com.educom.server.auth.jwt.model.EducomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<EducomUser,Long> {
    Optional<EducomUser> findByUserName(String userName);

    Optional<EducomUser> findByEmail(String s);
}
