package com.example.saibabacharitre;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapterAudio extends RecyclerView.Adapter<RecyclerViewAdapterAudio.MyViewHolder> {


    Context mContext1;
    List<CharitreAudioContents> mData1;

    private RecyclerViewAdapterAudio.OnItemClickListener mListener;


    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(RecyclerViewAdapterAudio.OnItemClickListener listener)
    {
        mListener = listener;
    }




//    public RecyclerViewAdapterAudio(Context mContext1, List<CharitreAudioContents> mData1) {
//        this.mContext1 = mContext1;
//        this.mData1 = mData1;
//    }

    public RecyclerViewAdapterAudio(List<CharitreAudioContents> mData1) {
//        this.mContext1 = mContext1;
        this.mData1 = mData1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        final View v;
//        v = LayoutInflater.from(mContext).inflate(R.layout.charitre_layout_design,parent,false);
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.charitre_audio_layout_design,parent,false);

        final MyViewHolder vHolder = new MyViewHolder(v);

//        Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.slidedown);
//        v.startAnimation(animation);







//        vHolder.charitreaudiolayoutdesignid.setOnClickListener(new View.OnClickListener()
//        {
//            //vHolder.breed_item_grid_id.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//
//                Intent intent = new Intent(view.getContext(),Chapter1audio.class);
//                view.getContext().startActivity(intent);
//
////                TextView dialogue_breedname_tv = (TextView)dialog.findViewById(R.id.dialoguebreedname);
////                TextView dialogue_breedcost_tv = (TextView)dialog.findViewById(R.id.dialoguecost);
////                ImageView dialogue_breedhen_img = (ImageView) dialog.findViewById(R.id.dialoguebreedhenimg);
////
////
////                dialogue_breedname_tv.setText(mData.get(vHolder.getAdapterPosition()).getBreedName());
////                dialogue_breedcost_tv.setText(mData.get(vHolder.getAdapterPosition()).getPrice());
////                dialogue_breedhen_img.setImageResource(mData.get(vHolder.getAdapterPosition()).getPhoto());
////                dialog.show();
////
////                if (dialog.isShowing())
////                {
////                    chikenirrodbuy = dialog.findViewById(R.id.chikenirrodbuy);
////                    wishlistbtn = dialog.findViewById(R.id.wishlistbtn);
////
////                    wishlistbtn.setOnClickListener(new View.OnClickListener() {
////                        @Override
////                        public void onClick(View view) {
////                            Toast.makeText(mContext,"Add this to your Wish List",Toast.LENGTH_LONG).show();
////                        }
////                    });
////
////
////
////                    chikenirrodbuy.setOnClickListener(new View.OnClickListener() {
////                        @Override
////                        public void onClick(View view) {
////                            Intent intent = new Intent(view.getContext(),UserLoginOrRegisterDialogue.class);
////                            view.getContext().startActivity(intent);
////                        }
////                    });
////
////
////                }
//
//            }
//
//
//
////            private void openuserinfodialogue()
////            {
////                Dialog dialog1;
////                dialog1 = new Dialog(mContext);
////                dialog1.setContentView(R.layout.user_login_signin_dialogue);
////                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
////                dialog1.show();
////            }
//        });

        return vHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.charitrechapternumbera.setText(mData1.get(position).getChapterNumber1());
        holder.charitreNamea.setText(mData1.get(position).getChapterName1());
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return mData1.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        private LinearLayout charitreaudiolayoutdesignid;
        private TextView charitrechapternumbera;
        private TextView charitreNamea;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            charitreaudiolayoutdesignid = (LinearLayout)itemView.findViewById(R.id.charitreaudiolayoutdesignid);
            charitrechapternumbera = (TextView)itemView.findViewById(R.id.chapternumbera);
            charitreNamea = (TextView)itemView.findViewById(R.id.charitrnamea);

        }
    }
}

