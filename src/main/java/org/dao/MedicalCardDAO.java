package org.dao;

import org.models.MedicalCard;

import java.util.List;

public interface MedicalCardDAO {
    MedicalCard get(long id);

    List<MedicalCard> getAll();

    void save(MedicalCard medicalCard);

    void update(MedicalCard medicalCard);

    void delete(long id);
}
