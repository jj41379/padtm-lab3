package com.example.lab3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.icu.text.RelativeDateTimeFormatter;
import android.os.Bundle;

import com.example.lab3.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.provider.MediaStore;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;

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
                Toast.makeText(getApplicationContext(), "Kliknięto przycisk FAB", Toast.LENGTH_SHORT).show();
                Intent intencja = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intencja, REQUEST_IMAGE_CAPTURE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        ConstraintLayout lay = (ConstraintLayout) findViewById(R.id.cont);
        lay.setBackground(new BitmapDrawable(getResources(), imageBitmap));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onClickButton(View view) {
        // Inflate the menu; this adds items to the action bar if it is present.
        Toast.makeText(getApplicationContext(), "Kliknięto przycisk Button", Toast.LENGTH_SHORT).show();
        Intent intencja = new Intent(this, LoginActivity.class);
        startActivity(intencja);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id) {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "Kliknięto przycisk " + R.id.action_settings, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item1:
                Toast.makeText(getApplicationContext(), "Kliknięto przycisk " + R.id.item1, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(), "Kliknięto przycisk " + R.id.item2, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(getApplicationContext(), "Kliknięto przycisk " + R.id.item3, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4:
                Toast.makeText(getApplicationContext(), "Kliknięto przycisk " + R.id.item4, Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void losujIkone(View view) {

        int rand = new Random().nextInt() % 10;
        ImageButton ikona = (ImageButton) view;

        switch (rand) {
            case 0:
                ikona.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_media_play, getTheme()));
                break;
            case 1:
                ikona.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_btn_speak_now, getTheme()));
                break;
            case 2:
                ikona.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_delete, getTheme()));
                break;
            case 3:
                ikona.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_dialog_alert, getTheme()));
                break;
            case 4:
                ikona.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_dialog_dialer, getTheme()));
                break;
            case 5:
                ikona.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_dialog_email, getTheme()));
                break;
            case 6:
                ikona.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_dialog_info, getTheme()));
                break;
            case 7:
                ikona.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_dialog_map, getTheme()));
                break;
            case 8:
                ikona.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_input_add, getTheme()));
                break;
            case 9:
                ikona.setImageDrawable(getResources().getDrawable(R.drawable.obrazek, getTheme()));
                break;
        }

    }
}
