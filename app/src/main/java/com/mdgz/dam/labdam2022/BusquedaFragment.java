package com.mdgz.dam.labdam2022;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;

import com.mdgz.dam.labdam2022.databinding.FragmentBusquedaBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BusquedaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BusquedaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FragmentBusquedaBinding binding;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BusquedaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BusquedaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BusquedaFragment newInstance(String param1, String param2) {
        BusquedaFragment fragment = new BusquedaFragment();
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
        // Inflate the layout for this fragment
        //View v = inflater.inflate(R.layout.fragment_busqueda, container, false);
        binding = FragmentBusquedaBinding.inflate(inflater, container, false);

        Button b = binding.buttonBuscar;

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("app", "onClick: ");
                NavHostFragment.findNavController(BusquedaFragment.this).navigate(R.id.action_busquedaFragment_to_resultadoBusquedaFragment);
                //FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                //fragmentManager.beginTransaction().replace(R.id.fragmentContainerView,new ResultadoBusquedaFragment()).commit();

            }
        });

        //CheckBox WiFi
        CheckBox cbWifi = binding.cbWifi;
        cbWifi.setEnabled(false);
        CheckBox cbDepartamentos = binding.cbDepartamentos;
        cbDepartamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbDepartamentos.isChecked()){
                    cbWifi.setEnabled(true);
                }
                else{
                    cbWifi.setEnabled(false);
                    cbWifi.setChecked(false);
                }
            }
        });


        //Resetear
        binding.buttonResetear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.cbHoteles.setChecked(false);
                binding.cbDepartamentos.setChecked(false);
                binding.cbWifi.setEnabled(false);
                binding.cbWifi.setChecked(false);
                binding.sbCapacidad.setProgress(0);
                binding.sliderPrecios.setValues(0f,300000f);
            }
        });


        return binding.getRoot();
    }
}