package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get references
        EditText usernameEditText = findViewById(R.id.inputEmail);
        EditText passwordEditText = findViewById(R.id.inputUsername);
        Button loginButton = findViewById(R.id.buttonLogin);
        TextView signUpText = findViewById(R.id.textViewSignUp);

        // Handle click to go to RegisterActivity
        signUpText.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });

        // Handle login button click
        loginButton.setOnClickListener(v -> {
            // Get the username and password from the EditText fields
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            // Basic validation for empty fields
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            } else if (username.equals("admin") && password.equals("1234")) {
                // Simulate successful login (you can replace this with your real login logic)
                startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                finish(); // Optional: prevent going back to loginx
            } else {
                // Simulate failed login
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
