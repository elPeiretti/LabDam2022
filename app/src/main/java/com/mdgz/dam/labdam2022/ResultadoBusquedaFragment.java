package com.mdgz.dam.labdam2022;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.mdgz.dam.labdam2022.databinding.FragmentResultadoBusquedaBinding;
import com.mdgz.dam.labdam2022.repo.AlojamientoRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResultadoBusquedaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultadoBusquedaFragment extends Fragment {

    private RecyclerView recyclerView ;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Context ctx = this.getContext();
    private FragmentResultadoBusquedaBinding binding;

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

        binding = FragmentResultadoBusquedaBinding.inflate(inflater, container, false);

        binding.buttonNuevaBusqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ResultadoBusquedaFragment.this).navigate(R.id.action_resultadoBusquedaFragment_to_busquedaFragment);
            }
        });

        recyclerView = binding.recylerAlojamiento;
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(ctx);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new AlojamientoRecyclerAdapter(AlojamientoRepository._ALOJAMIENTOS, ctx);
        recyclerView.setAdapter(mAdapter);
        return binding.getRoot();
    }
}