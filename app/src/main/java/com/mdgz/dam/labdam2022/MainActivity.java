package com.mdgz.dam.labdam2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.FrameLayout;

import com.mdgz.dam.labdam2022.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

        BusquedaFragment f_busqueda = new BusquedaFragment();
        FragmentManager frg_mng = getSupportFragmentManager();
        frg_mng.beginTransaction().add(R.id.fragmentContainerView, f_busqueda).addToBackStack(null).commit();
    }
}