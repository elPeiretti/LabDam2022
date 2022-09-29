package com.mdgz.dam.labdam2022;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mdgz.dam.labdam2022.model.Alojamiento;

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
       // holder.favorito.setTag(position);
        holder.nombreAlojamiento.setText(alojamientoDataSet.get(position).getTitulo());
      //  holder.imagen.setTag(position);

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
