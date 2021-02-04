package com.educom.server.services;

import com.educom.server.auth.jwt.model.SignupRequest;

import java.util.List;
import java.util.Optional;

public interface EducomUserService<T> {
    List<T> getAll();
    String save(SignupRequest t);
    T getById(Long id);
    String delete(Long id);
    Optional<T> findByUserName(String username);
    String update(Long id,T t);

}
