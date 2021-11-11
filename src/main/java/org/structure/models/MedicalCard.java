package org.structure.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medCard")
public class MedicalCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medCard")
    private List<Appointment> appointments;

    public Long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
