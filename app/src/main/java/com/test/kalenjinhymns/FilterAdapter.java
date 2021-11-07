package com.test.kalenjinhymns;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

public class FilterAdapter extends SongAdapter implements Filterable {

    private MainActivity mainActivity;
    private Typeface typeface;
    private ArrayList<Song>songList;
    private ArrayList<Song> filteredSongs;


    public FilterAdapter(Context context, List<Song> songList) {
        super(context, songList);
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}
