package org.structure.models;

import javax.persistence.*;

@Entity
@Table(name="appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "registration_id", referencedColumnName = "id")
    private Registration registration;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Status status;

    @JoinColumn(name="patient_card_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private MedicalCard medCard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
