package com.mdgz.dam.labdam2022.ActividadesYFragmentos;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import com.mdgz.dam.labdam2022.R;
import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.mdgz.dam.labdam2022.model.Favorito;
import com.mdgz.dam.labdam2022.persistencia.InterfacesDataSource.FavoritoDataSource;
import com.mdgz.dam.labdam2022.persistencia.repo.FavoritoRepository;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AlojamientoRecyclerAdapter extends RecyclerView.Adapter<AlojamientoRecyclerAdapter.AlojamientoViewHolder> implements FavoritoDataSource.SaveFavoritoCallback, FavoritoDataSource.RemoveFavoritoCallback{
    private Context context;
    private List<Alojamiento> alojamientoDataSet;
    private List<Favorito> favoritoDataSet;

    public AlojamientoRecyclerAdapter(List<Alojamiento> myDataSet, List<Favorito> favoritos, Context context){
        alojamientoDataSet = myDataSet;
        favoritoDataSet = favoritos;
        this.context = context;
    }

    @Override
    public AlojamientoViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fila_alojamiento, viewGroup, false);
        return new AlojamientoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlojamientoViewHolder holder, int position) {
       holder.nombreAlojamiento.setText(alojamientoDataSet.get(position).getTitulo());
        //holder.imagen.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(),alojamientoDataSet.get(position).getFoto(),null));
        //Glide.with(this.context).load(alojamientoDataSet.get(position).getFoto()).into(holder.imagen);
        Picasso.get().load(alojamientoDataSet.get(position).getFoto()).into(holder.imagen);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle data = new Bundle();
                Alojamiento opt = alojamientoDataSet.get(holder.getLayoutPosition());
                data.putParcelable("alojamiento",opt);
                Navigation.findNavController(view).navigate(R.id.action_resultadoBusquedaFragment_to_detalleAlojamientoFragment,data);
            }
        });


        // agregar o eliminar favoritos
        FavoritoDataSource.SaveFavoritoCallback insertCtx = this;
        FavoritoDataSource.RemoveFavoritoCallback removeCtx = this;

        holder.favorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alojamiento aloj = alojamientoDataSet.get(holder.getLayoutPosition());

                List<Favorito> favs = favoritoDataSet.stream()
                                            .filter(f -> f.getAlojamientoID()
                                            .equals(aloj.getId()))
                                            .collect(Collectors.toList());
                if (favs.isEmpty()) {
                    Favorito fav = new Favorito(aloj.getId(), UUID.fromString("50e8400-e29b-41d4-a716-446655440000"));
                    FavoritoRepository.createInstance(context).saveFavorito(insertCtx, fav);
                    holder.favorito.setBackground(ContextCompat.getDrawable(holder.favorito.getContext(), android.R.drawable.star_on));
                    favoritoDataSet.add(fav);
                }
                else{
                    holder.favorito.setBackground(ContextCompat.getDrawable(holder.favorito.getContext(),android.R.drawable.star_off));
                    FavoritoRepository.createInstance(context).removeFavorito(removeCtx, favs.get(0));
                    favoritoDataSet.remove(favs.get(0));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return alojamientoDataSet.size();
    }

    @Override
    public void onError() {}

    @Override
    public void onResult() {
    }

    public class AlojamientoViewHolder extends RecyclerView.ViewHolder{
        CardView card;
        TextView nombreAlojamiento;
        ImageButton favorito;
        ImageView imagen;

        public AlojamientoViewHolder(View v) {
            super(v);
            card = v.findViewById(R.id.card);
            nombreAlojamiento = v.findViewById(R.id.tv_Nombre);
            favorito = v.findViewById(R.id.btn_fav);
            imagen = v.findViewById(R.id.iv_ImagenAlojamiento);
        }
    }


}
