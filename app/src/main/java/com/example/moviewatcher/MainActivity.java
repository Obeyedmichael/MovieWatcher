package com.example.moviewatcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    // Api info
    final String apiKey = "81e7df02";
    private String page="";

    //Movie Object
    Movies movie;
    private ArrayList<Movies> movies = new ArrayList<>();
    private TextView mTextViewResult;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        OkHttpClient Client = new OkHttpClient();

        String url="http://www.omdbapi.com/?apikey="+apiKey+"&s=avengers&page="+page;
        //String url="http://www.omdbapi.com/?apikey=81e7df02&i=tt4924706";

        Request request = new Request.Builder()
                .url(url)
                .build();
        Client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();


                    MainActivity.this.runOnUiThread(new Runnable() {


                        @Override
                        public void run() {

                            try {
                                JSONObject jsonObj = new JSONObject(myResponse);


                                JSONArray movies = jsonObj.getJSONArray("Search");


                                for (int i = 0; i < movies.length(); i++)

                                {
                                    Movies movie = new Movies("","","","","");
                                    JSONObject c = movies.getJSONObject(i);
                                    movie.setimdbId(c.getString("imdbID"));

                                    movie.setTitle(c.getString("Title"));
                                    movie.setYearOfRelease(c.getString("Year"));
                                    movie.setType(c.getString("Type"));
                                    movie.setPoster(c.getString("Poster"));
                                    //du skal skrive movie objektet i log.d
                                    Log.d("debug", movie.getTitle());
                                    //mTextViewResult.append(movie.getimdbId() + movie.getTitle() + movie.getYearOfRelease() + movie.getType() + movie.getPoster());

                                }
                            }
                            catch (JSONException exception)
                            {
                                Log.d("Debug" , "ERROR"); exception.printStackTrace();
                            }

                           // mTextViewResult.setText(myResponse);
                        }
                    });
                }


            }
        });
    }
}
