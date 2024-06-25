package com.estiam.englishjavaee.services;

import com.estiam.englishjavaee.dao.VerbeDao;
import com.estiam.englishjavaee.pojos.Verbe;

import java.util.List;

public class VerbeService {
    private VerbeDao verbeDao = new VerbeDao();

    public List<Verbe> getAllVerbes() {
        return verbeDao.getAllVerbes();
    }

    public Verbe getVerbeById(long id) {
        return verbeDao.getVerbeById(id);
    }
}
