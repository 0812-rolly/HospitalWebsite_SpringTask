package org.services;

import org.models.MedicalCard;

import java.util.List;

public interface MedicalCardService {
    MedicalCard getMedicalCard(long id);

    List<MedicalCard> getAllMedicalCards();

    void saveMedicalCard(MedicalCard medicalCard);

    void updateMedicalCard(MedicalCard medicalCard);

    void deleteMedicalCard(long id);
}
