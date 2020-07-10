package com.educom.server.services;

import com.educom.server.entity.Lehre;

import java.util.List;

public interface LehreService {
    public List<Lehre> getAllLehreList();
    public String saveLehreDetails(Lehre lehre);

}
