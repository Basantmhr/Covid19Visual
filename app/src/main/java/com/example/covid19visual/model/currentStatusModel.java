package com.example.covid19visual.model;

public class currentStatusModel {
    String patientStatus;
    int patientCount;
    @Override
    public String toString() {
        return "currentStatusModel{" +
                "patientStatus='" + patientStatus + '\'' +
                ", patientCount=" + patientCount +
                '}';
    }
   public  currentStatusModel()
    {

    }

    public currentStatusModel(String patientStatus, int patientCount) {
        this.patientStatus = patientStatus;
        this.patientCount = patientCount;
    }

    public String getpatientStatus() {
        return patientStatus;
    }

    public void setpatientStatus(String patientStatus) {
        this.patientStatus = patientStatus;
    }

    public int getpatientCount() {
        return patientCount;
    }

    public void setpatientCount(int patientCount) {
        this.patientCount = patientCount;
    }


}
