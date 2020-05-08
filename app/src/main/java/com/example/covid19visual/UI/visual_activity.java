package com.example.covid19visual.UI;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.chart.common.listener.Event;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.charts.Pie;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;
import com.example.covid19visual.R;
import com.example.covid19visual.data.AsyncGetDataCompleted;
import com.example.covid19visual.data.AsyncnewTask;
import com.example.covid19visual.data.JsonPlaceHolder;
import com.example.covid19visual.model.BedPer10Thousand;
import com.example.covid19visual.model.currentStatusModel;

import java.util.ArrayList;
import java.util.List;

public class visual_activity extends AppCompatActivity {
    List<DataEntry> data = new ArrayList<>();
    ArrayList<currentStatusModel> currentStatusModelArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visual_activity);

       new JsonPlaceHolder().getCurrentStatusData(new AsyncnewTask() {
           @Override
           public void onRecievedSuccesscurrent(ArrayList<currentStatusModel> currentStatusModels) {
              currentStatusModelArrayList = currentStatusModels;
               for(int i=0;i<currentStatusModelArrayList.size();i++) {
                   data.add(new ValueDataEntry(currentStatusModelArrayList.get(i).getpatientStatus(), currentStatusModelArrayList.get(i).getpatientCount()));

               }
               AnyChartView anyChartView = findViewById(R.id.chartView);
               anyChartView.setProgressBar(findViewById(R.id.progress_bar));
               Pie pie= AnyChart.pie();
               pie.setOnClickListener(new ListenersInterface.OnClickListener(new String[]{"x","value"}) {
                   @Override
                   public void onClick(Event event) {
                       Toast.makeText(visual_activity.this, event.getData().get("x") + ":" + event.getData().get("value"), Toast.LENGTH_SHORT).show();
                   }
               });

               pie.data(data);
               pie.title("Current Case Status");
               pie.labels().position("outside");
               pie.legend().title()
                       .text("Current Case Status")
                       .padding(0d, 0d, 10d, 0d);

               pie.legend()
                       .position("center-bottom")
                       .itemsLayout(LegendLayout.HORIZONTAL)
                       .align(Align.CENTER);

               anyChartView.setChart(pie);
           }
       });






    }
}
