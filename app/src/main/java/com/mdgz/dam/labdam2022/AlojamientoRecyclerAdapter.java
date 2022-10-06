package com.mdgz.dam.labdam2022;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;


import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AlojamientoRecyclerAdapter extends RecyclerView.Adapter<AlojamientoRecyclerAdapter.AlojamientoViewHolder> {
    private final Context context;
    private List<Alojamiento> alojamientoDataSet;

    public AlojamientoRecyclerAdapter(List<Alojamiento> myDataSet, Context context){
        alojamientoDataSet = myDataSet;
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
        // Glide.with(this.context).load(alojamientoDataSet.get(position).getFoto()).into(holder.imagen);
        Picasso.get().load(alojamientoDataSet.get(position).getFoto()).into(holder.imagen);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle data = new Bundle();
                Alojamiento opt = alojamientoDataSet.get(holder.getLayoutPosition());
                // cambiar a parcelable en el futuro TODO
                data.putString("titulo",opt.getTitulo());
                data.putString("descripcion",opt.getDescripcion());
                data.putInt("capacidad",opt.getCapacidad());
                data.putDouble("precio base",opt.getPrecioBase());
                data.putString("foto",opt.getFoto());

                Navigation.findNavController(view).navigate(R.id.action_resultadoBusquedaFragment_to_detalleAlojamientoFragment,data);
            }
        });

    }

    @Override
    public int getItemCount() {
        return alojamientoDataSet.size();
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
