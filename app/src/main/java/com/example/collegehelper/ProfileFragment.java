package com.example.collegehelper;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Find the button inside the fragment's view
        Button themeButton = view.findViewById(R.id.themeToggleButton);

        // Set click listener correctly
        themeButton.setOnClickListener(v -> toggleTheme());

        return view;  // Return the view
    }

    private void toggleTheme() {
        SharedPreferences prefs = requireActivity().getSharedPreferences("AppPrefs", requireActivity().MODE_PRIVATE);
        boolean isDarkMode = prefs.getBoolean("dark_mode", false);

        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);  // Switch to Light Mode
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES); // Switch to Dark Mode
        }

        prefs.edit().putBoolean("dark_mode", !isDarkMode).apply();
        requireActivity().recreate(); // Restart activity to apply theme change
    }
}
