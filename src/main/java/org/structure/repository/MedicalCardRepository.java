package org.structure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.structure.models.MedicalCard;
import org.structure.models.MedicalCard;

import java.util.List;

@Repository
public interface MedicalCardRepository extends JpaRepository<MedicalCard, Long> {
    MedicalCard getById(long id);

    List<MedicalCard> findAll();

    MedicalCard save(MedicalCard MedicalCard);

    void deleteById(long id);
}
