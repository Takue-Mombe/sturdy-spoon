package com.hit200.nanatsu.Controllers;

import com.hit200.nanatsu.Modelling.Programmes;
import com.hit200.nanatsu.Modelling.Students;
import com.hit200.nanatsu.Services.ProgrammesService;
import com.hit200.nanatsu.Services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;
    @Autowired private ProgrammesService programmesService;

    // GET request to fetch all students
    @GetMapping
    public String getAllStudents(Model model) {
        List<Students> students = studentsService.getAllStudents();
        List<Programmes> programmes = programmesService.getAllProgrammes();
        model.addAttribute("students", students);
        model.addAttribute("programmes",programmes);
        return "students"; // Thymeleaf template name to display students
    }

    // GET request to display the form for adding a new student
    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Students());
        return "students"; // Thymeleaf template name for the form
    }

    // POST request to add a new student
    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") Students student) {
        studentsService.createStudent(student);
        return "redirect:/students"; // Redirect to the list of students
    }

    // GET request to display the edit form for a student
    @GetMapping("/edit/{regNumber}")
    public String showEditStudentForm(@PathVariable("regNumber") String regNumber, Model model) {
        Students student = studentsService.getStudentById(regNumber);
        model.addAttribute("student", student);
        return "students"; // Thymeleaf template name for the edit form
    }

    // POST request to update a student
    @PostMapping("/edit")
    public String updateStudent(@ModelAttribute("student") Students student) {
        studentsService.updateStudent(student);
        return "redirect:/students"; // Redirect to the list of students
    }

    // GET request to delete a student
    @GetMapping("/delete/{regNumber}")
    public String deleteStudent(@PathVariable("regNumber") String regNumber) {
        studentsService.deleteStudent(regNumber);
        return "redirect:/students"; // Redirect to the list of students
    }
}
