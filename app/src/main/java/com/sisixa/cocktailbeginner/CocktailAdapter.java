package com.sisixa.cocktailbeginner;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class CocktailAdapter extends ArrayAdapter<Cocktail> {
    ArrayList<Cocktail> cocktail;
    Context context;
    int resource;

    public CocktailAdapter(@NonNull Context context, int resource, ArrayList<Cocktail> cocktail) {
        super(context, resource, cocktail);
        this.context = context;
        this.resource = resource;
        this.cocktail = cocktail;


    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,@NonNull ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null, true);

        }







        Cocktail cocktail = getItem(position);





       ImageView img = (ImageView) convertView.findViewById(R.id.eikona);


        Picasso.get().load(cocktail.getImage()).into(img);










       /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View toastView = getLayoutInflater().inflate(R.layout.toast, (ViewGroup)convertView.findViewById(R.id.toastLayout));
                Toast toast = new Toast(context);

                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(toastView);

                toast.show();
            }
        });
*/





        TextView name = (TextView) convertView.findViewById(R.id.onoma);
        name.setText(cocktail.getName());


        if (cocktail.getIngredient1() != "null") {
            TextView ingr1 = (TextView) convertView.findViewById(R.id.ingredient1);
            ingr1.setText("● "+cocktail.getIngredient1());

        }
        if (cocktail.getIngredient2() != "null") {
            TextView ingr2 = (TextView) convertView.findViewById(R.id.ingredient2);
            ingr2.setText("● "+cocktail.getIngredient2());

        }
        if (cocktail.getIngredient3() != "null") {
            TextView ingr3 = (TextView) convertView.findViewById(R.id.ingredient3);
            ingr3.setText("● "+cocktail.getIngredient3());

        }
        if (cocktail.getIngredient4() != "null") {
            TextView ingr4 = (TextView) convertView.findViewById(R.id.ingredient4);
            ingr4.setText("● "+cocktail.getIngredient4());

        }
        if (cocktail.getIngredient5() != "null") {
            TextView ingr5 = (TextView) convertView.findViewById(R.id.ingredient5);
            ingr5.setText("● "+cocktail.getIngredient5());

        }
        if (cocktail.getIngredient6() != "null") {
            TextView ingr6 = (TextView) convertView.findViewById(R.id.ingredient6);
            ingr6.setText("● "+cocktail.getIngredient6());

        }

        if (cocktail.getMeasure1() != "null") {
            TextView msr1 = (TextView) convertView.findViewById(R.id.measure1);
            msr1.setText(cocktail.getMeasure1());

        }
        if (cocktail.getMeasure2() != "null") {
            TextView msr2 = (TextView) convertView.findViewById(R.id.measure2);
            msr2.setText(cocktail.getMeasure2());

        }

        if (cocktail.getMeasure3() != "null") {
            TextView msr3 = (TextView) convertView.findViewById(R.id.measure3);
            msr3.setText(cocktail.getMeasure3());

        }

        if (cocktail.getMeasure4() != "null") {
            TextView msr4 = (TextView) convertView.findViewById(R.id.measure4);
            msr4.setText(cocktail.getMeasure4());

        }

        if (cocktail.getMeasure5() != "null") {
            TextView msr5 = (TextView) convertView.findViewById(R.id.measure5);
            msr5.setText(cocktail.getMeasure5());

        }

        if (cocktail.getMeasure6() != "null") {
            TextView msr6 = (TextView) convertView.findViewById(R.id.measure6);
            msr6.setText(cocktail.getMeasure6());

        }


        return convertView;
    }



    }

