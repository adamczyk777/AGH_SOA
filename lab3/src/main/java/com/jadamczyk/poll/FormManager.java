package com.jadamczyk.poll;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Named("FormManager")
@ApplicationScoped
public class FormManager {
    private String name;
    private String surname;
    private String email;
    private Integer age;
    private Boolean showFemale = false;
    private Boolean showMale = false;
    private Gender selectedGender = Gender.NONE;
    private Education selectedEducation = Education.NONE;
    private Double height;
    private final List<Gender> allGenders = new ArrayList<>(Arrays.asList(Gender.values()));
    private final List<Education> allEducationLevels = new ArrayList<>(Arrays.asList(Education.values()));

    public List<Gender> getAllGenders() {
        return allGenders;
    }

    public List<Education> getAllEducationLevels() {
        return allEducationLevels;
    }

    public Boolean getShowFemale() {
        return showFemale;
    }

    public void setShowFemale(Boolean showFemale) {
        this.showFemale = showFemale;
    }

    public Boolean getShowMale() {
        return showMale;
    }

    public void setShowMale(Boolean showMale) {
        this.showMale = showMale;
    }

    public Gender getSelectedGender() {
        return selectedGender;
    }

    public void setSelectedGender(Gender selectedGender) {
        this.selectedGender = selectedGender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Education getSelectedEducation() {
        return selectedEducation;
    }

    public void setSelectedEducation(Education selectedEducation) {
        this.selectedEducation = selectedEducation;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
