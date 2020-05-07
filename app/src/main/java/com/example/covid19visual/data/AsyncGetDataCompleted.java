package com.example.covid19visual.data;

import com.example.covid19visual.model.BedPer10Thousand;
import com.example.covid19visual.model.currentStatusModel;

import java.util.ArrayList;

public interface AsyncGetDataCompleted {
    void onRecievedSuccess(ArrayList<BedPer10Thousand> qm);

}
