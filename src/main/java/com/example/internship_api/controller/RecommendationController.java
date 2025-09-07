package com.example.internship_api.controller;
import com.example.internship_api.model.Candidate;
import com.example.internship_api.model.Internship;
import com.example.internship_api.service.RecommendationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class RecommendationController {
    private final RecommendationService recommendationService;
    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }
    @PostMapping("/recommendations")
    public List<Internship> getRecommendations(@RequestBody Candidate candidate) {
        return recommendationService.recommendInternships(candidate);
    }
}
