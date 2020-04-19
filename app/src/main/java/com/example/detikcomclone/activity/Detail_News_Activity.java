package com.example.detikcomclone.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.detikcomclone.R;
import com.squareup.picasso.Picasso;

public class Detail_News_Activity extends AppCompatActivity {

    private ImageView imgNews;
    private TextView titlenews, source_name, authorname, source_name_2, datenews, contentnews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__news_);
        init();
    }

    private void init() {
        imgNews = findViewById(R.id.image_news);
        titlenews = findViewById(R.id.txtNewsTitle);
        source_name = findViewById(R.id.source_name);
        authorname = findViewById(R.id.txtAuthor);
        source_name_2 = findViewById(R.id.source_names);
        datenews = findViewById(R.id.date_release);
        contentnews = findViewById(R.id.content_news);
        setFromIntent();
    }

    private void setFromIntent() {
        String imgnews = getIntent().getStringExtra("img_news");
        String title = getIntent().getStringExtra("description");
        String s_name = getIntent().getStringExtra("source_name");
        String a_name = getIntent().getStringExtra("author_name");
        String s_name_2 = getIntent().getStringExtra("source_name_2");
        String content = getIntent().getStringExtra("content_news");
        String date = getIntent().getStringExtra("date");

        Picasso.get().load(imgnews).into(imgNews);
        titlenews.setText(title);
        source_name.setText(s_name);
        authorname.setText(a_name);
        source_name_2.setText(s_name_2);
        datenews.setText(date);
        contentnews.setText(content);

    }
}
