package com.hit200.nanatsu.Controllers;

import com.hit200.nanatsu.Modelling.Semester;
import com.hit200.nanatsu.Services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/semesters")
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

    // GET request to fetch all semesters
    @GetMapping
    public String getAllSemesters(Model model) {
        List<Semester> semesters = semesterService.getAllSemesters();
        model.addAttribute("semesters", semesters);
        return "semesters"; // Thymeleaf template name to display semesters
    }

    // GET request to display the form for adding a new semester
    @GetMapping("/add")
    public String showAddSemesterForm(Model model) {
        model.addAttribute("semester", new Semester());
        return "semesters"; // Thymeleaf template name for the add form
    }

    // POST request to add a new semester
    @PostMapping("/add")
    public String addSemester(@ModelAttribute("semester") Semester semester, BindingResult result) {
        if (result.hasErrors()) {
            return "semesters"; // Return to the form if there are validation errors
        }
        semesterService.createSemester(semester);
        return "redirect:/semesters"; // Redirect to the list of semesters
    }

    // GET request to display the form for editing a semester
    @GetMapping("/edit/{semesterId}")
    public String showEditSemesterForm(@PathVariable("semesterId") Long semesterId, Model model) {
        Semester semester = semesterService.getSemesterById(semesterId);
        model.addAttribute("semester", semester);
        return "semesters"; // Thymeleaf template name for the edit form
    }

    // POST request to update a semester
    @PostMapping("/edit")
    public String updateSemester(@ModelAttribute("semester") Semester semester, BindingResult result) {
        if (result.hasErrors()) {
            return "semesters"; // Return to the form if there are validation errors
        }
        semesterService.updateSemester(semester);
        return "redirect:/semesters"; // Redirect to the list of semesters
    }

    // POST request to delete a semester
    @PostMapping("/delete/{semesterId}")
    public String deleteSemester(@PathVariable("semesterId") Long semesterId) {
        semesterService.deleteSemester(semesterId);
        return "redirect:/semesters"; // Redirect to the list of semesters
    }

    // Other controller methods for CRUD operations on Semesters
}
