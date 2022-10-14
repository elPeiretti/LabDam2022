package com.mdgz.dam.labdam2022;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;


import androidx.annotation.Nullable;

import androidx.appcompat.app.AlertDialog;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
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
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
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
        if(savedInstanceState!=null){
            binding.btnReservar.setEnabled(savedInstanceState.getBoolean("btnReservar"));
        }
        Bundle data = getArguments();
        binding.tvDetalle.setText(data.getString("descripcion"));

        Alojamiento aloj = getArguments().getParcelable("alojamiento");
        binding.tvTitulo.setText(aloj.getTitulo());
        binding.tvCaracteristicas.setText(aloj.getCaracteristicas());
        Picasso.get().load(aloj.getFoto()).into(binding.ivImagenAlojamientoDetalle);
        binding.sbCantPersonas.setMax(aloj.getCapacidad());

        binding.btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d[d]-MM-yyyy");
                LocalDate inicio = LocalDate.parse(binding.fechInicio.getText().toString(),dtf);
                LocalDate fin = LocalDate.parse(binding.fechFin.getText().toString(),dtf);

                Integer cantDias = (fin.getDayOfYear() - inicio.getDayOfYear())+365*(fin.getYear()-inicio.getYear());

                AlertDialog.Builder builder = new AlertDialog.Builder(ctx.getContext());
                builder.setTitle("Reserva realizada con éxito");
                builder.setMessage("Su reserva en "+aloj.getTitulo()+" por "+
                        cantDias.toString()+" días para "+binding.sbCantPersonas.getProgress()+
                        " personas fue registrada correctamente. ");
                builder.setPositiveButton("Continuar",null);
                builder.create().show();

                NavHostFragment.findNavController(DetalleAlojamientoFragment.this).navigate(R.id.action_detalleAlojamientoFragment_to_busquedaFragment);
            }
        });

        editFechaInicio = binding.fechInicio;
        pickInicio= binding.idBtnPickDate;
        pickFin= binding.idBtnPickDate2;

        Calendar calendario_inicio = Calendar.getInstance();
        pickInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int year = calendario_inicio.get(Calendar.YEAR);
                int month = calendario_inicio.get(Calendar.MONTH);
                int day = calendario_inicio.get(Calendar.DATE);

                    DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth) {
                                    calendario_inicio.set(year, monthOfYear, dayOfMonth);
                                    editFechaInicio.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                                }
                            },
                            year, month, day);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();
                }
        });

        editFechaFin = binding.fechFin;
        pickFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DATE);
                c.setTimeInMillis(calendario_inicio.getTimeInMillis()+(1000 * 60 * 60 * 24));

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                editFechaFin.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        },
                        year, month, day);
                datePickerDialog.getDatePicker().setMinDate(calendario_inicio.getTimeInMillis()+(1000 * 60 * 60 * 24));
                datePickerDialog.show();
            }
        });

        editFechaInicio.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {            }

            @Override
            public void afterTextChanged(Editable editable) {
                editFechaFin.setText(null);
                binding.btnReservar.setEnabled(false);
            }
        });

        editFechaFin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editFechaFin.getText().length()!=0 && editFechaInicio.getText().length()!=0){
                    binding.btnReservar.setEnabled(true);
                }
                else binding.btnReservar.setEnabled(false);
            }
        });

        return binding.getRoot();

}
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putBoolean("btnReservar",binding.btnReservar.isEnabled());
    }

}
