package com.example.covid19visual.data;

import com.example.covid19visual.model.CurrentStatusModel;

import java.util.ArrayList;

public interface AsyncnewTask {
    void onRecievedSuccesscurrent(ArrayList<CurrentStatusModel> currentStatusModels);
}
