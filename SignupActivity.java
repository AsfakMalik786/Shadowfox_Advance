package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.LoginActivity;
import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {

    private EditText emailField, passwordField;
    private Button signupButton;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Initialize UI elements
        emailField = findViewById(R.id.emailtxt);
        passwordField = findViewById(R.id.passwordtxt);
        signupButton = findViewById(R.id.registerbtn);
        progressBar = findViewById(R.id.progrestxt);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String email = emailField.getText().toString().trim();
        String password = passwordField.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            emailField.setError("Email is required.");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            passwordField.setError("Password is required.");
            return;
        }

        if (password.length() < 6) {
            passwordField.setError("Password must be at least 6 characters.");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        // Register user with Firebase Authentication
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            progressBar.setVisibility(View.GONE);
            if (task.isSuccessful()) {
                // Registration successful, redirect to LoginActivity
                FirebaseUser user = mAuth.getCurrentUser();
                Toast.makeText(SignupActivity.this, "Registration successful. Please log in.", Toast.LENGTH_SHORT).show();

                // Redirect to LoginActivity
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();  // Close SignupActivity so the user can't return with back button
            } else {
                // If registration fails, display a message to the user.
                Toast.makeText(SignupActivity.this, "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
