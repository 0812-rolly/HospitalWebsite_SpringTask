package org.structure.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String fullName;
    private String phoneNumber;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id", referencedColumnName = "id")
    private Login login;
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Speciality speciality;

    @Override
    public String toString() {
        return "Doctor{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", speciality=" + speciality +
                '}';
    }
}
