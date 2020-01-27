package com.example.saibabacharitre;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    Context mContext;
    List<CharitreContents> mData;
    private OnItemClickListener mListener;


    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener = listener;
    }

//    public RecyclerViewAdapter(Context mContext,List<CharitreContents> mData) {
//        this.mContext = mContext;
//        this.mData = mData;
//    }

    public RecyclerViewAdapter(List<CharitreContents> mData) {
//        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        final View v;
//        v = LayoutInflater.from(mContext).inflate(R.layout.charitre_layout_design,parent,false);
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.charitre_layout_design,parent,false);


        final MyViewHolder vHolder = new MyViewHolder(v);

//        final MyViewHolder vHolder = new MyViewHolder(v, mListener);

//        Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.slidedown);
//        v.startAnimation(animation);







//        vHolder.charitrelayoutdesignid.setOnClickListener(new View.OnClickListener()
//        {
//            //vHolder.breed_item_grid_id.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//
//                Intent intent = new Intent(view.getContext(),Chapter1.class);
//                view.getContext().startActivity(intent);
//
//            }
//        });




        return vHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.charitrechapternumber.setText(mData.get(position).getChapterNumber());
        holder.charitreName.setText(mData.get(position).getChapterName());
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        private LinearLayout charitrelayoutdesignid;
        private TextView charitrechapternumber;
        private TextView charitreName;




        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            charitrelayoutdesignid = (LinearLayout)itemView.findViewById(R.id.charitrelayoutdesignid);
            charitrechapternumber = (TextView)itemView.findViewById(R.id.chapternumber);
            charitreName = (TextView)itemView.findViewById(R.id.charitrname);



//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (listener != null)
//                    {
//                        int position = getAdapterPosition();
//                        if (position != RecyclerView.NO_POSITION)
//                        {
//                            listener.onItemClick(position);
//                        }
//                    }
//                }
//            });

        }







//        public MyViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
//            super(itemView);
//
//
//            charitrelayoutdesignid = (LinearLayout)itemView.findViewById(R.id.charitrelayoutdesignid);
//            charitrechapternumber = (TextView)itemView.findViewById(R.id.chapternumber);
//            charitreName = (TextView)itemView.findViewById(R.id.charitrname);
//
//
//
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (listener != null)
//                    {
//                        int position = getAdapterPosition();
//                        if (position != RecyclerView.NO_POSITION)
//                        {
//                            listener.onItemClick(position);
//                        }
//                    }
//                }
//            });
//
//        }
    }
}
