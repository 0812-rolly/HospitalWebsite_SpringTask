package org.structure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.structure.models.Patient;
import org.structure.services.PatientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService){ this.patientService = patientService;}

    @GetMapping("/add-patient")
    public ModelAndView addPatientPage() {
        ModelAndView modelAndView= new ModelAndView("addPatient");
        return modelAndView;
    }

    @GetMapping("/update-patient")
    public ModelAndView updatePatientPage() {
        ModelAndView modelAndView= new ModelAndView("updatePatient");
        return modelAndView;
    }

    @GetMapping("/delete-patient")
    public ModelAndView deletePatientPage() {
        ModelAndView modelAndView= new ModelAndView("deletePatient");
        return modelAndView;
    }

    @GetMapping("/get-patients")
    public ModelAndView getPatientsRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView modelAndView= new ModelAndView("getAllPatients");
        response.setContentType("text/html;charset=UTF-8");
        List<Patient> patients = patientService.getAllPatients();
        modelAndView.addObject("patients", patients);
        return modelAndView;
    }

    @PostMapping("/add-patient")
    public ModelAndView addRequest(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        addNewPatient(id, name, number, email, login, password);
        return new ModelAndView("addPatient");
    }

    @PostMapping("/update-patient")
    public ModelAndView updateRequest(HttpServletRequest request) {
        String id = request.getParameter("id");
        String type = request.getParameter("parameter");
        String newValue = request.getParameter("newValue");
        updatePatient(id, type, newValue);
        return new ModelAndView("updatePatient");
    }

    @PostMapping("/delete-patient")
    public ModelAndView deleteRequest(HttpServletRequest request) {
        String id = request.getParameter("id");
        deletePatient(id);
        return new ModelAndView("deletePatient");
    }

    private void addNewPatient(String id, String name, String number, String email, String login, String password){
        Patient patient = new Patient();
        patient.setId(Long.parseLong(id));
        patient.setFullName(name);
        patient.setPhoneNumber(number);
        patient.setEmail(email);
        patient.setLogin(login);
        patient.setPassword(password);

        patientService.addPatient(patient);
    }

    private void updatePatient(String id, String parameter, String newValue){
        Patient patient = patientService.getPatient(Long.parseLong(id));
        patientService.updatePatient(Long.parseLong(id), parameter, newValue);
    }

    private void deletePatient(String id){
        patientService.deletePatient(Long.parseLong(id));
    }
}
