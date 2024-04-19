package com.hit200.nanatsu.Controllers;

import com.hit200.nanatsu.Modelling.Courses;
import com.hit200.nanatsu.Modelling.Lecturer;
import com.hit200.nanatsu.Services.CourseService;
import com.hit200.nanatsu.Services.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lecturers")
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;
    @Autowired
    private CourseService courseService;

    // GET request to fetch all lecturers
    @GetMapping
    public String getAllLecturers(Model model) {
        List<Lecturer> lecturers = lecturerService.getAllLecturers();
        List<Courses> courses = courseService.getAllCourses();
        model.addAttribute("lecturers", lecturers);
        model.addAttribute("courses", courses);
        return "lecturers"; // Thymeleaf template name to display lecturers
    }

    // GET request to display the form for adding a new lecturer
    @GetMapping("/add")
    public String showAddLecturerForm(Model model) {
        model.addAttribute("lecturer", new Lecturer());
        return "lecturers"; // Thymeleaf template name for the add form
    }

    // POST request to add a new lecturer
    @PostMapping("/add")
    public String addLecturer(@ModelAttribute("lecturer") Lecturer lecturer, BindingResult result) {
        if (result.hasErrors()) {
            return "lecturers"; // Return to the form if there are validation errors
        }
        lecturerService.createLecturer(lecturer);
        return "redirect:/lecturers"; // Redirect to the list of lecturers
    }

    // GET request to display the form for editing a lecturer
    @GetMapping("/edit/{lecturerId}")
    public String showEditLecturerForm(@PathVariable("lecturerId") String lecturerId, Model model) {
        Lecturer lecturer = lecturerService.getLecturerById(lecturerId);
        model.addAttribute("lecturer", lecturer);
        return "lecturers"; // Thymeleaf template name for the edit form
    }

    // POST request to update a lecturer
    @PostMapping("/edit")
    public String updateLecturer(@ModelAttribute("lecturer") Lecturer lecturer, BindingResult result) {
        if (result.hasErrors()) {
            return "lecturers"; // Return to the form if there are validation errors
        }
        lecturerService.updateLecturer(lecturer);
        return "redirect:/lecturers"; // Redirect to the list of lecturers
    }

    // POST request to delete a lecturer
    @PostMapping("/delete/{lecturerId}")
    public String deleteLecturer(@PathVariable("lecturerId") String lecturerId) {
        lecturerService.deleteLecturer(lecturerId);
        return "redirect:/lecturers"; // Redirect to the list of lecturers
    }

    // Other controller methods for CRUD operations on Lecturers
}
