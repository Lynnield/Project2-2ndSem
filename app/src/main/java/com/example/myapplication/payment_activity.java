package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class payment_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payment);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Handle back arrow click
        findViewById(R.id.backArrow).setOnClickListener(v -> {
            onBackPressed(); // or use finish() if you just want to close this activity
        });

        // Handle payment button click
        ConstraintLayout paymentButton = findViewById(R.id.payment);
        paymentButton.setOnClickListener(v -> {
            Intent intent = new Intent(payment_activity.this, confirmPayment_activity.class);
            startActivity(intent);
        });
    }
}
