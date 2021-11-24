package org.structure.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Table(name = "logins")
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String login;

    @OneToOne(mappedBy = "login")
    private Patient patient;

    @OneToOne(mappedBy = "login")
    private Doctor doctor;

    @Override
    public String toString() {
        return login;
    }
}