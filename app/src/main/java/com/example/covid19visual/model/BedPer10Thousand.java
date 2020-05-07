package com.example.covid19visual.model;

public class BedPer10Thousand {
    private String state;
    private Double bedPer10K;

    public BedPer10Thousand(String state, Double bedPer10K) {
        this.state = state;
        this.bedPer10K = bedPer10K;
    }

    public BedPer10Thousand()
    {

    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getBedPer10K() {
        return bedPer10K;
    }

    public void setBedPer10K(double bedPer10K) {
        this.bedPer10K = bedPer10K;
    }

    @Override
    public String toString() {
        return "BedPer10Thousand{" +
                "state='" + state + '\'' +
                ", bedPer10K=" + bedPer10K +
                '}';
    }
}
