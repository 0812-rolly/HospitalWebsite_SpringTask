package org.structure.repository;

import org.springframework.data.repository.CrudRepository;
import org.structure.models.MedicalCard;
import org.structure.models.MedicalCard;

import java.util.List;

public interface MedicalCardRepository extends CrudRepository <MedicalCard, Long> {
    MedicalCard getById(long id);

    List<MedicalCard> findAll();

    MedicalCard save(MedicalCard MedicalCard);

    void deleteById(long id);
}
