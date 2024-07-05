package com.example.reto.data;

public class Courses {
    private String modality;
    private String course;
    private int hours;

    public Courses(String modality, String course, int hours) {
        this.modality = modality;
        this.course = course;
        this.hours = hours;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
