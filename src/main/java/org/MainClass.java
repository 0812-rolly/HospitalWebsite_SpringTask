package org;

import org.models.Patient;
import org.services.PatientService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PatientService patientService = (PatientService) context.getBean("patientService");

        Patient patient = new Patient();
        patient.setId(1L);
        patient.setFullName("Yana Belozub");
        patient.setPhoneNumber("890088888888");
        patient.setEmail("test@mail.ru");
        patient.setLogin("testLogin");
        patient.setPassword("testPassword123");

        patientService.addPatient(patient);

        System.out.println(patientService.getPatient(1L));
    }
}
