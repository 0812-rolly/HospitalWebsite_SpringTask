package org.structure.services;

import org.structure.models.MedicalCard;

import java.util.List;

public interface MedicalCardService {
    MedicalCard getMedicalCard(long id);

    List<MedicalCard> getAllMedicalCards();

    void saveMedicalCard(MedicalCard medicalCard);

    void updateMedicalCard(MedicalCard medicalCard);

    void deleteMedicalCard(long id);
}
