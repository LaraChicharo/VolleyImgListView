package com.example.chicharo.grid;

import com.example.chicharo.grid.adapter.CustomListAdapter0;
import com.example.chicharo.grid.model.Movie;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivityList extends Activity {
    // Log tag
    private static final String TAG = MainActivityList.class.getSimpleName();

    // Movies json url
    private static final String url = "http://api.androidhive.info/json/movies.json";
    private ProgressDialog pDialog;
    private List<Movie> movieList = new ArrayList<Movie>();
    private ListView listView;
    private CustomListAdapter0 adapter;
    private String eddgaaaaaarrrrrrrrrrrrrrrrrrrrrrrr="rulzzzzzz";
    private String aaaasdfa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        Log.d("ActivityList","onCreate");
        /*if (!movieList.isEmpty()) {
            Log.d("ActivityList", "cleaning movieList");
            movieList.clear();
        }*/
        ArrayList<String> genre = new ArrayList<String>();
        genre.add("sexy");
        genre.add("froot");
        Movie movie = new Movie("Marina",2010,6.76,genre);
        movieList.add(movie);
        listView = (ListView)findViewById(R.id.list);
        //listView.setAdapter(new ArrayAdapter<String>(this,
        //        android.R.layout.simple_list_item_1,genre));

        listView.setAdapter(new CustomListAdapter0(this,movieList));

        pDialog = new ProgressDialog(this);

        // Showing progress dialog before making http request
        //pDialog.setMessage("Loading.....kk");
        //pDialog.show();

        // changing action bar color
        getActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#655342")));

        // Creating volley request obj
        /*JsonArrayRequest movieReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("ActivityList","onResponse");
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < 3; i++) { //response.length()

                            try {
                                JSONObject obj = response.getJSONObject(i);
                                Movie movie = new Movie();
                                movie.setTitle(obj.getString("title"));
                                //movie.setThumbnailUrl(obj.getString("image")); //obj.getString("image")
                                movie.setRating(((Number) obj.get("rating"))
                                        .doubleValue());
                                movie.setYear(obj.getInt("releaseYear"));

                                // Genre is json array
                                JSONArray genreArry = obj.getJSONArray("genre");
                                ArrayList<String> genre = new ArrayList<String>();
                                for (int j = 0; j < genreArry.length(); j++) {
                                    genre.add((String) genreArry.get(j));
                                }
                                movie.setGenre(genre);

                                // adding movie to movies array
                                movieList.add(movie);
                                //String IsEmpty= String.valueOf(movieList.isEmpty());
                                //Log.d("movieList4",IsEmpty);

                            } catch (JSONException e) {
                                e.printStackTrace();
                                Log.e("JSONe",e.toString());
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data

                        //adapter.notifyDataSetChanged();// WTF?
                        //String isEmpty= String.valueOf(movieList.isEmpty());
                        //Log.d("movieList5",isEmpty);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VOLLEY",error.toString());
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();
            }
        });*/
        //String IsEmpty2= String.valueOf(movieList.isEmpty());
        //Log.d("movieList1",IsEmpty2);

        //IsEmpty2= String.valueOf(movieList.isEmpty());
        //Log.d("movieList2",IsEmpty2);
        // Adding request to request queue
        //AppController.getInstance().addToRequestQueue(movieReq);
        //IsEmpty2= String.valueOf(movieList.isEmpty());
        //Log.d("movieList3",IsEmpty2);

    }

    @Override
    public void onDestroy() {
        Log.d("ActivityMain","onDestroy");
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
