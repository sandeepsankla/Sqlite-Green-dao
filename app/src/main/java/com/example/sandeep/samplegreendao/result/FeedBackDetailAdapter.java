package com.example.sandeep.samplegreendao.result;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sandeep.samplegreendao.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sandeep on 11/9/2016.
 */

public class FeedBackDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private LayoutInflater inflater;
    private Context context;

    public FeedBackDetailAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FeedBackDetailViewHolder(inflater.inflate(R.layout.feedback_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FeedBackDetailViewHolder viewHolder = (FeedBackDetailViewHolder) holder;
        viewHolder.studentNameText.setText("");
        viewHolder.teacherNameText.setText("");
        viewHolder.ratingText.setText("");
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class  FeedBackDetailViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.student_name)
        TextView studentNameText;
        @Bind(R.id.teacher_name)
        TextView teacherNameText;
        @Bind(R.id.rating_text)
        TextView ratingText;

        public FeedBackDetailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
