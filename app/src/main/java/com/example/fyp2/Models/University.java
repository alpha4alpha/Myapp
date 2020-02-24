package com.example.fyp2.Models;

public class University {
    String universityname, universityvision, universityaddress, universitycontact,
            universityurl, universityexpertise, universityreviews,universityimage;
    float universityrating;

    University() {
    }

    public String getUniversityimage() {
        return universityimage;
    }

    public void setUniversityimage(String universityimage) {
        this.universityimage = universityimage;
    }

    public String getUniversityname() {
        return universityname;
    }

    public void setUniversityname(String universityname) {
        this.universityname = universityname;
    }

    public String getUniversityvision() {
        return universityvision;
    }

    public void setUniversityvision(String universityvision) {
        this.universityvision = universityvision;
    }

    public String getUniversityaddress() {
        return universityaddress;
    }

    public void setUniversityaddress(String universityaddress) {
        this.universityaddress = universityaddress;
    }

    public String getUniversitycontact() {
        return universitycontact;
    }

    public void setUniversitycontact(String universitycontact) {
        this.universitycontact = universitycontact;
    }

    public String getUniversityurl() {
        return universityurl;
    }

    public void setUniversityurl(String universityurl) {
        this.universityurl = universityurl;
    }

    public String getUniversityexpertise() {
        return universityexpertise;
    }

    public void setUniversityexpertise(String universityexpertise) {
        this.universityexpertise = universityexpertise;
    }

    public float getUniversityrating() {
        return universityrating;
    }

    public void setUniversityrating(float universityrating) {
        this.universityrating = universityrating;
    }

    public String getUniversityreviews() {
        return universityreviews;
    }

    public void setUniversityreviews(String universityreviews) {
        this.universityreviews = universityreviews;
    }

    public University(String universityname, String universityvision, String universityaddress,
                      String universitycontact, String universityurl, String universityexpertise,
                      float universityrating, String universityreviews,String universityimage) {
        this.universityname = universityname;
this.universityimage = universityimage;
        this.universityvision = universityvision;
        this.universityaddress = universityaddress;
        this.universitycontact = universitycontact;
        this.universityurl = universityurl;
        this.universityexpertise = universityexpertise;
        this.universityrating = universityrating;
        this.universityreviews = universityreviews;
    }
}
