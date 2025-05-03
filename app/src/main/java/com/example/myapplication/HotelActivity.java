package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HotelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hotel);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set up buttons
        Button loginAsUserButton = findViewById(R.id.loginAsUser);
        Button loginAsGuestButton = findViewById(R.id.logInAsGuest);

        loginAsUserButton.setOnClickListener(v -> {
            // Navigate to LoginActivity
            Intent intent = new Intent(HotelActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        loginAsGuestButton.setOnClickListener(v -> {
            // Navigate to DashboardActivity as Guest
            Intent intent = new Intent(HotelActivity.this, DashboardActivity.class);
            intent.putExtra("isGuest", true);
            startActivity(intent);
        });
    }
}
