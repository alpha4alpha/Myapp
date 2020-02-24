package com.example.fyp2.Models;

public class Collaboration {

    String projectname,universityname;
    Collaboration(){}

    public Collaboration(String projectname, String universityname) {
        this.projectname = projectname;
        this.universityname = universityname;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getUniversityname() {
        return universityname;
    }

    public void setUniversityname(String universityname) {
        this.universityname = universityname;
    }
}
