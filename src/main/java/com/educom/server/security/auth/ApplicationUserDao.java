package com.educom.server.security.auth;

import java.util.Optional;
public interface ApplicationUserDao {
    Optional<ApplicationUser> selectApplicationUserByUsername(String username);

}
