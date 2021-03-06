package com.example.jamyangthinley.engdzoterminologyapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jamyangthinley.engdzoterminologyapp.Computer;
import com.example.jamyangthinley.engdzoterminologyapp.Finance;
import com.example.jamyangthinley.engdzoterminologyapp.R;

import java.util.List;

import com.example.jamyangthinley.engdzoterminologyapp.ListItem;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private int[] images = {R.drawable.computer,
            R.drawable.finance,
            R.drawable.political,
            R.drawable.health,
            R.drawable.economics

    };

    private Context context;
    private List<ListItem> listItems;

    public MyAdapter(Context context,List listitem){
        this.context =context;
        this.listItems = listitem;


    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {



        ListItem item= listItems.get(position);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.item_Images.setImageResource(images[position]);


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView name;
        public TextView description;
        public ImageView item_Images;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            name =(TextView) itemView.findViewById(R.id.title);
            description=(TextView) itemView.findViewById(R.id.description);
            item_Images=(ImageView)itemView.findViewById(R.id.item_image);



        }

        @Override
        public void onClick(View view) {
            int position =getAdapterPosition();
            ListItem item = listItems.get(position);
            if (position==0) {
                Intent intent = new Intent(context, Computer.class);
                context.startActivity(intent);
            }

            else if (position==1) {
                Intent intent = new Intent(context, Finance.class);
                context.startActivity(intent);
            }





            //Toast.makeText(context,item.getName(),Toast.LENGTH_SHORT).show();


        }
    }
}
