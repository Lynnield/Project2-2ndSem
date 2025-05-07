package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class view_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view);

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.arrowBackRegister), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Handle back arrow click
        findViewById(R.id.BackArrow).setOnClickListener(v -> {
            onBackPressed(); // or use finish()
        });

        // Correctly cast bookNow as ConstraintLayout
        ConstraintLayout bookNowButton = findViewById(R.id.bookNow);
        bookNowButton.setOnClickListener(v -> {
            Intent intent = new Intent(view_activity.this, payment_activity.class);
            startActivity(intent);
        });
    }
}
