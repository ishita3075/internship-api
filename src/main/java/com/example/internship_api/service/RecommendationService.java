package com.example.internship_api.service;

import com.example.internship_api.model.Candidate;
import com.example.internship_api.model.Internship;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecommendationService {
    private static final List<Internship> internships = new ArrayList<>();

    static {
        internships.add(new Internship(
                "Backend Intern", "Google", "Bangalore", 6,
                List.of("Java","My SQL","Spring Boot"),
                "https://careers.google.com/jobs/results/123456",
                "₹10,000/month"
        ));
        internships.add(new Internship(
                "Frontend Developer Intern", "Google", "Bangalore", 6,
                List.of("HTML","CSS","React","Spring Boot"),
                "https://careers.google.com/jobs/results/123456",
                "₹10,000/month"
        ));
        internships.add(new Internship(
                "Java Developer Intern", "Google", "Bangalore", 6,
                List.of("Java", "Spring Boot"),
                "https://careers.google.com/jobs/results/123456",
                "₹20,000/month"
        ));
        internships.add(new Internship(
                "Java Developer Intern", "Microsoft", "Hyderabad", 6,
                List.of("Java", "Spring Boot"),
                "https://careers.microsoft.com/students/us/en/job/654321",
                "₹25,000/month"
        ));
        internships.add(new Internship(
                "Backend Intern", "Microsoft", "Hyderabad", 3,
                List.of("Java", "SQL"),
                "https://careers.microsoft.com/students/us/en/job/654321",
                "₹35,000/month"
        ));
        internships.add(new Internship(
                "AI Research Intern", "IIT Delhi", "Delhi", 4,
                List.of("Python", "AI", "ML"),
                "https://internships.iitd.ac.in/ai-research",
                "₹25,000/month"
        ));
        internships.add(new Internship(
                "Web Developer Intern", "Infosys", "Mumbai", 3,
                List.of("HTML", "CSS", "JavaScript"),
                "https://careers.infosys.com/web-intern",
                "₹20,000/month"
        ));
        internships.add(new Internship(
                "Marketing Intern", "Unilever", "Mumbai", 3,
                List.of("Communication", "Digital Marketing", "Creativity"),
                "https://careers.unilever.com/marketing-intern",
                "₹18,000/month"
        ));
        internships.add(new Internship(
                "HR Intern", "Deloitte", "Bangalore", 2,
                List.of("Communication", "Recruitment", "Excel"),
                "https://careers.deloitte.com/hr-intern",
                "₹22,000/month"
        ));
        internships.add(new Internship(
                "Finance Intern", "KPMG", "Delhi", 4,
                List.of("Accounting", "Excel", "Financial Analysis"),
                "https://careers.kpmg.com/finance-intern",
                "₹30,000/month"
        ));
        internships.add(new Internship(
                "Content Writing Intern", "Times of India", "Work from home", 2,
                List.of("Writing", "Creativity", "SEO"),
                "https://internships.toi.com/content-writing",
                "₹12,000/month"
        ));
        internships.add(new Internship(
                "Agriculture Research Intern", "ICAR", "Lucknow", 6,
                List.of("Agronomy", "Soil Science", "Data Analysis"),
                "https://icar.org.in/agriculture-internship",
                "₹15,000/month"
        ));
        internships.add(new Internship(
                "Farm Management Intern", "AgroTech Pvt Ltd", "Punjab", 4,
                List.of("Crop Management", "Irrigation", "Farm Operations"),
                "https://agrotech.com/farm-management-internship",
                "₹18,000/month"
        ));
        internships.add(new Internship(
                "Sustainable Farming Intern", "Tata Agrico", "Nagpur", 3,
                List.of("Organic Farming", "Sustainability", "Soil Testing"),
                "https://tataagrico.com/sustainable-farming-internship",
                "₹16,000/month"
        ));
        internships.add(new Internship(
                "Agri-Business Intern", "ITC Limited", "Hyderabad", 5,
                List.of("Agribusiness", "Marketing", "Supply Chain"),
                "https://itcportal.com/agri-business-internship",
                "₹20,000/month"
        ));
        internships.add(new Internship(
                "Precision Agriculture Intern", "Mahindra Agribusiness", "Pune", 4,
                List.of("GIS", "IoT", "Data Analysis"),
                "https://mahindraagribusiness.com/precision-internship",
                "₹22,000/month"
        ));
        internships.add(new Internship(
                "Dairy Technology Intern", "Amul", "Anand", 5,
                List.of("Dairy Processing", "Quality Control", "Supply Chain"),
                "https://amul.com/dairy-tech-internship",
                "₹25,000/month"
        ));
        internships.add(new Internship(
                "Horticulture Intern", "Patanjali Organic", "Uttar Pradesh", 3,
                List.of("Plant Cultivation", "Greenhouse Management", "Organic Practices"),
                "https://patanjaliayurved.org/horticulture-internship",
                "₹14,000/month"
        ));
        internships.add(new Internship(
                "Agricultural Economics Intern", "NABARD", "Mumbai", 6,
                List.of("Economics", "Policy Research", "Statistics"),
                "https://nabard.org/agri-economics-internship",
                "₹28,000/month"
        ));
        internships.add(new Internship(
                "Food Processing Intern", "Britannia Industries", "Kolkata", 4,
                List.of("Food Technology", "Packaging", "Quality Assurance"),
                "https://britannia.co.in/food-processing-internship",
                "₹24,000/month"
        ));
    }

    public List<Internship> recommendInternships(Candidate candidate) {
        return internships.stream()
                .map(internship -> {
                    int score = 0;

                    if (candidate.getSkills() != null) {
                        for (String skill : candidate.getSkills()) {
                            if (internship.getSkillsRequired().contains(skill)) {
                                score += 2;
                            }
                        }
                    }

                    if (candidate.getLocationPreference() != null &&
                            candidate.getLocationPreference().equalsIgnoreCase(internship.getLocation())) {
                        score += 1;
                    }

                    if (candidate.getSectorInterests() != null) {
                        for (String interest : candidate.getSectorInterests()) {
                            if (internship.getTitle().toLowerCase().contains(interest.toLowerCase()) ||
                                    internship.getCompany().toLowerCase().contains(interest.toLowerCase())) {
                                score += 1;
                            }
                        }
                    }
                    internship.setScore(score);
                    return internship;
                })
                .sorted(Comparator.comparingInt(Internship::getScore).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }
}
