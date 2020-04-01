package com.sisixa.cocktailbeginner;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;



import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    ListView lv;

    private static final String USGS_REQUEST_URL ="https://www.thecocktaildb.com/api/json/v1/1/search.php?s=cocktail";

    ArrayList<Cocktail> contactList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        contactList = new ArrayList<Cocktail>();

        lv = (ListView) findViewById(R.id.list);





runOnUiThread(new Runnable() {
    @Override
    public void run() {
        new ReadJSON().execute(USGS_REQUEST_URL);
    }
});




    }

    @Override
    // This method initialize the contents of the Activity's options menu.
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the Options Menu we specified in XML
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




    private class ReadJSON extends AsyncTask<String, Integer, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "Json Data is downloading", Toast.LENGTH_LONG).show();

        }


        @Override
        protected String doInBackground(String... params) {
            return readURL(params[0]);



/*
                        //---------ingredients-------------//

                        if(c.getString("strIngredient1")!="null") {
                            String ingredients1 = "• "  +c.getString("strIngredient1");
                            contact.put("strIngredient1", ingredients1);

                    }

                    if(c.getString("strIngredient2")!="null") {
                        String ingredients2 = "• "  +c.getString("strIngredient2");
                        contact.put("strIngredient2", ingredients2);
                    }
                            if(c.getString("strIngredient3")!="null") {
                                String ingredients3 = "• "  +c.getString("strIngredient3");
                                contact.put("strIngredient3", ingredients3);


                            }

                            if(c.getString("strIngredient4")!="null") {
                            String ingredients4 ="• "  + c.getString("strIngredient4");
                                contact.put("strIngredient4", ingredients4);

                            }
                        if(c.getString("strIngredient5")!="null") {
                            String ingredients5 = "• "  +c.getString("strIngredient5");
                            contact.put("strIngredient5", ingredients5);

                        }
                        if(c.getString("strIngredient6")!="null") {
                            String ingredients6 = "• "  +c.getString("strIngredient6");
                            contact.put("strIngredient6", ingredients6);


                        }

                        //---------ingredients-------------//


                        //---------measure-------------//


                        if(c.getString("strMeasure1")!="null") {
                            String measure1 = "• "  +c.getString("strMeasure1");
                            contact.put("strMeasure1", measure1);
                        }
                        if(c.getString("strMeasure2")!="null") {
                            String measure2 = "• "  +c.getString("strMeasure2");
                            contact.put("strMeasure2", measure2);
                        }
                        if(c.getString("strMeasure3")!="null") {
                                String measure3 = "• "  +c.getString("strMeasure3");
                            contact.put("strMeasure3", measure3);
                        }
                        if(c.getString("strMeasure4")!="null") {
                            String measure4 = "• "  +c.getString("strMeasure4");
                            contact.put("strMeasure4", measure4);
                        }
                        if(c.getString("strMeasure5")!="null") {
                            String measure5 = "• "  + c.getString("strMeasure5");
                            contact.put("strMeasure5", measure5);
                        }
                        if(c.getString("strMeasure6")!="null") {
                            String measure6 = "• "  +c.getString("strMeasure6");
                            contact.put("strMeasure6", measure6);
                        }




                        // tmp hash map for single contact


                        // adding each child node to HashMap key => value
                        contact.put("strDrink", name);
                        contact.put("strDrinkThumb",image);





                        // adding contact to contact list
                        contactList.add(contact);

*/


        }


        @Override
        protected void onPostExecute(String content) {


            try {
                JSONObject jsonObj = new JSONObject(content);

                // Getting JSON Array node
                JSONArray contacts = jsonObj.getJSONArray("drinks");

                // looping through All Contacts
                for (int i = 0; i < contacts.length(); i++) {
                    JSONObject c = contacts.getJSONObject(i);
                    contactList.add(new Cocktail(c.getString("strDrink"),
                            c.getString("strIngredient1"),
                            c.getString("strIngredient2"),
                            c.getString("strIngredient3"),
                            c.getString("strIngredient4"),
                            c.getString("strIngredient5"),
                            c.getString("strIngredient6"),
                            c.getString("strMeasure1"),
                            c.getString("strMeasure2"),
                            c.getString("strMeasure3"),
                            c.getString("strMeasure4"),
                            c.getString("strMeasure5"),
                            c.getString("strMeasure6"),
                            c.getString("strDrinkThumb")





                    ));




                }


            } catch (final JSONException e) {
                e.printStackTrace();

            }





            CocktailAdapter adapter = new CocktailAdapter(getApplicationContext(), R.layout.list_item, contactList);

            lv.setAdapter(adapter);





        }
    }


    private static String readURL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            // create a url object
            URL url = new URL(theUrl);
            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();
            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    }





