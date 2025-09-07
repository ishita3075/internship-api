package com.example.internship_api.controller;
import com.example.internship_api.model.Internship;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
@RestController
public class InternshipController {
    @GetMapping("/internships")
    public List<Internship> getInternships() {
        return Arrays.asList(
                new Internship(
                        "Java Developer Intern", "Google", "Bangalore", 6,
                        List.of("Java", "Spring Boot"),
                        "https://careers.google.com/jobs/results/123456",
                        "₹40,000/month"
                ),
                new Internship(
                        "Backend Intern", "Microsoft", "Hyderabad", 3,
                        List.of("Java", "SQL"),
                        "https://careers.microsoft.com/students/us/en/job/654321",
                        "₹35,000/month"
                ),
                new Internship(
                        "AI Research Intern", "IIT Delhi", "Delhi", 4,
                        List.of("Python", "AI", "ML"),
                        "https://internships.iitd.ac.in/ai-research",
                        "₹25,000/month"
                ),
                new Internship(
                        "Web Developer Intern", "Infosys", "Pune", 3,
                        List.of("HTML", "CSS", "JavaScript"),
                        "https://careers.infosys.com/web-intern",
                        "₹20,000/month"
                )
        );
    }
}
