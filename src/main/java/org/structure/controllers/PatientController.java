package org.structure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.structure.models.Patient;
import org.structure.services.PatientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService){ this.patientService = patientService;}

    @GetMapping("/patient-add")
    public ModelAndView addPatientPage() {
        ModelAndView modelAndView= new ModelAndView("addPatient");
        return modelAndView;
    }

    @GetMapping("/patient-update")
    public ModelAndView updatePatientPage() {
        ModelAndView modelAndView= new ModelAndView("updatePatient");
        return modelAndView;
    }

    @GetMapping("/patient-delete")
    public ModelAndView deletePatientPage() {
        ModelAndView modelAndView= new ModelAndView("deletePatient");
        return modelAndView;
    }

    @GetMapping("/patients-get")
    public ModelAndView getPatientsRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView modelAndView= new ModelAndView("getAllPatients");
        response.setContentType("text/html;charset=UTF-8");
        List<Patient> patients = patientService.getAllPatients();
        modelAndView.addObject("patients", patients);
        return modelAndView;
    }

    @PostMapping("/patient-add")
    public ModelAndView addRequest(HttpServletRequest request) {
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        addNewPatient(name, number, email, login, password);
        return new ModelAndView("addPatient");
    }

    @PostMapping("/patient-update")
    public ModelAndView updateRequest(HttpServletRequest request) {
        String id = request.getParameter("id");
        String type = request.getParameter("parameter");
        String newValue = request.getParameter("newValue");
        updatePatient(id, type, newValue);
        return new ModelAndView("updatePatient");
    }

    @PostMapping("/patient-delete")
    public ModelAndView deleteRequest(HttpServletRequest request) {
        String id = request.getParameter("id");
        deletePatient(id);
        return new ModelAndView("deletePatient");
    }

    private void addNewPatient(String name, String number, String email, String login, String password){
        Patient patient = new Patient();
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
