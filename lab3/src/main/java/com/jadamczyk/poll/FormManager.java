package com.jadamczyk.poll;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Named("FormManager")
@ApplicationScoped
public class FormManager {
    private String name;
    private String surname;
    private String email;
    private Integer age;
    private Gender selectedGender = Gender.NONE;
    private Education selectedEducation = Education.NONE;
    private Double height;

    private Spending spending;
    private Frequency frequency;
    private List<Colors> colors = new LinkedList<>();
    private List<FemaleClothesType> femaleTypes = new LinkedList<>();
    private List<MaleClothesType> maleTypes = new LinkedList<>();

    private Boolean showFemale = false;
    private Boolean showMale = false;
    private Boolean isSecondStage = false;

    private final List<Gender> allGenders = new ArrayList<>(Arrays.asList(Gender.values()));
    private final List<Education> allEducationLevels = new ArrayList<>(Arrays.asList(Education.values()));
    private final List<Colors> allColors = new ArrayList<>(Arrays.asList(Colors.values()));
    private final List<Spending> allSpendings = new ArrayList<>(Arrays.asList(Spending.values()));
    private final List<Frequency> allFrequiencies = new ArrayList<>(Arrays.asList(Frequency.values()));
    private final List<FemaleClothesType> allFemaleClothesTypes = new ArrayList<>(Arrays.asList((FemaleClothesType.values())));
    private final List<MaleClothesType> allMaleClothesTypes = new ArrayList<>(Arrays.asList((MaleClothesType.values())));

    public Boolean getSecondStage() {
        return isSecondStage;
    }

    public List<Gender> getAllGenders() {
        return allGenders;
    }

    public List<Education> getAllEducationLevels() {
        return allEducationLevels;
    }

    public Boolean getShowFemale() {
        return showFemale;
    }

    public Boolean getShowMale() {
        return showMale;
    }

    public Gender getSelectedGender() {
        return selectedGender;
    }

    public void setSelectedGender(Gender selectedGender) {
        if (selectedGender == Gender.MALE) {
            this.showMale = true;
            this.showFemale = false;
        } else if (selectedGender == Gender.FEMALE) {
            this.showMale = false;
            this.showFemale = true;
        }
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

    public Spending getSpending() {
        return spending;
    }

    public void setSpending(Spending spending) {
        this.spending = spending;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public List<Colors> getColors() {
        return colors;
    }

    public List<Colors> getAllColors() {
        return allColors;
    }

    public List<Spending> getAllSpendings() {
        return allSpendings;
    }

    public List<Frequency> getAllFrequiencies() {
        return allFrequiencies;
    }

    public List<FemaleClothesType> getAllFemaleClothesTypes() {
        return allFemaleClothesTypes;
    }

    public List<MaleClothesType> getAllMaleClothesTypes() {
        return allMaleClothesTypes;
    }

    public List<FemaleClothesType> getFemaleTypes() {
        return femaleTypes;
    }

    public void setFemaleTypes(List<FemaleClothesType> femaleTypes) {
        this.femaleTypes = femaleTypes;
    }

    public List<MaleClothesType> getMaleTypes() {
        return maleTypes;
    }

    public void setMaleTypes(List<MaleClothesType> maleTypes) {
        this.maleTypes = maleTypes;
    }
}
