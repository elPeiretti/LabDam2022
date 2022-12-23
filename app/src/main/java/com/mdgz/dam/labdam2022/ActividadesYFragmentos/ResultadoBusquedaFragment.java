package com.mdgz.dam.labdam2022.ActividadesYFragmentos;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mdgz.dam.labdam2022.R;
import com.mdgz.dam.labdam2022.databinding.FragmentResultadoBusquedaBinding;
import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.mdgz.dam.labdam2022.model.Favorito;
import com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource.FavoritoDataSource;
import com.mdgz.dam.labdam2022.persistencia.repo.AlojamientoRepository;
import com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource.OnResult;
import com.mdgz.dam.labdam2022.persistencia.repo.FavoritoRepository;

import java.util.List;


public class ResultadoBusquedaFragment extends Fragment implements OnResult<List<Alojamiento>>, FavoritoDataSource.GetAllFavoritosCallback {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Context ctx = this.getContext();
    private FragmentResultadoBusquedaBinding binding;
    private List<Alojamiento> result;

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
        //para cargar los alojamientos
        AlojamientoRepository.createInstance(ctx).getAllAlojamientos(this);
        FavoritoRepository.createInstance().getAllFavoritos(this);
        recyclerView.setAdapter(mAdapter);
        return binding.getRoot();
    }


    //get all alojamientos callback
    @Override
    public void onSuccess(List<Alojamiento> result) {
        mAdapter = new AlojamientoRecyclerAdapter(result, ctx);
        this.result = result;
    }

    @Override
    public void onError(Throwable exception) {
    }


    // getAllfavoritos callback
    @Override
    public void onError() {

    }

    @Override
    public void onResult(List<Favorito> favs) {
        // Esto es muy feo pero no se me ocurrio otra manera.
        for (Favorito f: favs) {
            Log.i("favorito", f.getAlojamientoID().toString());
            for (Alojamiento a : result) {
                if (f.getAlojamientoID().equals(a.getId()))
                    a.setEsFav(true);
            }
        }
        mAdapter.notifyDataSetChanged();
    }
}