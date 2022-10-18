package com.mdgz.dam.labdam2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;
import com.mdgz.dam.labdam2022.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MaterialToolbar mToolbar = binding.materialToolbar;
        mToolbar.setOnMenuItemClickListener(new MaterialToolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.configuracion:
                        Navigation.findNavController(binding.fragmentContainerView).navigate(R.id.action_global_settingsFragment);
                        break;
                    case R.id.buscar:
                        Navigation.findNavController(binding.fragmentContainerView).navigate(R.id.action_global_busquedaFragment);
                        break;
                    case R.id.reservas:
                       // Navigation.findNavController(binding.fragmentContainerView).navigate(R.id.action_global_busquedaFragment);
                        break;
                    case R.id.favoritos:
                        //  Navigation.findNavController(binding.fragmentContainerView).navigate(R.id.action_global_busquedaFragment);
                        break;
                }
                return true;
            }
        });
    }

}