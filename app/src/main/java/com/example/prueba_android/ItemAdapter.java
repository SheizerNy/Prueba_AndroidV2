package com.example.prueba_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{
    private List<Items> itemList;

    private Context context;

    public ItemAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Items> itemList){
        this.itemList= itemList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false ));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Items item =itemList.get(position);
        holder.imageView.setImageResource(item.getImage());
        holder.textView.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        public ItemViewHolder(@NonNull View itemview){
            super(itemview);

            imageView = itemview.findViewById(R.id.image_list);
            textView = itemview.findViewById(R.id.title_list);
        }
    }


}
