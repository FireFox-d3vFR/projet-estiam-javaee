package com.estiam.englishjavaee.services;

import com.estiam.englishjavaee.dao.VilleDao;
import com.estiam.englishjavaee.pojos.Ville;

import java.util.List;

public class VilleService {
    private VilleDao villeDao = new VilleDao();

    public List<Ville> getAllVilles() {
        return villeDao.getAllVilles();
    }

    public Ville getVilleById(long id) {
        return villeDao.getVilleById(id);
    }
}
