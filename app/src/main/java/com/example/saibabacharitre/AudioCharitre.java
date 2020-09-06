package com.example.saibabacharitre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class AudioCharitre extends AppCompatActivity
{




    private static final int PERMISSION_STORAGE_CODE = 1000;
    private RecyclerView myrecyclerView1;

    Context context1;

    private List<CharitreAudioContents> lstContact1;


    private ListView AudiolistView;

    private DownloadManager downloadManager;

    public ProgressBar progressbaraudiodownload;
    private int progressStatus = 0;
    private TextView progressText;
    private Handler handler = new Handler();

    private TextView chapternumberdialog2;

    int inum = 0;
    String file_url = "";




    String[] mChapternumbera = {"Aarati Song","Chapter 1","Chapter 2","Chapter 3","Chapter 4","Chapter 5",
            "Chapter 6","Chapter 7","Chapter 8","Chapter 9","Chapter 10",
            "Chapter 11","Chapter 12","Chapter 13","Chapter 14","Chapter 15","Chapter 16-17","Chapter 18-19","Chapter 20",
            "Chapter 21", "Chapter 22", "Chapter 23", "Chapter 24", "Chapter 25", "Chapter 26", "Chapter 27", "Chapter 28", "Chapter 29", "Chapter 30"};


    String[] mChapternamea = {"This is Saibaba Aarati song that is daily sung in Shieadi while worshipping Sadguru Saibaba","The wondrous Saint grinding wheat - Obeisances - The story of grinding wheat and its philosophical significance",
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
            "Sai Leelas - Experiences of (1) Kaka Mahajani (2) Dhumal Pleader (3) Mrs. Nimonkar (4) Mule Shastri (5) A Doctor ",
            "More Sai Leelas - Diseases cured (1) Bhimaji Patil (2) Bala Shimpi Bapusaheb Buti (4) Alandi Swami (5) Kaka Mahajani (6) Dattopant of Harda ",
            "Ratanji Wadia of Nanded - Saint Moulisaheb - Dakshina mimansa ",
            "Naradiya Kirtan Paddhati - Mr. Cholkar's Sugarless tea - Two Lizards",
            "Quick Brahma Gnyan",
            "How Hemadpant was accepted and blessed - Stories of Mr. Sathe and Mrs. Deshmukh - Encouraging good thoughts to fruition - Variety in Upadesh - Teachings regarding slander and remuneration for labour",
            "Das Ganu's problem solved by Kaka's maid-servant ",
            "Stories of (1) V.H. Thakur (2) Anantrao Patankar and (3) Pandharpur pleader",
            "Rescues from serpent-bites (1) Balasahcb Mirikar (2) Bapusaheb Buti(3) Amir Shakkar (4) Hemadpant - Baba's opinion regarding killing of serpents ",
            "Yoga and onion - Shama cured of snake-bite - Cholera ordinances broken - Ordeal of Guru - bhakti ",
            "Baba's wit and humour - Chana Leela - (1) Hemadpant (2) Sudama(3) Anna Chinchanikar vs. Maushibai",
            "Damu Anna Kasar of Ahmednagar (1) Speculations (2) Amraleela ",
            "Stories of (1) Bhakta Pant (2) Harishchandra Pitale (3) Gopal Ambadekar",
            "Favour shown by giving Bhagwat and Vishnu Sahastranaam - Dixit's Vitthal vision - Geeta-Rahasya -Khapardes",
            "Sparrows drawn to Shirdi (1) Lakhshmichand (2) Burhanpore lady(3) Megha",
            "Stories of (1) Chennai's Bhajani Mela (2) Tendulkars (father and son)(3) Dr. Captain Hate (4) Waman Narvekar",
            "Drawn to Shirdi (1) Kakaji Vaidya of Vani (2) Ramlal Punjabi of Mumbai ",
    };


    Dialog dialog;
    Dialog dialog1;

    ImageView audiodownloadbtn, downloadingicondialog;

    private Button downloadservicebtn, cancelbtndialog, cancelbtndialog2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_charitre);



        AudiolistView = (ListView)findViewById(R.id.charitreaudioListViewa); // Listview started

        downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);

        AudioCharitre.MyAdaptera mAdapterb = new AudioCharitre.MyAdaptera(this,mChapternumbera,mChapternamea);

        AudiolistView.setAdapter(mAdapterb);


        if (haveNetwork())
        {




            AudiolistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l)
                {

                            final String ii = String.valueOf(i);
                            inum = i;
                            Intent intent = new Intent(getApplicationContext(),Chapter1audio.class);
                            intent.putExtra("audioFileName",ii);
                            startActivity(intent);

                            audiodownloadbtn = view.findViewById(R.id.audiodownloadbtn);

                            audiodownloadbtn.setOnClickListener(new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View view) {

                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                                        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                                                PackageManager.PERMISSION_DENIED){
                                            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};

                                            requestPermissions(permissions, PERMISSION_STORAGE_CODE);

                                        }
                                        else {
                                            startDownloading(inum);
//                                                startDownloading();
                                        }
                                    }
                                    else {
                                        startDownloading(inum);
//                                            startDownloading();
                                    }
                                }
                            });
                }
            });
        }

        else if (!haveNetwork())
        {
            AudiolistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l)
                {


                    dialog = new Dialog(AudioCharitre.this);
                    dialog.setContentView(R.layout.download_dialog);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();

                    if (dialog.isShowing())
                    {

                    }

                    audiodownloadbtn = view.findViewById(R.id.audiodownloadbtn);

                    audiodownloadbtn.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {

                            dialog = new Dialog(AudioCharitre.this);
                            dialog.setContentView(R.layout.downloading_dialog);
                            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                            dialog.show();


                            //dialog for downloading
                            if (dialog.isShowing())
                            {
//                                progressbaraudiodownload = (ProgressBar)dialog.findViewById(R.id.progressbaraudiodownload);
//                                String urlDownloadLink = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_one.mp3?alt=media&token=48e38f0d-3b1c-4bf4-bd9c-320e950520ed";
//                                String downloadAudioPath = "/storage/emulated/0/Music/Saibaba_chapter1.mp3";
//                                DownloadFile downloadAudioFile = new DownloadFile();
//                                downloadAudioFile.execute(urlDownloadLink, downloadAudioPath);


//                                audioText.setText("");
                            }


                        }
                    });
                }
            });

            Toast.makeText(AudioCharitre.this, "No Network", Toast.LENGTH_SHORT).show();
        }




    }

    private void startDownloading(int inuma) {

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse("https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/aarati_saibaba_song.mp3?alt=media&token=0ba95ca5-0d18-4ca8-80f3-c032222dfded"));

//        DownloadManager.Request request;




        //TRY BUILDING AN OPTIMIZED WAY OF CHECKING THESE CONDITIONS, PROBABY STORE URLs IN A ITERATIVE STRTUCTURED STRING FORMAT AND USE FOR LOOP INSTEAD OF IF CONDITIONS...
        if (inuma == 0)
        {

//            file_url = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/aarati_saibaba_song.mp3?alt=media&token=0189cbb3-c176-48a8-839f-adc19fc0ae25";
            file_url = "https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/aarati_saibaba_song.mp3?alt=media&token=0ba95ca5-0d18-4ca8-80f3-c032222dfded";
            request = new DownloadManager.Request(Uri.parse(file_url));
            request.setTitle("SaiCaritre Aarati Song");

            new DownloadFileFromURL().execute(file_url);
        }

        if (inuma == 1)
        {

//            file_url = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_one.mp3?alt=media&token=48e38f0d-3b1c-4bf4-bd9c-320e950520ed";
            file_url = "https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_one.mp3?alt=media&token=bf7de0ff-4088-46e6-a62a-54fff46fd84f";
            request = new DownloadManager.Request(Uri.parse(file_url));
            request.setTitle("SaiCaritre Chapter 1");

            new DownloadFileFromURL().execute(file_url);
        }

        if (inuma == 2)
        {
//            file_url = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_two.mp3?alt=media&token=0da9fc93-69ca-48c7-b141-79b673ab972e";
            file_url = "https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_two.mp3?alt=media&token=f52b2204-433e-4113-83aa-847505428e93";
            request = new DownloadManager.Request(Uri.parse(file_url));
            request.setTitle("SaiCaritre Chapter 2");

            new DownloadFileFromURL().execute(file_url);
        }

        if (inuma == 3)
        {

//            file_url = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_three.mp3?alt=media&token=73d07986-ff5d-4ad1-b19b-f7f07a6c16b1";
            file_url = "https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_three.mp3?alt=media&token=9076dd99-6a39-4bf3-83e0-812e900fd045";
            request = new DownloadManager.Request(Uri.parse(file_url));
            request.setTitle("SaiCaritre Chapter 3");

            new DownloadFileFromURL().execute(file_url);
        }

        if (inuma == 4)
        {
//            file_url = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_four.mp3.mp3?alt=media&token=895335d1-0983-438d-a73a-0cf3bf986575";
            file_url = "https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_four.mp3.mp3?alt=media&token=267a4206-3a9d-41f7-a22b-462f4f56e745";
            request = new DownloadManager.Request(Uri.parse(file_url));
            request.setTitle("SaiCaritre Chapter 4");

            new DownloadFileFromURL().execute(file_url);
        }

        if (inuma == 5)
        {
//            file_url = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_five.mp3.mp3?alt=media&token=d1a155c6-8463-4127-981e-d98bc2e11368";
            file_url = "https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_five.mp3.mp3?alt=media&token=c30b4a48-d98a-47b2-9b5c-6c4c3556dd68";
            request = new DownloadManager.Request(Uri.parse(file_url));
            request.setTitle("SaiCaritre Chapter 5");

            new DownloadFileFromURL().execute(file_url);
        }

        if (inuma == 6)
        {
//            file_url = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_six.mp3.mp3?alt=media&token=cc2d0be4-9418-470f-a229-9112f04c7379";
            file_url = "https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_six.mp3.mp3?alt=media&token=48d74d7c-5cf2-40e1-8157-fa4c66d74943";
            request = new DownloadManager.Request(Uri.parse(file_url));
            request.setTitle("SaiCaritre Chapter 6");

            new DownloadFileFromURL().execute(file_url);
        }

        if (inuma == 7)
        {
//            file_url = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_seven.mp3.mp3?alt=media&token=22dca863-c0f3-4392-8f57-d82051dab6bf";
            file_url = "https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_seven.mp3.mp3?alt=media&token=3f8f592b-ce91-46b4-96d7-65e68bc03984";
            request = new DownloadManager.Request(Uri.parse(file_url));
            request.setTitle("SaiCaritre Chapter 7");

            new DownloadFileFromURL().execute(file_url);
        }

        if (inuma == 8)
        {
//            file_url = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_eight.mp3.mp3?alt=media&token=61c764ff-0467-43db-b953-5925cd8ef727";
            file_url = "https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_eight.mp3.mp3?alt=media&token=e5e29c7e-a217-471a-831d-225a2e378228";
            request = new DownloadManager.Request(Uri.parse(file_url));
            request.setTitle("SaiCaritre Chapter 8");

            new DownloadFileFromURL().execute(file_url);
        }

        if (inuma == 9)
        {
//            file_url = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_nine.mp3?alt=media&token=feae26fc-9738-458a-adb6-17ae0c761d03";
            file_url = "https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_nine.mp3?alt=media&token=bdb8d8b5-6a55-4cb7-a4e4-24338c7b8844";
            request = new DownloadManager.Request(Uri.parse(file_url));
            request.setTitle("SaiCaritre Chapter 9");

            new DownloadFileFromURL().execute(file_url);
        }

        if (inuma == 10)
        {
//            file_url = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_ten.mp3?alt=media&token=5a925527-e396-4741-9ebc-fa5004bd5f9b";
            file_url = "https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_ten.mp3?alt=media&token=618d74e2-3be8-4f1c-8459-5b8ec5d605ed";
            request = new DownloadManager.Request(Uri.parse(file_url));
            request.setTitle("SaiCaritre Chapter 10");

            new DownloadFileFromURL().execute(file_url);
        }

        if (inuma == 11)
        {
//            file_url = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_eleven.mp3?alt=media&token=022e8b3a-1dba-4b59-a151-3c0481337369";
            file_url = "https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_eleven.mp3?alt=media&token=b1bc690d-1e9d-4826-a307-a18f070b3df8";
            request = new DownloadManager.Request(Uri.parse(file_url));
            request.setTitle("SaiCaritre Chapter 11");

            new DownloadFileFromURL().execute(file_url);
        }

        if (inuma == 12)
        {
//            file_url = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_twelve.mp3?alt=media&token=2f826b65-bbea-4f12-bbb9-056f6340303a";
            file_url = "https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_twelve.mp3?alt=media&token=d04ea8dd-47bc-4026-9119-888e99a22af2";
            request = new DownloadManager.Request(Uri.parse(file_url));
            request.setTitle("SaiCaritre Chapter 12");

            new DownloadFileFromURL().execute(file_url);
        }

        if (inuma == 13)
        {
//            file_url = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_thirteen.mp3?alt=media&token=14e225b5-c43d-4710-bcab-76feac3a0dc0";
            file_url = "https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_thirteen.mp3?alt=media&token=d374fd83-9844-47c8-bf17-bc559f65c883";
            request = new DownloadManager.Request(Uri.parse(file_url));
            request.setTitle("SaiCaritre Chapter 13");

            new DownloadFileFromURL().execute(file_url);
        }

        if (inuma == 14)
        {
//            file_url = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_fourteen.mp3?alt=media&token=5a988ca9-4372-4292-8604-e8d26a383332";
            file_url = "https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_fourteen.mp3?alt=media&token=560f1208-398a-492a-a95b-373528b2fb07";
            request = new DownloadManager.Request(Uri.parse(file_url));
            request.setTitle("SaiCaritre Chapter 14");

            new DownloadFileFromURL().execute(file_url);
        }

        if (inuma == 15)
        {
//            file_url = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_fifteen.mp3?alt=media&token=acd65f2e-0690-4a30-8b09-36d544bd5087";
            file_url = "https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_fifteen.mp3?alt=media&token=ba1a770d-0fca-447a-aad0-0d2eecec57a3";
            request = new DownloadManager.Request(Uri.parse(file_url));
            request.setTitle("SaiCaritre Chapter 15");

            new DownloadFileFromURL().execute(file_url);
        }

        if (inuma == 16)
        {
//            file_url = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_sixteen_and_seventeen.mp3?alt=media&token=adb1b522-cf05-4ef2-ad5f-e3eb367b7cc9";
            file_url = "https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_sixteen_and_seventeen.mp3?alt=media&token=099ffa45-8ec8-4961-8524-8b177f3cea93";
            request = new DownloadManager.Request(Uri.parse(file_url));
            request.setTitle("SaiCaritre Chapter 16 and 17");

            new DownloadFileFromURL().execute(file_url);
        }

        if (inuma == 17)
        {
//            file_url = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_eighteen_and_ninteen.mp3?alt=media&token=37723840-5aa9-42a7-a454-f8062bfa0781";
            file_url = "https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_eighteen_and_ninteen.mp3?alt=media&token=9e7c8f02-17ce-471c-aefc-4012fa730a3c";
            request = new DownloadManager.Request(Uri.parse(file_url));
            request.setTitle("SaiCaritre Chapter 18 and 19");

            new DownloadFileFromURL().execute(file_url);
        }

        if (inuma == 18)
        {
//            file_url = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_twenty.mp3?alt=media&token=b0cc114d-2957-4924-a94f-4922b1a72d4b";
            file_url = "https://firebasestorage.googleapis.com/v0/b/saicharitre-app.appspot.com/o/sri_sai_charitre_chapter_twenty.mp3?alt=media&token=5df91437-63bb-4d05-b880-0a0a670af611";
            request = new DownloadManager.Request(Uri.parse(file_url));
            request.setTitle("SaiCaritre Chapter 20");

            new DownloadFileFromURL().execute(file_url);
        }


        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setDescription("Downloading file...");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, ""+System.currentTimeMillis());

        DownloadManager manager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_STORAGE_CODE:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                    startDownloading();
                    startDownloading(inum);
                }
                else {
                    Toast.makeText(this, "Permission denied...!", Toast.LENGTH_SHORT).show();
                }
            }
        }
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



        return super.onOptionsItemSelected(item);
    }

    private boolean haveNetwork()
    {
        boolean have_WIFI = false;
        boolean have_MobileData = false;

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
//        NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
//        Network[] networkInfo = connectivityManager.getAllNetworks();
//
//        for (Network info: networkInfo)
//        {
//            if (info.get.equals("WIFI"))
//                have_WIFI = true;
//        }

        NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();

        for(NetworkInfo info: networkInfos)
        {
            if (info.getTypeName().equalsIgnoreCase("WIFI"))
                if (info.isConnected())
                    have_WIFI = true;

            if (info.getTypeName().equalsIgnoreCase("MOBILE"))
                if (info.isConnected())
                    have_MobileData = true;
        }

        return have_MobileData||have_WIFI;

    }


//    private void progressBarInfo(){
//        new Thread(new Runnable() {
//            public void run() {
//                while (progressStatus < 100) {
//                    progressStatus += 1;
//                    // Update the progress bar and display the
//                    //current value in the text view
//                    handler.post(new Runnable() {
//                        public void run() {
//                            progressbaraudiodownload.setProgress(progressStatus);
////                                textView.setText(progressStatus+"/"+progressBar.getMax());
//                            progressText.setText(progressStatus+"%");
//                        }
//                    });
//                    try {
//                        // Sleep for 200 milliseconds.
//                        Thread.sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                if (progressStatus == 100)
//                {
////                        progressText.setText("DONE!");
//                    dialog.dismiss();
//                }
//            }
//        }).start();
//    }


    class DownloadFileFromURL extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread
         * Show Progress Bar Dialog
         * */

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            showDialog(progress_bar_type);
            dialog = new Dialog(AudioCharitre.this);
            dialog.setContentView(R.layout.downloading_dialog);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();



            if (dialog.isShowing())
            {


//              downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                progressbaraudiodownload = (ProgressBar)dialog.findViewById(R.id.progressbaraudiodownload);
                progressText = (TextView)dialog.findViewById(R.id.progressText);
                chapternumberdialog2 = (TextView)dialog.findViewById(R.id.chapternumberdialog2);

                if (inum == 0)
                {
                    chapternumberdialog2.setText("Saibaba Aarati Song");
                }

                if (inum == 1)
                {
                    chapternumberdialog2.setText("Saibaba Chapter number 1");
                }

                if (inum == 2)
                {
                    chapternumberdialog2.setText("Saibaba Chapter number 2");
                }

                if (inum == 3)
                {
                    chapternumberdialog2.setText("Saibaba Chapter number 3");
                }

                if (inum == 4)
                {
                    chapternumberdialog2.setText("Saibaba Chapter number 4");
                }

                if (inum == 5)
                {
                    chapternumberdialog2.setText("Saibaba Chapter number 5");
                }

                if (inum == 6)
                {
                    chapternumberdialog2.setText("Saibaba Chapter number 6");
                }

                if (inum == 7)
                {
                    chapternumberdialog2.setText("Saibaba Chapter number 7");
                }

                if (inum == 8)
                {
                    chapternumberdialog2.setText("Saibaba Chapter number 8");
                }

                if (inum == 9)
                {
                    chapternumberdialog2.setText("Saibaba Chapter number 9");
                }

                if (inum == 10)
                {
                    chapternumberdialog2.setText("Saibaba Chapter number 10");
                }

                if (inum == 11)
                {
                    chapternumberdialog2.setText("Saibaba Chapter number 11");
                }

                if (inum == 12)
                {
                    chapternumberdialog2.setText("Saibaba Chapter number 12");
                }

                if (inum == 13)
                {
                    chapternumberdialog2.setText("Saibaba Chapter number 13");
                }

                if (inum == 14)
                {
                    chapternumberdialog2.setText("Saibaba Chapter number 14");
                }

                if (inum == 15)
                {
                    chapternumberdialog2.setText("Saibaba Chapter number 15");
                }

                if (inum == 16)
                {
                    chapternumberdialog2.setText("Saibaba Chapter number 16 and 17");
                }

                if (inum == 17)
                {
                    chapternumberdialog2.setText("Saibaba Chapter number 18 and 19");
                }

                if (inum == 18)
                {
                    chapternumberdialog2.setText("Saibaba Chapter number 20");
                }
            }

            progressText.setText("0%");
        }

        /**
         * Downloading file in background thread
         * */
        @Override
        protected String doInBackground(String... f_url) {
            int count;
            try {
                URL url = new URL(f_url[0]);
                URLConnection conection = url.openConnection();
                conection.connect();
                // getting file length
                int lenghtOfFile = conection.getContentLength();

                // input stream to read file - with 8k buffer
                InputStream input = new BufferedInputStream(url.openStream(), 8192);

                // Output stream to write file
//                OutputStream output = new FileOutputStream("/sdcard/downloadedfile.jpg");

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress(""+(int)((total*100)/lenghtOfFile));


                    // writing data to file
//                    output.write(data, 0, count);
                }

                // flushing output
//                output.flush();

                // closing streams
//                output.close();
                input.close();

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return null;
        }

        /**
         * Updating progress bar
         * */
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            progressbaraudiodownload.setProgress(Integer.parseInt(progress[0]));
            progressText.setText(progress[0]+"%");
        }

        /**
         * After completing background task
         * Dismiss the progress dialog
         * **/
        @Override
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after the file was downloaded
//            dismissDialog(progress_bar_type);
            dialog.dismiss();
        }

    }
}
