/**
 * This class contains methods for the welcome screen of the web view app
 * MAD-E5
 *
 * @author Pratyush Kumar (github.com/pratyushgta)
 */

package com.example.mad_e4_webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView title, desc;
    GridView gridView;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.home_title);
        desc = findViewById(R.id.home_desc);
        gridView = findViewById(R.id.imageGridView);
        next = findViewById(R.id.nxtBtn);

        title.setText(R.string.home_title);
        desc.setText(R.string.home_desc);
        gridView.setAdapter(new ImageAdapter(this));

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextPage = new Intent(MainActivity.this,MonkeOnTheWeb.class);
                startActivity(nextPage);
            }
        });
    }
}

