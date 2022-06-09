package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.example.unitconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // change the the application theme to be used for other displaying other screens other than the splash screen
        setTheme(R.style.Theme_UnitConverter);

        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_container);

        //hide the status bar
        hideSystemBars();

    }

    @Override
    protected void onDestroy() {
        binding = null;
        super.onDestroy();
    }

    private void hideSystemBars() {
        WindowInsetsControllerCompat controllerCompat =
                ViewCompat.getWindowInsetsController(findViewById(R.id.nav_host_fragment_container));
        if (controllerCompat == null) return;
        controllerCompat.setSystemBarsBehavior(
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        );
        controllerCompat.hide(WindowInsetsCompat.Type.statusBars());
    }
}