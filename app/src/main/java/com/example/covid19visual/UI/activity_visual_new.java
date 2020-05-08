package com.example.covid19visual.UI;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;
import com.example.covid19visual.R;
import com.example.covid19visual.data.AsyncGetDataCompleted;
import com.example.covid19visual.data.JsonPlaceHolder;
import com.example.covid19visual.model.BedPer10Thousand;

import java.util.ArrayList;
import java.util.List;

public class activity_visual_new extends AppCompatActivity {

    List<DataEntry> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visual_new);
        new JsonPlaceHolder().getBedData(new AsyncGetDataCompleted() {
            @Override
            public void onRecievedSuccess(ArrayList<BedPer10Thousand> qm) {
                Log.d("total", "onRecievedSuccessinn: "+qm);
                for(int i=0;i<qm.size();i++) {
                    data.add(new ValueDataEntry(qm.get(i).getState().toString(), qm.get(i).getBedPer10K()));
                }
                    AnyChartView anyChartView = findViewById(R.id.chartViewNew);
                    anyChartView.setProgressBar(findViewById(R.id.progress_barNew));

                    Cartesian cartesian = AnyChart.column();
                    Column column = cartesian.column(data);


                    column.tooltip()
                            .titleFormat("{%X}")
                            .position(Position.CENTER_TOP)
                            .anchor(Anchor.CENTER_TOP)
                            .offsetX(50)
                            .format("{%Value}");

                    cartesian.animation(true);
                    cartesian.title("Population vs Bed in Hospital Analysis");

                    cartesian.yScale().minimum(0);

                    cartesian.yAxis(0).labels().format("{%Value}");
                    cartesian.xAxis(0).labels().rotation(90).format("{%Value}");
                    cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
                    cartesian.interactivity().hoverMode(HoverMode.BY_X);

                    cartesian.xAxis(0).title("State/UT");
                    cartesian.yAxis(0).title("Bed Per 10K Population");

                    anyChartView.setChart(cartesian);
                }




        });
    }
}
