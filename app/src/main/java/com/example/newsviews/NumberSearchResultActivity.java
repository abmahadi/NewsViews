package com.example.newsviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NumberSearchResultActivity extends AppCompatActivity {

    private TextView searchResultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_search_result);


        init();

    }

    private void init() {

        searchResultTV = findViewById(R.id.numberSearchResult_TV);
    }


    public void back(View view) {

        onBackPressed();
    }
}
