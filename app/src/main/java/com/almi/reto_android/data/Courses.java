package com.almi.reto_android.data;

import java.io.Serializable;

public class Courses implements Serializable {
    private String modality, courseName;
    private int hours;

    public Courses(String modality, String courseName, int hours) {
        this.modality = modality;
        this.courseName = courseName;
        this.hours = hours;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
