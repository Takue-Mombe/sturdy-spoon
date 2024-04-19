package com.hit200.nanatsu.Controllers;
import com.hit200.nanatsu.Services.ProgrammesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.hit200.nanatsu.Modelling.Programmes;
import java.util.List;

@Controller
@RequestMapping("/programmes")
public class ProgrammesController {

    @Autowired
    private ProgrammesService programmesService;

    // GET request to fetch all programmes
    @GetMapping
    public String getAllProgrammes(Model model) {
        List<Programmes> programmes = programmesService.getAllProgrammes();
        model.addAttribute("programmes", programmes);
        return "programmes"; // Thymeleaf template name to display programmes
    }

    // GET request to display the form for adding a new programme
    @GetMapping("/add")
    public String showAddProgrammeForm(Model model) {
        model.addAttribute("programme", new Programmes());
        return "programmes"; // Thymeleaf template name for the form
    }

    // POST request to add a new programme
    @PostMapping("/add")
    public String addProgramme(@ModelAttribute("programme") Programmes programme, BindingResult result) {
        if (result.hasErrors()) {
            return "programmes"; // Return to the form if there are validation errors
        }
        programmesService.createProgramme(programme);
        return "redirect:/programmes"; // Redirect to the list of programmes
    }

    // Other controller methods for CRUD operations on Programmes
}

