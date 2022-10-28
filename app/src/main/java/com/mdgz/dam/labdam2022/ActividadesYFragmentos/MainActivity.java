package com.mdgz.dam.labdam2022.ActividadesYFragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
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
import android.view.View;
import android.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;
import com.mdgz.dam.labdam2022.R;
import com.mdgz.dam.labdam2022.databinding.ActivityMainBinding;
import com.mdgz.dam.labdam2022.model.Departamento;
import com.mdgz.dam.labdam2022.persistencia.bdd.MyDatabase;
import com.mdgz.dam.labdam2022.persistencia.repo.AlojamientoRepository;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MyDatabase.getInstance(getApplicationContext());

        MaterialToolbar mToolbar = binding.materialToolbar;
        mToolbar.setOnMenuItemClickListener(new MaterialToolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                NavController nav = Navigation.findNavController(binding.fragmentContainerView);

                switch (item.getItemId()) {
                    case R.id.configuracion:
                        nav.navigate(R.id.action_global_settingsFragment);
                        break;
                    case R.id.busquedaFragment:
                        nav.navigate(R.id.action_global_busquedaFragment);
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

        // agregar flechita para volver para atras
        mToolbar.setNavigationIcon(ContextCompat.getDrawable(this, androidx.appcompat.R.drawable.abc_ic_ab_back_material));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(binding.fragmentContainerView).navigateUp();
            }
        });
    }

}