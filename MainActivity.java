package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.Domain.Lessions;
import com.example.myapplication.Domain.Workout;
import com.example.myapplication.LoginActivity;
import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView welcometxt, userNameTxt, caloriestxt, sleeptxt, workouttxt;
    private ImageView imagehome, imagefav, imagecart;
    private EditText searchWorkout;
    private RecyclerView workoutRecyclerView;
    private Button logoutbtn;
    private FirebaseAuth mAuth;  // Firebase Authentication instance

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();  // Initialize FirebaseAuth

        // Initialize views
        initViews();

        // Fetch and display user info
        displayUserInfo();

        // Set data and listeners
        setupData();

        // Setup RecyclerView
        setupRecyclerView();

        // Handle Bottom Navigation actions
        setupBottomNavigation();

        // Logout button functionality
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    private void initViews() {
        welcometxt = findViewById(R.id.welcometxt);
        userNameTxt = findViewById(R.id.textView5); // TextView for displaying user's name
        caloriestxt = findViewById(R.id.caloriestxt);
        sleeptxt = findViewById(R.id.sleeptxt);
        workouttxt = findViewById(R.id.textView7);
        logoutbtn = findViewById(R.id.logoutbtn);
        searchWorkout = findViewById(R.id.editTextText);
        imagehome = findViewById(R.id.imagehome);
        imagefav = findViewById(R.id.imagefav);
        imagecart = findViewById(R.id.imagecart);
        workoutRecyclerView = findViewById(R.id.View1);
    }

    private void displayUserInfo() {
        // Get the current logged-in user
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {
            // Get the user's display name or email if the name is not available
            String displayName = currentUser.getDisplayName();
            String userEmail = currentUser.getEmail();

            // If display name is not available, show the email
            if (displayName != null && !displayName.isEmpty()) {
                userNameTxt.setText(displayName);
            } else {
                userNameTxt.setText(userEmail);
            }

            // Optional: You can display a welcome message using the name
            welcometxt.setText("Welcome, " + (displayName != null ? displayName : userEmail) + " ");
        } else {
            // If no user is logged in, redirect to the login screen
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
    }

    private void setupData() {
        // Set other monitoring data (calories, sleep, workouts)
        caloriestxt.setText("2500");
        sleeptxt.setText("6H 45Min");
        workouttxt.setText("2W 4D");
    }

    private void setupRecyclerView() {

        workoutRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


    }




    private void setupBottomNavigation() {
        imagehome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Home clicked", Toast.LENGTH_SHORT).show();
            }
        });

        imagefav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Favorites clicked", Toast.LENGTH_SHORT).show();
            }
        });

        imagecart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Cart clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void logout() {
        mAuth.signOut();
        Toast.makeText(MainActivity.this, "Logged out successfully", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
