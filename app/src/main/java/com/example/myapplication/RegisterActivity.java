package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        // Handle window insets for the back arrow
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.arrowBackRegister), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //  Handle back arrow click
        ImageButton backButton = findViewById(R.id.arrowBackRegister);
        backButton.setOnClickListener(v -> {
            onBackPressed(); // This will navigate to the previous activity in the back stack
        });

        // Get references to input fields and button
        EditText usernameEditText = findViewById(R.id.inputUsername);
        EditText emailEditText = findViewById(R.id.inputEmail);
        EditText passwordEditText = findViewById(R.id.inputPassword);
        EditText confirmPasswordEditText = findViewById(R.id.inputConfirmPassword);
        Button registerButton = findViewById(R.id.buttonRegister);
        TextView loginText = findViewById(R.id.alreadyHaveAccount);

        // Ensure views are initialized
        if (usernameEditText == null || emailEditText == null || passwordEditText == null ||
                confirmPasswordEditText == null || registerButton == null || loginText == null) {
            Toast.makeText(this, "Error: Missing view components", Toast.LENGTH_SHORT).show();
            return; // Exit the method early if views are not found.
        }

        // Handle click to go to LoginActivity
        loginText.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        });

        // Handle register button click
        registerButton.setOnClickListener(v -> {
            // Get the input values
            String username = usernameEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String confirmPassword = confirmPasswordEditText.getText().toString().trim();

            // Basic validation for empty fields
            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                // Validate email format
                Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confirmPassword)) {
                // Check if the password and confirm password match
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            } else {
                // Simulate a successful registration (you can replace this with real registration logic)
                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show();

                // After successful registration, navigate to LoginActivity
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish(); // Optional: prevent going back to register
            }
        });
    }
}
