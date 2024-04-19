package com.hit200.nanatsu.Controllers;

import com.hit200.nanatsu.Modelling.Courses;
import com.hit200.nanatsu.Modelling.Lecturer;
import com.hit200.nanatsu.Modelling.Programmes;
import com.hit200.nanatsu.Modelling.Semester;
import com.hit200.nanatsu.Services.CourseService;
import com.hit200.nanatsu.Services.LecturerService;
import com.hit200.nanatsu.Services.ProgrammesService;
import com.hit200.nanatsu.Services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;@Autowired
    private ProgrammesService programmesService;@Autowired
    private LecturerService lecturerService;@Autowired
    private SemesterService semesterService;

    // GET request to fetch all courses
    @GetMapping
    public String getAllCourses(Model model) {
        List<Courses> courses = courseService.getAllCourses();
        List<Programmes> programmes = programmesService.getAllProgrammes();
        List<Lecturer> lecturer = lecturerService.getAllLecturers();
        List<Semester> semesters = semesterService.getAllSemesters();
        model.addAttribute("courses", courses);
        model.addAttribute("programmes", programmes);
        model.addAttribute("lecturer", lecturer);
        model.addAttribute("semesters", semesters);
        return "courses"; // Thymeleaf template name to display courses
    }

    // GET request to display the form for adding a new course
    @GetMapping("/add")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Courses());
        return "courses/add"; // Thymeleaf template name for the add form
    }

    // POST request to add a new course
    @PostMapping("/add")
    public String addCourse(@ModelAttribute("course") Courses course, BindingResult result) {
        if (result.hasErrors()) {
            return "courses/add"; // Return to the form if there are validation errors
        }
        courseService.createCourse(course);
        return "redirect:/courses"; // Redirect to the list of courses
    }

    // GET request to display the form for editing a course
    @GetMapping("/edit/{courseId}")
    public String showEditCourseForm(@PathVariable("courseId") String courseId, Model model) {
        Courses course = courseService.getCourseById(courseId);
        model.addAttribute("course", course);
        return "courses/edit"; // Thymeleaf template name for the edit form
    }

    // POST request to update a course
    @PostMapping("/edit")
    public String updateCourse(@ModelAttribute("course") Courses course, BindingResult result) {
        if (result.hasErrors()) {
            return "courses/edit"; // Return to the form if there are validation errors
        }
        courseService.updateCourse(course);
        return "redirect:/courses"; // Redirect to the list of courses
    }

    // POST request to delete a course
    @PostMapping("/delete/{courseId}")
    public String deleteCourse(@PathVariable("courseId") String courseId) {
        courseService.deleteCourse(courseId);
        return "redirect:/courses"; // Redirect to the list of courses
    }

    // Other controller methods for CRUD operations on Courses
}

