package com.example.tutoimage;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
Button b1;
ImageView imageView;
ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
     b1.findViewById(R.id.button);
     imageView.findViewById(R.id.imageView);
     b1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
new DownloadImage().execute();
         }
     });
    }
    private class DownloadImage extends AsyncTask<String,Void, Bitmap>{
        @Override
        protected void onPreExecute() {
            pd=new ProgressDialog(MainActivity.this);
            pd.setTitle("Please wait...");
            pd.setCancelable(false);
            pd.setIndeterminate(false);
            pd.setMessage("Downloading");
            pd.show();
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bitmap=null;
            try{
                InputStream inputStream= new java.net.URL("e http://chezwarrenetdeclan.c.h.pic.centerblog.net/fonds-ecran-paysages-coucher-soleil-big.jpg").openStream();
                bitmap= BitmapFactory.decodeStream(inputStream);
            } catch (Exception e){e.printStackTrace();}
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            pd.dismiss();
            imageView.setImageBitmap(bitmap);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
