package com.mdgz.dam.labdam2022.ActividadesYFragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mdgz.dam.labdam2022.databinding.FragmentBusquedaBinding;
import com.mdgz.dam.labdam2022.databinding.FragmentVistaArchivoBinding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VistaArchivoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VistaArchivoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentVistaArchivoBinding binding;

    public VistaArchivoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VistaArchivoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VistaArchivoFragment newInstance(String param1, String param2) {
        VistaArchivoFragment fragment = new VistaArchivoFragment();
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

        binding = FragmentVistaArchivoBinding.inflate(inflater, container, false);
        recuperarArchivo();
        return binding.getRoot();
    }

    public void recuperarArchivo(){

        FileInputStream mInput = null;
        try {
            mInput = getContext().openFileInput("RegistroBusquedas.txt");

        InputStreamReader inputStreamReader= new InputStreamReader(mInput, StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(inputStreamReader)){
            String line = reader.readLine();
            while(line!=null){
                sb.append(line).append('\n');
                line = reader.readLine();
            }
            mInput.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            binding.tvContenido.setText(sb.toString());
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            binding.tvContenido.setText("");
        }



    }
}