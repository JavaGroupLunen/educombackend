package com.educom.server.services;

import com.educom.server.entity.Lehre;

import java.util.List;

public interface LehreService {
    public List<Lehre> getAllLehreList();
    public String saveLehreDetails(Lehre lehre);
    public Lehre getLehre(Long id);
    public void deleteLehre(Long id);
}
