package com.example.m;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Helperadapter extends RecyclerView.Adapter< Helperadapter.MyViewClass{
    ArrayList< String > name;
    ArrayList< String > photo;
    Context context;
    public Helperadapter(ArrayList< String > name, ArrayList< String > email, Context context){
        this.name = name;
        this.photo = photo;

        this.context = context;
    }
    @NonNull
    @Override
    public MyViewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        MyViewClass myViewClass=new MyViewClass(view);
        return myViewClass;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewClass holder, int position{
        holder.name.setText(name.get(position));
        holder.photo.setText(photo.get(position));


        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(context,"Item Clicked", Toast.LENGTH_LONG).show();
            }
        });
    }




    @Override
    public int  getItemCount(){
        return name.size();
    }



    public class MyViewClass extends RecyclerView.ViewHolder{


        TextView name;
        TextView photo;
        public MyViewClass(@NonNull View itemView){


            super(itemView);
            name = itemView.findViewById(R.id.name);
            photo = itemView.findViewById(R.id.photo);


        }





    }








}
