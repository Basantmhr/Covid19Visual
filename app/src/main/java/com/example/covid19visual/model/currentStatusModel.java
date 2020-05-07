package com.example.covid19visual.model;

public class currentStatusModel {
    @Override
    public String toString() {
        return "currentStatusModel{" +
                "mStatus='" + mStatus + '\'' +
                ", mcount=" + mcount +
                '}';
    }
   public  currentStatusModel()
    {

    }

    public currentStatusModel(String mStatus, int mcount) {
        this.mStatus = mStatus;
        this.mcount = mcount;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public int getMcount() {
        return mcount;
    }

    public void setMcount(int mcount) {
        this.mcount = mcount;
    }

    String mStatus;
    int mcount;
}
