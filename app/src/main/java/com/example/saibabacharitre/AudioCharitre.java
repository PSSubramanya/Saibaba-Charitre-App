package com.example.saibabacharitre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AudioCharitre extends AppCompatActivity {


    private RecyclerView myrecyclerView1;

    Context context1;

    private List<CharitreAudioContents> lstContact1;


    private ListView AudiolistView;


    String[] mChapternumbera = {"Chapter 1","Chapter 2","Chapter 3","Chapter 4","Chapter 5",
            "Chapter 6","Chapter 7","Chapter 8","Chapter 9","Chapter 10",
            "Chapter 11","Chapter 12"};


    String[] mChapternamea = {"The wondrous Saint grinding wheat - Obeisances - The story of grinding wheat and its philosophical significance",
            "Object of writing the work - Incapacity and boldness in the undertaking - Hot discussion - Conferring significant and prophetic title of 'Hemadpant' - Necessity of a Guru",
            "Sai Baba's sanction and promise - Assignment of work to the devotees - Baba's stories as beacon-light - His motherly love - Rohila's story - His sweet and nectar like words",
            "Mission of the saints - Shirdi a Holy Tirth - Personality of Sai Baba - Dictum of Goulibua - Appearance of Vitthal - Kshirsagar's story - Das Ganu's bath in Prayag - Immaculate conception of Sai Baba and His first advent in Shirdi - Three Wadas",
            "Baba's return with Chand Patil's marriage party -Welcomed and addressed as 'Sai' - Contact with other saints - His attire and daily routine - The story of the Padukas - Wrestling bout with Mohiddin and change in life - Turning water into oil - The Pseudo - Guru Javhar All",
            "Efficacy of the touch of the Guru's hand - Ram Navami Festival - Its origin, transformation etc. - Repairs to the Masjid",
            "Wonderful Incarnation - Behaviour of Sai Baba - His vogic practices - His all-pervasiveness and mercy - Leper devotee's service - Master Khaparde's plague case - Going to Pandharpur",
            "Importance of human birth - Sai Baba begging food - Baijabai’s service - Sai Baba's dormitory - His affection for Khushalchand",
            "Effect of compliance and non-compliance with Baba's orders at the time of taking leave - A few instances -Mendicancy and its necessity - Devotees' (Tarkhad family's) experiences - Baba fed sumptuously",
            "Sai Baba's mode of life - His sleeping plank - His stay in Shirdi - His teachings - His humility - Nanavali The easiest path",
            "Sai as Sagun Brahma - Dr. Pandit's worship - Haji Siddik Falke - Control over the elements",
            "Sai Leelas - Experiences of (1) Kaka Mahajani (2) Dhumal Pleader (3) Mrs. Nimonkar (4) Mule Shastri (5) A Doctor "};


    Dialog dialog;
    Dialog dialog1;

    ImageView audiodownloadbtn, downloadingicondialog;

    private Button downloadservicebtn, cancelbtndialog, cancelbtndialog2;

    //            dialog = new Dialog(Chapter1audio.this);
    //            dialog.setContentView(R.layout.download_dialog);
    //            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    //            dialog.show();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_charitre);


//        final Animation animation = AnimationUtils.loadAnimation(AudioCharitre.this,R.anim.slidedown);


        AudiolistView = (ListView)findViewById(R.id.charitreaudioListViewa); // Listview started
//        audiodownloadbtn = (ImageView)findViewById(R.id.audiodownloadbtn);


//        MyAdapter mAdapter = new MyAdapter(this,mChapternumber,mChaptername);
        AudioCharitre.MyAdaptera mAdapterb = new AudioCharitre.MyAdaptera(this,mChapternumbera,mChapternamea);

        AudiolistView.setAdapter(mAdapterb);

//        audiodownloadbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog = new Dialog(AudioCharitre.this);
//                dialog.setContentView(R.layout.download_dialog);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//            }
//        });

        AudiolistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
//                String item = PDFlistView.getItemAtPosition(i).toString();


//                String item = PDFlistView.getItemAtPosition(i).toString();
//
//                Intent intent = new Intent(getApplicationContext(),Chapter1.class);
////                intent.putExtra("pdfFileName",item);
//                intent.putExtra("pdfFileName",item);
//                startActivity(intent);


                audiodownloadbtn = view.findViewById(R.id.audiodownloadbtn);

                audiodownloadbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog = new Dialog(AudioCharitre.this);
                        dialog.setContentView(R.layout.download_dialog);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();

                        if (dialog.isShowing())
                        {
                            downloadservicebtn = dialog.findViewById(R.id.downloadservicebtn);
                            cancelbtndialog = dialog.findViewById(R.id.cancelbtndialog);


                            downloadservicebtn.setOnClickListener(new View.OnClickListener() {
                                @SuppressLint("ResourceType")
                                @Override
                                public void onClick(View view) {
                                    dialog.dismiss();
                                    dialog1 = new Dialog(AudioCharitre.this);
                                    dialog1.setContentView(R.layout.downloading_dialog);
                                    dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                    dialog1.show();

                                    downloadingicondialog = view.findViewById(R.id.downloadingicondialog);

//                                    Animation animation = AnimationUtils.loadAnimation(AudioCharitre.this,R.anim.slidedown);
//                                    downloadingicondialog.startAnimation(animation);


//                                    IVcon = (ImageView)findViewById(R.id.IVcon);
//                                    downloadingicondialog.setBackgroundResource(R.anim.slidedown);
//
//                                    final AnimationDrawable animcon = (AnimationDrawable)downloadingicondialog.getDrawable();
//                                    dialog.setCancelable(true);
//
//                                    dialog.setOnShowListener(new DialogInterface.OnShowListener() {
//                                        @Override
//                                        public void onShow(DialogInterface dialog) {
//                                            animcon.start();
//                                        }
//                                    });
//                                    dialog.show();



//                                    for (int i =0; i < 10; i++)
//                                    {
//                                        Animation animation = AnimationUtils.loadAnimation(AudioCharitre.this,R.anim.slidedown);
//
//                                        downloadingicondialog.startAnimation(animation);
//                                    }

                                }
                            });
                        }
                    }
                });



                String ii = String.valueOf(i);
                Intent intent = new Intent(getApplicationContext(),Chapter1audio.class);
//              intent.putExtra("pdfFileName",item);
//              intent.putExtra("pdfFileName",item);
                intent.putExtra("audioFileName",ii);
                startActivity(intent);
            }
        });

//        myrecyclerView1 = (RecyclerView)findViewById(R.id.charitreRecyclerView1);
//        myrecyclerView1.setHasFixedSize(true);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(context1);
//        myrecyclerView1.setLayoutManager(layoutManager);
//
////        RecyclerViewAdapter adapter = new RecyclerViewAdapter(context,lstContact);
//        RecyclerViewAdapterAudio adapter = new RecyclerViewAdapterAudio(lstContact1);
//
//        initializeData1();
//        initializeAdapter1();

    }


    class MyAdaptera extends ArrayAdapter<String>
    {
        Context context;
        String rChapternumbera[];
        String rChapternamea[];

        MyAdaptera (Context c, String Chapternumbera[], String Chapternamea[])
        {
            super(c, R.layout.charitre_audio_layout_design,R.id.chapternumbera,Chapternamea);
            this.context = c;
            this.rChapternumbera = Chapternumbera;
            this.rChapternamea = Chapternamea;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowviewa = layoutInflater.inflate(R.layout.charitre_audio_layout_design,parent,false);
//            ImageView images = rowview.findViewById(R.id.saibabalistviewicon);
            TextView myChapternumber = rowviewa.findViewById(R.id.chapternumbera);
            TextView myChaptername = rowviewa.findViewById(R.id.charitrnamea);


            myChapternumber.setText(rChapternumbera[position]);
            myChaptername.setText(rChapternamea[position]);


//            return super.getView(position, convertView, parent);
            return rowviewa;

        }
    }


//    private void initializeData1()
//    {
//        lstContact1 = new ArrayList<>();
//        lstContact1.add(new CharitreAudioContents("Chapter 1","The wondrous Saint grinding wheat - Obeisances - The story of grinding wheat and its philosophical significance "));
//        lstContact1.add(new CharitreAudioContents("Chapter 2","Object of writing the work - Incapacity and boldness in the undertaking - Hot discussion - Conferring significant and prophetic title of 'Hemadpant' - Necessity of a Guru "));
//        lstContact1.add(new CharitreAudioContents("Chapter 3","Sai Baba's sanction and promise - Assignment of work to the devotees - Baba's stories as beacon-light - His motherly love - Rohila's story - His sweet and nectar like words "));
//        lstContact1.add(new CharitreAudioContents("Chapter 4","Mission of the saints - Shirdi a Holy Tirth - Personality of Sai Baba - Dictum of Goulibua - Appearance of Vitthal - Kshirsagar's story - Das Ganu's bath in Prayag - Immaculate conception of Sai Baba and His first advent in Shirdi - Three Wadas"));
//        lstContact1.add(new CharitreAudioContents("Chapter 5","Baba's return with Chand Patil's marriage party -Welcomed and addressed as 'Sai' - Contact with other saints - His attire and daily routine - The story of the Padukas - Wrestling bout with Mohiddin and change in life - Turning water into oil - The Pseudo - Guru Javhar All"));
//        lstContact1.add(new CharitreAudioContents("Chapter 6","Efficacy of the touch of the Guru's hand - Ram Navami Festival - Its origin, transformation etc. - Repairs to the Masjid "));
//        lstContact1.add(new CharitreAudioContents("Chapter 7","Wonderful Incarnation - Behaviour of Sai Baba - His vogic practices - His all-pervasiveness and mercy - Leper devotee's service - Master Khaparde's plague case - Going to Pandharpur"));
//        lstContact1.add(new CharitreAudioContents("Chapter 8","Importance of human birth - Sai Baba begging food - Baijabai’s service - Sai Baba's dormitory - His affection for Khushalchand "));
//        lstContact1.add(new CharitreAudioContents("Chapter 9","Effect of compliance and non-compliance with Baba's orders at the time of taking leave - A few instances -Mendicancy and its necessity - Devotees' (Tarkhad family's) experiences - Baba fed sumptuously"));
//        lstContact1.add(new CharitreAudioContents("Chapter 10","Sai Baba's mode of life - His sleeping plank - His stay in Shirdi - His teachings - His humility - Nanavali The easiest path "));
//        lstContact1.add(new CharitreAudioContents("Chapter 11","Sai as Sagun Brahma - Dr. Pandit's worship - Haji Siddik Falke - Control over the elements "));
//        lstContact1.add(new CharitreAudioContents("Chapter 12","Sai Leelas - Experiences of (1) Kaka Mahajani (2) Dhumal Pleader (3) Mrs. Nimonkar (4) Mule Shastri (5) A Doctor "));
//    }
//
//
//    private void initializeAdapter1()
//    {
////        RecyclerViewAdapter adapter = new RecyclerViewAdapter(context,lstContact);
//        RecyclerViewAdapterAudio adapter = new RecyclerViewAdapterAudio(lstContact1);
//        myrecyclerView1.setAdapter(adapter);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.languagepageaudio_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.languagechangeid);
        {
//            Toast.makeText(ChoicePage.this, "Click on the icon to choose!", Toast.LENGTH_LONG).show();
//            Intent intent = new Intent(OptionPage.this,AboutUsPage.class);
//            startActivity(intent);
        }

//        if (id == R.id.appinfoid);
//        {
////            Toast.makeText(ChoicePage.this, "Click on the icon to choose!", Toast.LENGTH_LONG).show();
////            Intent intent = new Intent(OptionPage.this,AboutAppPage.class);
////            startActivity(intent);
//        }

        return super.onOptionsItemSelected(item);
    }
}
