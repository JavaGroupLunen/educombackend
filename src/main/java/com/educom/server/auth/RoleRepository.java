package com.educom.server.auth;

import com.educom.server.entity.ERole;
import com.educom.server.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole role);

}
