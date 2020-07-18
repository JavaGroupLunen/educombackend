package com.educom.server.dao;

import com.educom.server.entity.Lehre;

import java.util.List;

public interface LehreDao {
    public List<Lehre> getAllLehreList();
    public String saveLehreDetails(Lehre lehre);
    Lehre getLehre(Long id);
    public void deleteLehre(Long id);

}
