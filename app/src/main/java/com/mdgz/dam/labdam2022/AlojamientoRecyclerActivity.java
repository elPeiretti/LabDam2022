package com.mdgz.dam.labdam2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.mdgz.dam.labdam2022.model.AlojamientoDao;
import com.mdgz.dam.labdam2022.model.Departamento;
import com.mdgz.dam.labdam2022.model.Ubicacion;

public class AlojamientoRecyclerActivity extends AppCompatActivity {

    AlojamientoDao alojamiento;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alojamiento_recycler);
        recyclerView = (RecyclerView) findViewById(R.id.recylerAlojamiento);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
      //  mAdapter = new AlojamientoRecyclerAdapter(alojamiento.list(), ctx);
        recyclerView.setAdapter(mAdapter);


    }
}