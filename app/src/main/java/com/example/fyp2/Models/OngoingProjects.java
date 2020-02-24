package com.example.fyp2.Models;

public class OngoingProjects {

    String projectname,projectdescription,projectrequirements,projectbudget,projectcompletiondate
            ,projectuniversity,projectstatus;

    OngoingProjects(){}

    public OngoingProjects(String projectname, String projectdescription, String projectrequirements,
                             String projectbudget, String projectcompletiondate, String projectuniversity, String projectstatus) {
        this.projectname = projectname;
        this.projectdescription = projectdescription;
        this.projectrequirements = projectrequirements;
        this.projectbudget = projectbudget;
        this.projectcompletiondate = projectcompletiondate;
        this.projectuniversity = projectuniversity;
        this.projectstatus = projectstatus;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getProjectdescription() {
        return projectdescription;
    }

    public void setProjectdescription(String projectdescription) {
        this.projectdescription = projectdescription;
    }

    public String getProjectrequirements() {
        return projectrequirements;
    }

    public void setProjectrequirements(String projectrequirements) {
        this.projectrequirements = projectrequirements;
    }

    public String getProjectbudget() {
        return projectbudget;
    }

    public void setProjectbudget(String projectbudget) {
        this.projectbudget = projectbudget;
    }

    public String getProjectcompletiondate() {
        return projectcompletiondate;
    }

    public void setProjectcompletiondate(String projectcompletiondate) {
        this.projectcompletiondate = projectcompletiondate;
    }

    public String getProjectuniversity() {
        return projectuniversity;
    }

    public void setProjectuniversity(String projectuniversity) {
        this.projectuniversity = projectuniversity;
    }

    public String getProjectstatus() {
        return projectstatus;
    }

    public void setProjectstatus(String projectstatus) {
        this.projectstatus = projectstatus;
    }
}
