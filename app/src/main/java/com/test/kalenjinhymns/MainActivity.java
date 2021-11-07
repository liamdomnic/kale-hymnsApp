package com.test.kalenjinhymns;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Filter;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity  {
    private List<Song> songList=new ArrayList<>();
    private RecyclerView recyclerView;
    private SongAdapter songAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        SearchView searchView=findViewById(R.id.searchView);
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

               if (songList.contains(query)){

               }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });

        //toolbar
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.drawable.ic_launcher_background);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);

        //recyclerView
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        songAdapter=new SongAdapter(this,songList);
        recyclerView.setAdapter(songAdapter);

        addSongTitle();
        //
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //inbuilt inline divider
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));





    }

    private void addSongTitle() {



        songList.add(new Song("1"," Kilosu Jehovah nguno", "Praise God from whom all blessing flow"));
        songList.add(new Song("2"," Kilosu Kwandanyon", "Glory be to the Father"));
        songList.add(new Song("3"," Otienjin Kiptayandenyon", "All people that one earth Do well"));
        songList.add(new Song("4"," Kilosun Jehivah Missing", "All hail the power"));
        songList.add(new Song("5"," kigaktoin Kiptayat", "O God, Our help in a ges past"));
        songList.add(new Song("6"," Lumeiywotab kaniset", "The churches one foundation"));
        songList.add(new Song("7"," Pdvdfvdfvdf", "bdfdbfdbdfbdf"));
        songList.add(new Song("8"," Gdvdfvdfvdf", "bdfdbfdbdfbdf"));
        songList.add(new Song("9"," Tdvdfvdfvdf", "bdfdbfdbdfbdf"));
        songList.add(new Song("10"," Pdvdfvdfvdf", "bdfdbfdbdfbdf"));
        songList.add(new Song("11"," Gdvdfvdfvdf", "bdfdbfdbdfbdf"));
        songList.add(new Song("12"," Tdvdfvdfvdf", "bdfdbfdbdfbdf"));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()){
            case R.id.help:
                Toast.makeText(this, "You clicked help", Toast.LENGTH_SHORT).show();
                break;

            case R.id.about:
                Toast.makeText(this,"You clicked about",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}
