package com.mdgz.dam.labdam2022.ActividadesYFragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.mdgz.dam.labdam2022.R;
import com.mdgz.dam.labdam2022.databinding.ActivityMainBinding;
import com.mdgz.dam.labdam2022.persistencia.repo.AlojamientoRepository;
import com.mdgz.dam.labdam2022.persistencia.repo.CiudadRepository;
import com.mdgz.dam.labdam2022.persistencia.room.MyDatabase;
import com.mdgz.dam.labdam2022.persistencia.room.mapper.AlojamientoMapper;
import com.mdgz.dam.labdam2022.persistencia.room.mapper.CiudadMapper;
import com.mdgz.dam.labdam2022.persistencia.room.mapper.DepartamentoMapper;
import com.mdgz.dam.labdam2022.persistencia.room.mapper.HabitacionMapper;
import com.mdgz.dam.labdam2022.persistencia.room.mapper.HotelMapper;
import com.mdgz.dam.labdam2022.persistencia.room.mapper.UbicacionMapper;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MyDatabase.getInstance(getApplicationContext());

       /* MyDatabase.getInstance(getApplicationContext()).alojamientoDAO().insertAllCiudades(CiudadMapper.toEntities(CiudadRepository._CIUDADES));
        MyDatabase.getInstance(getApplicationContext()).alojamientoDAO().insertAllUbicaciones(UbicacionMapper.toEntities(AlojamientoRepository._UBICACIONES));
        MyDatabase.getInstance(getApplicationContext()).alojamientoDAO().insertAllHoteles(HotelMapper.toEntities(AlojamientoRepository._HOTELES));
        MyDatabase.getInstance(getApplicationContext()).alojamientoDAO().insertAllAlojamientos(AlojamientoMapper.toEntites(AlojamientoRepository._ALOJAMIENTOS));
        MyDatabase.getInstance(getApplicationContext()).alojamientoDAO().insertAllDepartamentos(DepartamentoMapper.toEntities(AlojamientoRepository._DEPARTAMENTOS));
        MyDatabase.getInstance(getApplicationContext()).alojamientoDAO().insertAllHabitaciones(HabitacionMapper.toEntities(AlojamientoRepository._HABITACIONES));
*/

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