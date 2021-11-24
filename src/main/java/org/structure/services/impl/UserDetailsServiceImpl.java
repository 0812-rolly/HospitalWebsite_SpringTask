package org.structure.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.structure.models.Doctor;
import org.structure.models.Role;
import org.structure.repository.PatientRepository;
import org.structure.models.Patient;
import org.structure.repository.DoctorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PatientRepository patientRepository;

    private final DoctorRepository doctorRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Patient patient = patientRepository.findPatientByLoginLogin(login).orElse(null);
        if (patient != null) {
            return new org.springframework.security.core.userdetails.User(
                    patient.getLogin().getLogin(),
                    patient.getPassword(),
                    List.of(Role.PATIENT)
            );
        }
        else {
            Doctor doctor = doctorRepository.findDoctorByLoginLogin(login).orElseThrow(() -> new UsernameNotFoundException(login));
            return new org.springframework.security.core.userdetails.User(
                    doctor.getLogin().getLogin(),
                    doctor.getPassword(),
                    List.of(Role.DOCTOR)
            );
        }
    }
}