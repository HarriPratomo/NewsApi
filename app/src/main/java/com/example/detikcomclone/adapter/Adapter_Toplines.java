package com.example.detikcomclone.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.detikcomclone.R;
import com.example.detikcomclone.activity.Detail_News_Activity;
import com.example.detikcomclone.model.headlines.NewsArticalItem;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter_Toplines extends RecyclerView.Adapter<Adapter_Toplines.ViewHolder> {

    private List<NewsArticalItem> listArticle;
    private Context context;

    public Adapter_Toplines(List<NewsArticalItem> listArticle, Context context) {
        this.listArticle = listArticle;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter_Toplines.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_headlinenews, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Toplines.ViewHolder holder, int position) {
        final NewsArticalItem item = listArticle.get(position);
        holder.textTitle.setText(item.getTitle());
        holder.textSource.setText(item.getSource().getName());
        holder.dateNews.setText(item.getPublishedAt().substring(0, 10) + "   " + item.getPublishedAt().substring(11, 16));
        Picasso.get()
                .load(item.getUrlToImage())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder_errors)
                .fit()
                .into(holder.imgNews);
        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Detail_News_Activity.class);
                intent.putExtra("img_news", item.getUrlToImage());
                intent.putExtra("source_name", item.getSource().getName());
                intent.putExtra("description", item.getDescription());
                intent.putExtra("author_name", item.getAuthor());
                intent.putExtra("source_name_2", item.getSource().getName());
                intent.putExtra("date", item.getPublishedAt().substring(0, 10) + " " + item.getPublishedAt().substring(11, 16));
                intent.putExtra("content_news", item.getContent());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listArticle.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitle;
        private TextView textSource;
        private ImageView imgNews;
        private TextView dateNews;
        private RelativeLayout row;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            row = itemView.findViewById(R.id.rowLayout);
            textTitle = itemView.findViewById(R.id.txttitleNews);
            textSource = itemView.findViewById(R.id.sourceData);
            dateNews = itemView.findViewById(R.id.newsDate);
            imgNews = itemView.findViewById(R.id.imageNews);
        }
    }
}
