package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.example.unitconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_container);

        hideSystemBars();

    }

    private void hideSystemBars() {
        WindowInsetsControllerCompat controllerCompat =
        ViewCompat.getWindowInsetsController(getWindow().getDecorView());
        if(controllerCompat == null) return;
        controllerCompat.setSystemBarsBehavior(
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        );
        controllerCompat.hide(WindowInsetsCompat.Type.systemBars());
    }
}