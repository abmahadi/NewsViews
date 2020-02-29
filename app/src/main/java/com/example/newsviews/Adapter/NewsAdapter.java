package com.example.newsviews.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.renderscript.RenderScript;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsviews.MainActivity;
import com.example.newsviews.Model.HeadLine;
import com.example.newsviews.R;
import com.example.newsviews.Utils.TimeDateConverter;
import com.squareup.picasso.Picasso;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private  Activity activity;
    private HeadLine newsList = new HeadLine();

    private AlertDialog.Builder builder;

    public NewsAdapter(Activity activity, AlertDialog.Builder builder) {
        this.activity = activity;
        this.builder = builder;
    }

    public NewsAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_item,parent,false);
        return new  NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {


        Picasso.with(activity).load(newsList.getArticles().get(position).getUrlToImage()).fit().centerCrop()
                .placeholder(R.drawable.loading)
                .error(R.drawable.loading)
                .into(holder.newsImage);


        holder.title.setText(newsList.getArticles().get(position).getTitle());
        holder.description.setText(newsList.getArticles().get(position).getDescription());
        holder.author.setText("Author: " + newsList.getArticles().get(position).getAuthor());
        holder.source.setText("Source: " + newsList.getArticles().get(position).getSource().getName());
        holder.publishDate.setText(TimeDateConverter.DateFormat( newsList.getArticles().get(position).getPublishedAt()));
        holder.publishTime.setText(TimeDateConverter.DateToTimeFormat(newsList.getArticles().get(position).getPublishedAt()));




    }

    @Override
    public int getItemCount() {
        return newsList.getArticles().size();
    }

    public void setItem(HeadLine newsList) {
        this.newsList = newsList;
        notifyDataSetChanged();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        private  ImageView newsImage;
        private  TextView title;
        private  TextView author;
        private  TextView source;
        private  TextView publishDate;
        private  TextView description;
        private  TextView publishTime;


        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            newsImage = itemView.findViewById(R.id.newsImage_IV);
            title = itemView.findViewById(R.id.newsTitle_TV);
            author = itemView.findViewById(R.id.newsAuthor_TV);
            source = itemView.findViewById(R.id.newsSource_TV);
            publishDate = itemView.findViewById(R.id.newsPublishDate_TV);
            publishTime = itemView.findViewById(R.id.newsPublishTime_TV);
            description = itemView.findViewById(R.id.newsDescription_TV);



            //item click

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    builder.setMessage("Open this link")
                            .setPositiveButton("Default", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Intent intent = new Intent(Intent.ACTION_VIEW);
                                    intent.setData(Uri.parse(newsList.getArticles().get(getAdapterPosition()).getUrl()));
                                    activity.startActivity(intent);

                                }
                            }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            dialogInterface.dismiss();

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();



                }
            });

        }
    }
}
