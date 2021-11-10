package org.structure.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.structure.repository.MedicalCardRepository;
import org.structure.models.MedicalCard;
import org.structure.services.MedicalCardService;

import java.util.List;

public class MedicalCardServiceImpl implements MedicalCardService {
    @Autowired
    private MedicalCardRepository medicalCardDAO;

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
