package com.mdgz.dam.labdam2022;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;


import androidx.annotation.Nullable;

import androidx.appcompat.app.AlertDialog;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.mdgz.dam.labdam2022.databinding.FragmentBusquedaBinding;
import com.mdgz.dam.labdam2022.databinding.FragmentDetalleAlojamientoBinding;
import com.mdgz.dam.labdam2022.databinding.FragmentResultadoBusquedaBinding;
import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetalleAlojamientoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetalleAlojamientoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FragmentDetalleAlojamientoBinding binding;

    private EditText editFechaInicio;
    private ImageButton pickInicio;
    private EditText editFechaFin;
    private ImageButton pickFin;

    private DetalleAlojamientoFragment ctx;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public DetalleAlojamientoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetalleAlojamientoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetalleAlojamientoFragment newInstance(String param1, String param2) {
        DetalleAlojamientoFragment fragment = new DetalleAlojamientoFragment();
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
        ctx = this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetalleAlojamientoBinding.inflate(inflater, container, false);

        Bundle data = getArguments();
        binding.tvDetalle.setText(data.getString("descripcion"));

        Alojamiento aloj = getArguments().getParcelable("alojamiento");
        binding.tvTitulo.setText(aloj.getTitulo());
        binding.tvCaracteristicas.setText(aloj.getCaracteristicas());
        Picasso.get().load(aloj.getFoto()).into(binding.ivImagenAlojamientoDetalle);



        binding.btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx.getContext());
                builder.setTitle("Reserva realizada con éxito");
                builder.setMessage("Su reserva en <nombre alojamiento> por <dias> días para <cantidad> personas fue registrada correctamente. ");
                builder.setPositiveButton("Continuar",null);
                builder.create().show();
            }

        });

        editFechaInicio = binding.fechInicio;
        pickInicio= binding.idBtnPickDate;

        pickInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DATE);

                    DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth) {
                                    editFechaInicio.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                }
                            },

                            year, month, day);

                    datePickerDialog.show();
                }

        });
        editFechaFin = binding.fechFin;
        pickFin= binding.idBtnPickDate2;

        pickFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DATE);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                editFechaFin.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        },

                        year, month, day);

                datePickerDialog.show();
            }
        });return binding.getRoot();

}


}
