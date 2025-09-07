package com.example.internship_api.model;
import java.util.List;
public class Candidate {
    private String name;
    private String education;
    private List<String> skills;
    private List<String> sectorInterests;
    private String locationPreference;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    public List<String> getSkills() {
        return skills;
    }
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
    public List<String> getSectorInterests() {
        return sectorInterests;
    }
    public void setSectorInterests(List<String> sectorInterests) {
        this.sectorInterests = sectorInterests;
    }
    public String getLocationPreference() {
        return locationPreference;
    }
    public void setLocationPreference(String locationPreference) {
        this.locationPreference = locationPreference;
    }
}
