package com.example.internship_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

public class Internship {
    private String title;
    private String company;
    private String location;
    private int duration;
    private List<String> skillsRequired;
    private String link;
    private String salary;
    @JsonIgnore
    private int score;
    public Internship(String title, String company, String location, int duration,
                      List<String> skillsRequired, String link, String salary) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.duration = duration;
        this.skillsRequired = skillsRequired;
        this.link = link;
        this.salary = salary;
    }
    public String getTitle() {
        return title;
    }
    public String getCompany() {
        return company;
    }
    public String getLocation() {
        return location;
    }
    public int getDuration() {
        return duration;
    }
    public List<String> getSkillsRequired() {
        return skillsRequired;
    }
    public String getLink() {
        return link;
    }
    public String getSalary() {
        return salary;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
}
