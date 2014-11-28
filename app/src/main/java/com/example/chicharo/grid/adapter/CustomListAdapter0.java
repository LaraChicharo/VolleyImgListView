package com.example.chicharo.grid.adapter;

import com.example.chicharo.grid.R;
import com.example.chicharo.grid.app.AppController;
import com.example.chicharo.grid.model.Movie;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class CustomListAdapter0 extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Movie> movieItems;
    private List<String> listGenreStr;

    //ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListAdapter0(Activity activity, List<Movie> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
        int intGetCount = getCount();
        Log.d("CLArecivedSize",String.valueOf(intGetCount));
    }

    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        listGenreStr = new ArrayList<String>();
        Log.d("getView",String.valueOf(position));
        /*if (inflater == null)*/
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        /*if (convertView == null)*/
            convertView = inflater.inflate(R.layout.list_row, null);

        /*if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();*/
        //NetworkImageView thumbNail = (NetworkImageView) convertView
                //.findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView rating = (TextView) convertView.findViewById(R.id.rating);
        TextView genre = (TextView) convertView.findViewById(R.id.genre);
        TextView year = (TextView) convertView.findViewById(R.id.releaseYear);

        // getting movie data for the row
        Movie m = movieItems.get(position);

        // thumbnail image
        //thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);

        // title
        title.setText("Marina");

        // rating
        rating.setText("Rating: " + String.valueOf(5));

        // genre
        listGenreStr.add("sexy");
        listGenreStr.add("froot");
        String genreStr = "";
        for (String str : listGenreStr) {
            genreStr += str + ", ";
        }
        genreStr = genreStr.length() > 0 ? genreStr.substring(0,
                genreStr.length() - 2) : genreStr;
        genre.setText(genreStr);
        listGenreStr.clear();

        // release year
        year.setText(String.valueOf(2014));

        return convertView;
    }

    }
