package com.example.covid19visual.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.covid19visual.R;

public class dashboard extends AppCompatActivity {
private CardView cardViewV1 ,cardViewV2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        cardViewV1=findViewById(R.id.cardViewV1);
        cardViewV2=findViewById(R.id.cardViewV2);
        cardViewV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showGraph1 = new Intent(getApplicationContext() , visual_activity.class);
                startActivity(showGraph1);
            }
        });
        cardViewV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showGraph2 = new Intent(getApplicationContext() , activity_visual_new.class);
                startActivity(showGraph2);
            }
        });
    }
}
