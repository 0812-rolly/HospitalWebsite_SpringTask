package org.structure.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.structure.models.Doctor;
import org.structure.models.Login;
import org.structure.models.Patient;
import org.structure.services.PatientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("home-page")
    public ModelAndView homePage(){
        Patient patient = patientService.getPatientByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        ModelAndView modelAndView = new ModelAndView("patientHomePage");
        modelAndView.addObject("name", patient.getFullName());
        modelAndView.addObject("login", patient.getLogin());
        modelAndView.addObject("phone", patient.getPhoneNumber());
        modelAndView.addObject("email", patient.getEmail());
        return modelAndView;
    }

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

    private void addNewPatient(String name, String number, String email, String login, String password){
        Patient patient = new Patient();
        patient.setFullName(name);
        patient.setPhoneNumber(number);
        patient.setEmail(email);
        patient.setLogin(new Login(0, login, null, null));
        patient.setPassword(password);

        patientService.addPatient(patient);
    }

    @PostMapping("/patient-update")
    public ModelAndView updateRequest(HttpServletRequest request) {
        String type = request.getParameter("parameter");
        String newValue = request.getParameter("newValue");
        updatePatient(type, newValue);
        return new ModelAndView("updatePatient");
    }

    private void updatePatient(String parameter, String newValue){
        patientService.updatePatient(SecurityContextHolder.getContext().getAuthentication().getName(), parameter, newValue);
    }

    @PostMapping("/patient-delete")
    private String deletePatient(){
        patientService.deletePatientByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        return "redirect:/logout";
    }
}
