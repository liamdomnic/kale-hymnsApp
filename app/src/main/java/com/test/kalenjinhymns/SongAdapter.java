package com.test.kalenjinhymns;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.MyViewHolder> {


    private List<Song> songList;
    Context context;

    public SongAdapter(Context context,List<Song> songList) {
        this.songList = songList;
        this.context=context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View itemView= LayoutInflater.from (parent.getContext().R.layout.hymns_list,parent,false);
        MyViewHolder holder= new MyViewHolder(itemView);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Song song=songList.get(position);

        holder.title_kale.setText(song.getTitle_kale());
        holder.title_en.setText(song.getTitle_en());
        holder.song_id.setText(song.getId());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Recycler " +position,Toast.LENGTH_LONG ).show();

                Intent intent=new Intent();

                switch (position){
                    case 0:
                        intent=new Intent(context,SongZero.class);
                        context.startActivity(intent);
                        break;

                    case 1:
                        intent=new Intent(context,SongOne.class);
                        context.startActivity(intent);
                        break;

                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title_kale,title_en,song_id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title_kale=itemView.findViewById(R.id.title_kale);
            title_en=itemView.findViewById(R.id.title_en);
            song_id=itemView.findViewById(R.id.song_id);

        }


        @Override
        public void onClick(View v) {

        }
    }



}
