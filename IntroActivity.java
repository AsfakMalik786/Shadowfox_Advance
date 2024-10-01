package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.LoginActivity;
import com.example.myapplication.R;
import com.example.myapplication.SignupActivity;
import com.example.myapplication.databinding.ActivityIntroBinding;

import java.security.Signature;

public class IntroActivity extends AppCompatActivity {

    // ViewBinding instance
    ActivityIntroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize view binding
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set click listener for the "Let's Go" button
        binding.startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        binding.signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this , SignupActivity.class);
            }
        });
    }
}
