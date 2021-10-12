package org.services.impl;

import org.dao.MedicalCardDAO;
import org.models.MedicalCard;
import org.services.MedicalCardService;

import java.util.List;

public class MedicalCardServiceImpl implements MedicalCardService {
    private MedicalCardDAO medicalCardDAO;

    @Override
    public MedicalCard getMedicalCard(long id) {
        return null;
    }

    @Override
    public List<MedicalCard> getAllMedicalCards() {
        return null;
    }

    @Override
    public void saveMedicalCard(MedicalCard medicalCard) {

    }

    @Override
    public void updateMedicalCard(MedicalCard medicalCard) {

    }

    @Override
    public void deleteMedicalCard(long id) {

    }
}
