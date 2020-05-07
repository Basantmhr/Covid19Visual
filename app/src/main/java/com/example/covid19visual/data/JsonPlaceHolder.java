package com.example.covid19visual.data;

import android.app.DownloadManager;
import android.util.Log;

import androidx.annotation.LongDef;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid19visual.controller.AppController;
import com.example.covid19visual.model.BedPer10Thousand;
import com.example.covid19visual.model.currentStatusModel;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class JsonPlaceHolder {
    private String url;
    private ArrayList <BedPer10Thousand> bedModelArrayList=new ArrayList<>();
    public List getBedData(final AsyncGetDataCompleted mcallback)
    {   url="https://raw.githubusercontent.com/Basantmhr/Hosting_Data_Repo/master/JSONFile/db.JSON";
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, (JSONArray) null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("data", "onResponse: "+response);

                    try {
                        for(int i=0;i<response.length();i++) {
                            BedPer10Thousand mBedModel = new BedPer10Thousand();
                            mBedModel.setState(response.getJSONArray(i).getString(0));
                            mBedModel.setBedPer10K(response.getJSONArray(i).getDouble(1));
                           // Log.d("dd", "onResponse: "+response.getJSONArray(i).getString(0)+i);
                           // Log.d("mm", "onResponse: "+response.getJSONArray(i).getDouble(1)+i);
                            bedModelArrayList.add(mBedModel);

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if(mcallback!=null)
                    {
                        mcallback.onRecievedSuccess(bedModelArrayList);
                    }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", "onErrorResponse: "+error);

            }
        });
        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
        return bedModelArrayList;
    }
    private ArrayList<currentStatusModel> currentStatusModels= new ArrayList<>();
    public List getCurrentStatusData(final AsyncnewTask mcallback)
    {
        //Log.d("inside", "getCurrentStatusData: ");
        url="https://raw.githubusercontent.com/Basantmhr/Hosting_Data_Repo/master/JSONFile/current_status.JSON";
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, (JSONArray) null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("data", "onResponse: "+response);

                try {
                    for(int i=0;i<response.length();i++) {
                        currentStatusModel cm = new currentStatusModel();
                        cm.setmStatus(response.getJSONArray(i).getString(0));
                        cm.setMcount(response.getJSONArray(i).getInt(1));
                         //Log.d("dd", "onResponse: "+response.getJSONArray(i).getString(0)+i);
                         //Log.d("mm", "onResponse: "+response.getJSONArray(i).getInt(1)+i);
                        currentStatusModels.add(cm);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if(mcallback!=null)
                {
                    mcallback.onRecievedSuccesscurrent(currentStatusModels);
                    //Log.d("insidemc", "getCurrentStatusData: ");
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", "onErrorResponse: "+error);

            }
        });
        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
        return currentStatusModels;
    }


}

