package org.structure.controllers;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.matcher.StringMatcher;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.structure.models.Login;
import org.structure.models.Doctor;
import org.structure.models.Speciality;
import org.structure.services.DoctorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("home-page")
    public ModelAndView homePage(){
        Doctor doctor = doctorService.getDoctor(SecurityContextHolder.getContext().getAuthentication().getName());
        ModelAndView modelAndView = new ModelAndView("doctorHomePage");
        modelAndView.addObject("name", doctor.getFullName());
        modelAndView.addObject("login", doctor.getLogin());
        modelAndView.addObject("phone", doctor.getPhoneNumber());
        modelAndView.addObject("email", doctor.getEmail());
        modelAndView.addObject("speciality", doctor.getSpeciality());
        return modelAndView;
    }

    @GetMapping("/doctor-add")
    public ModelAndView addDoctorPage() {
        ModelAndView modelAndView= new ModelAndView("addDoctor");
        modelAndView.addObject("speciality", Speciality.values());
        return modelAndView;
    }

    @GetMapping("/doctor-update")
    public ModelAndView updateDoctorPage() {
        ModelAndView modelAndView= new ModelAndView("updateDoctor");
        return modelAndView;
    }

    @GetMapping("/doctor-delete")
    public ModelAndView deleteDoctorPage() {
        ModelAndView modelAndView= new ModelAndView("deleteDoctor");
        return modelAndView;
    }

    @GetMapping("/doctors-get")
    public ModelAndView getDoctorsRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView modelAndView= new ModelAndView("getAllDoctors");
        response.setContentType("text/html;charset=UTF-8");
        List<Doctor> doctors = doctorService.getAllDoctors();
        modelAndView.addObject("doctors", doctors);
        return modelAndView;
    }

    @PostMapping("/doctor-add")
    public ModelAndView addRequest(HttpServletRequest request) {
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String speciality = request.getParameter("speciality");
        addNewDoctor(name, number, email, login, password, speciality);
        return new ModelAndView("addDoctor");
    }

    @PostMapping("/doctor-update")
    public ModelAndView updateRequest(HttpServletRequest request) {
        String id = request.getParameter("id");
        String type = request.getParameter("parameter");
        String newValue = request.getParameter("newValue");
        updateDoctor(id, type, newValue);
        return new ModelAndView("updateDoctor");
    }

    @PostMapping("/doctor-delete")
    private String deleteDoctor(){
        doctorService.deleteDoctorByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        return "redirect:/logout";
    }

    private void addNewDoctor(String name, String number, String email, String login, String password, String speciality){
        Doctor doctor = new Doctor();
        doctor.setFullName(name);
        doctor.setPhoneNumber(number);
        doctor.setEmail(email);
        doctor.setLogin(new Login(0, login, null, null));
        doctor.setPassword(password);
        doctor.setSpeciality(Speciality.valueOf(speciality));

        doctorService.addDoctor(doctor);
    }

    private void updateDoctor(String id, String parameter, String newValue){
        doctorService.updateDoctor(SecurityContextHolder.getContext().getAuthentication().getName(), parameter, newValue);
    }


}
