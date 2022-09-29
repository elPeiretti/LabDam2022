package com.mdgz.dam.labdam2022;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mdgz.dam.labdam2022.databinding.ActivityAlojamientoRecyclerBinding;
import com.mdgz.dam.labdam2022.databinding.FilaAlojamientoBinding;
import com.mdgz.dam.labdam2022.databinding.FragmentBusquedaBinding;
import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.mdgz.dam.labdam2022.model.AlojamientoDao;
import com.mdgz.dam.labdam2022.model.Departamento;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResultadoBusquedaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultadoBusquedaFragment extends Fragment {

    AlojamientoDao alojamiento = new AlojamientoDao();

    private RecyclerView recyclerView ;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Context ctx = this.getContext();
    private ActivityAlojamientoRecyclerBinding binding;

    private List<Alojamiento> lista = new ArrayList();



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ResultadoBusquedaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResultadoBusquedaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ResultadoBusquedaFragment newInstance(String param1, String param2) {
        ResultadoBusquedaFragment fragment = new ResultadoBusquedaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        lista.add(new Departamento(1, "Dpto1", "El primer dpto", 2, 300000.0));
        lista.add(new Departamento(2, "Dpto2", "El segundo dpto", 3, 300000.0));
        lista.add(new Departamento(3, "Dpto3", "El tercer dpto", 5, 300000.0));



        binding = ActivityAlojamientoRecyclerBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        recyclerView = binding.recylerAlojamiento;
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(ctx);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new AlojamientoRecyclerAdapter(lista, ctx);
        recyclerView.setAdapter(mAdapter);
        return binding.getRoot();
    }
}