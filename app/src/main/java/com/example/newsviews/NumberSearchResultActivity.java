package com.example.newsviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NumberSearchResultActivity extends AppCompatActivity {

    private TextView searchResultTV;
    private ImageView backPress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_search_result);


        init();

        String numberData = getIntent().getStringExtra("NumberResult");

        searchResultTV.setText(numberData);

//        backPress.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(NumberSearchResultActivity.this,MainActivity.class));
//                finish();
//            }
//        });



    }

    private void init() {

        searchResultTV = findViewById(R.id.numberSearchResult_TV);
        backPress = findViewById(R.id.nsr_back_IV);
    }


    public void back(View view) {

        onBackPressed();


    }
}
