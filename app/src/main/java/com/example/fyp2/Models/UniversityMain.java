package com.example.fyp2.Models;

public class UniversityMain {
    String universityname,universityimage;
    float universityrating;
    UniversityMain(){}

    public UniversityMain(String universityname, String universityimage, float universityrating) {
        this.universityname = universityname;
        this.universityimage = universityimage;
        this.universityrating = universityrating;
    }

    public String getUniversityname() {
        return universityname;
    }

    public void setUniversityname(String universityname) {
        this.universityname = universityname;
    }

    public String getUniversityimage() {
        return universityimage;
    }

    public void setUniversityimage(String universityimage) {
        this.universityimage = universityimage;
    }

    public float getUniversityrating() {
        return universityrating;
    }

    public void setUniversityrating(float universityrating) {
        this.universityrating = universityrating;
    }
}
