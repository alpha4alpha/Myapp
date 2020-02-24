package com.example.fyp2.Models;

public class Milestones {

    String milestonename,milestonedescription,milestonetime,milestonestatus;
    Milestones(){}

    public Milestones(String milestonename, String milestonedescription, String milestonetime,
                      String milestonestatus) {
        this.milestonename = milestonename;
        this.milestonedescription = milestonedescription;
        this.milestonetime = milestonetime;
        this.milestonestatus = milestonestatus;
    }

    public String getMilestonename() {
        return milestonename;
    }

    public void setMilestonename(String milestonename) {
        this.milestonename = milestonename;
    }

    public String getMilestonedescription() {
        return milestonedescription;
    }

    public void setMilestonedescription(String milestonedescription) {
        this.milestonedescription = milestonedescription;
    }

    public String getMilestonetime() {
        return milestonetime;
    }

    public void setMilestonetime(String milestonetime) {
        this.milestonetime = milestonetime;
    }

    public String getMilestonestatus() {
        return milestonestatus;
    }

    public void setMilestonestatus(String milestonestatus) {
        this.milestonestatus = milestonestatus;
    }
}
