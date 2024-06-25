package com.estiam.englishjavaee.services;

import com.estiam.englishjavaee.dao.PartieDao;
import com.estiam.englishjavaee.pojos.Partie;

public class PartieService {
    private PartieDao partieDao = new PartieDao();

    public void createPartie(Partie partie){
        partieDao.savePartie(partie);
    }

    // Other CRUD Methods
}
