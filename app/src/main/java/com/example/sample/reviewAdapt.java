package com.example.sample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class reviewAdapt extends RecyclerView.Adapter<reviewAdapt.ViewHolder> {

    private Context mContext;
    private List<reviewModel> reviewList;
    private int limit;


    public reviewAdapt(Context mContext, List<reviewModel> reviewList, int limit) {
        this.mContext = mContext;
        this.reviewList = reviewList;
        this.limit = limit;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.review_design, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        reviewModel model = reviewList.get(position);
        Log.d("TAG", "onBindViewHolder_Limit: " + limit);
        Log.d("TAG", "onBindViewHolder_Position_Is_InLimit: " + position);
        holder.textViewName.setText(model.getName());
        holder.textViewDate.setText(model.getDate());
        holder.ratingBarRecycle.setRating(model.getRatingBar());
        holder.textViewDetails.setText(model.getDetails());
        holder.imageViewRecycle.setImageResource(model.getImg());
    }



    @Override
    public int getItemCount() {

        return limit;

    }


class ViewHolder extends RecyclerView.ViewHolder {
    TextView textViewName, textViewDate, textViewDetails;
    RatingBar ratingBarRecycle;
    ImageView imageViewRecycle;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        textViewName = itemView.findViewById(R.id.name_review);
        textViewDate = itemView.findViewById(R.id.date_review);
        textViewDetails = itemView.findViewById(R.id.details_review);
        ratingBarRecycle = itemView.findViewById(R.id.review_ratingsBar);
        imageViewRecycle = itemView.findViewById(R.id.profile_image);


    }
}

}

