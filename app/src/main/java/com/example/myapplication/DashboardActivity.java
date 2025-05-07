package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

        // Set insets padding (this is for adjusting layout insets if needed)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.arrowBackRegister), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Handle the click for viewOne (navigate to view_activity)
        findViewById(R.id.viewOne).setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, view_activity.class);
            startActivity(intent);
        });

        // Handle the click for viewTwo (navigate to viewRoom_Activity)
        findViewById(R.id.viewTwo).setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, viewRoom2_Activity.class);
            startActivity(intent);
        });

        // Handle the click for viewThree (navigate to viewRoom3_Activity)
        findViewById(R.id.viewThree).setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, viewroom3_activity.class);
            startActivity(intent);
        });

        // Handle the click for viewFour (navigate to viewRoom4_Activity)
        findViewById(R.id.viewFour).setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, viewRoom4_activity.class);
            startActivity(intent);
        });

        // Handle the click for viewFive (navigate to viewRoom5_Activity)
        findViewById(R.id.viewFive).setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, viewRoom5_activity.class);
            startActivity(intent);
        });
        // Handle the click for viewSix (navigate to viewRoom_Activity)
        findViewById(R.id.viewSix).setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, viewRoom2_Activity.class);
            startActivity(intent);
        });


    }
}
