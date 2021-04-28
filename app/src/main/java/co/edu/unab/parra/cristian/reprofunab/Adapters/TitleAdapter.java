package co.edu.unab.parra.cristian.reprofunab.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import co.edu.unab.parra.cristian.reprofunab.Model.TitleModel;
import co.edu.unab.parra.cristian.reprofunab.R;


public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.ViewHolder> {
    List<TitleModel> titulos, mFilteredList;
    onItemClickListener miEscuchador;
    // id del layout list_item_informacion
    private final LayoutInflater mInflater;


    public TitleAdapter(List<TitleModel> itemList, Context context, onItemClickListener miEscuchador) {
        this.mInflater = LayoutInflater.from(context);
        this.titulos = itemList;
        this.mFilteredList = titulos;
        this.miEscuchador = miEscuchador;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final TitleModel myTitleModel = titulos.get(position);
        holder.bindData(titulos.get(position));
        holder.btndelete.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                titulos.remove(myTitleModel);
            }
        });
        holder.btnver.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                miEscuchador.onItemClick(myTitleModel, position);
            }

        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miEscuchador.onItemClick(myTitleModel, position);
            }
        });
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        Button btnver;
        Button btndelete;
        TextView nombre, descripcion;

        public ViewHolder(View ItemView) {
            super(ItemView);
            img = ItemView.findViewById(R.id.img);
            nombre = ItemView.findViewById(R.id.txtNombre);
            descripcion = ItemView.findViewById(R.id.txtDescripcion);
            this.btnver= ItemView.findViewById(R.id.buttonver);
            this.btndelete = ItemView.findViewById(R.id.buttonocultar);
        }

        public void bindData(final TitleModel item) {
            img.setImageResource(item.getImg());
            nombre.setText(item.getNombre());
            descripcion.setText(item.getDescripcion());
        }
    }


    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }


    public interface onItemClickListener{
        void onItemClick(TitleModel myTitleModel, int posicion);
    }

}
