package com.example.saibabacharitre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DownloadManager;
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

    private ProgressBar progressbaraudiodownload;

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
                            Intent intent = new Intent(getApplicationContext(),Chapter1audio.class);
                            intent.putExtra("audioFileName",ii);
                            startActivity(intent);

                            audiodownloadbtn = view.findViewById(R.id.audiodownloadbtn);

                            audiodownloadbtn.setOnClickListener(new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View view) {

                                    dialog = new Dialog(AudioCharitre.this);
                                    dialog.setContentView(R.layout.downloading_dialog);
                                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                    dialog.show();

                                    if (dialog.isShowing())
                                    {
//                                        downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                                        progressbaraudiodownload = (ProgressBar)dialog.findViewById(R.id.progressbaraudiodownload);
                                        String urlDownloadLink = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_one.mp3?alt=media&token=48e38f0d-3b1c-4bf4-bd9c-320e950520ed";
                                        String downloadAudioPath = "/storage/emulated/0/Download/Saibaba_chapter1.mp3";


                                        //check this DownloadFile once
//                                        DownloadFile downloadAudioFile = new DownloadFile();
//                                        downloadAudioFile.doInBackground();
//                                        downloadAudioFile.execute(urlDownloadLink, downloadAudioPath);


                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                                            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                                                    PackageManager.PERMISSION_DENIED){
                                                String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};

                                                requestPermissions(permissions, PERMISSION_STORAGE_CODE);

                                            }
                                            else {
//                                                startDownloading(ii);
                                                startDownloading();
                                            }
                                        }
                                        else {
//                                            startDownloading(ii);
                                            startDownloading();
                                        }
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        

//                                        Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_one.mp3?alt=media&token=48e38f0d-3b1c-4bf4-bd9c-320e950520ed");
//                                        DownloadManager.Request request = new DownloadManager.Request(uri);
//                                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//                                        Long reference = downloadManager.enqueue(request);
                                    }
                                }

//                                private void startDownloading() {
//                                }



                            });
                }

//                private void startDownloading() {
//                }
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

//    private void startDownloading(String ii) {
    private void startDownloading() {
//        String url = mUrlEt.getText().toString().trim();

//        String url = "https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_three.mp3?alt=media&token=48e38f0d-3b1c-4bf4-bd9c-320e950520ed";

//        DownloadManager.Request request;
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_two.mp3?alt=media&token=48e38f0d-3b1c-4bf4-bd9c-320e950520ed"));


//        if (ii.equals("0"))
//        {
//            request = new DownloadManager.Request(Uri.parse("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_one.mp3?alt=media&token=48e38f0d-3b1c-4bf4-bd9c-320e950520ed"));
//            request.setTitle("SaiCaritre Chapter 1");
//        }
//
//        if (ii.equals("1"))
//        {
//            request = new DownloadManager.Request(Uri.parse("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_two.mp3?alt=media&token=48e38f0d-3b1c-4bf4-bd9c-320e950520ed"));
//            request.setTitle("SaiCaritre Chapter 2");
//        }
//
//        if (ii.equals("2"))
//        {
//            request = new DownloadManager.Request(Uri.parse("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_three.mp3?alt=media&token=48e38f0d-3b1c-4bf4-bd9c-320e950520ed"));
//            request.setTitle("SaiCaritre Chapter 3");
//        }


//        DownloadManager.Request request = new DownloadManager.Request(Uri.parse("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_three.mp3?alt=media&token=48e38f0d-3b1c-4bf4-bd9c-320e950520ed"));

        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("SaiCaritre Chapter 2");
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
                    startDownloading();
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

//        if (id == R.id.appinfoid);
//        {
////            Toast.makeText(ChoicePage.this, "Click on the icon to choose!", Toast.LENGTH_LONG).show();
////            Intent intent = new Intent(OptionPage.this,AboutAppPage.class);
////            startActivity(intent);
//        }

        return super.onOptionsItemSelected(item);
    }






// to download file
//    private class DownloadFile extends AsyncTask<String, Integer, String> {
//
//    @SuppressLint("WrongThread")
//    @Override
//    protected String doInBackground(String... url) {
//        int count;
//        File file;
//
//        for (int i = 0; i < 20; i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
////            progressbar.incrementProgressBy(10);
//            progressbaraudiodownload.incrementProgressBy(10);
//        }
//
//
//
//        //STARTS-> working try... comeback to this if experiment doesn't work
////        try {
////
////            //this is where your download code starts
////            //URL urls = new URL("url of your .mp3 file");
////
////            URL urls = new URL("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_one.mp3?alt=media&token=48e38f0d-3b1c-4bf4-bd9c-320e950520ed");
////            URLConnection conexion = urls.openConnection();
////            conexion.connect();
////
////
////            int lengthOfFile = conexion.getContentLength();
////
////
////
////
////            // This code is written above when dialogue opens
//////            downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
//////            Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_one.mp3?alt=media&token=48e38f0d-3b1c-4bf4-bd9c-320e950520ed");
//////            DownloadManager.Request request = new DownloadManager.Request(uri);
//////            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//////            Long reference = downloadManager.enqueue(request);
////
////
////
////
////            // this will be useful so that you can show a tipical 0-100% progress bar
////            int lenghtOfFile = conexion.getContentLength();
////
////            // downlod the file
////            InputStream input = new BufferedInputStream(urls.openStream());
//////            OutputStream output = new FileOutputStream("/sdcard/somewhere/nameofthefile.mp3");
//////            OutputStream output = new FileOutputStream("/storage/emulated/0/DCIM/Camera/Saibaba_chapter1.mp3");
////
//////            OutputStream output = new FileOutputStream("/storage/emulated/0/Download/Saibaba_chapter1.mp3");
////            OutputStream output = new FileOutputStream("/sdcard/Saibaba_chapter1.mp3");
////
////            byte data[] = new byte[1024];
////
////            long total = 0;
////
////            while ((count = input.read(data)) != -1) {
////                total += count;
////                // publishing the progress....
////                publishProgress((int)(total*100/lenghtOfFile));
////                output.write(data, 0, count);
////            }
////
////            output.flush();
////            output.close();
////            input.close();
////
////
////
////        } catch (Exception e) {
////        }
////        return null;
//
//        //STOPS-> working try... comeback to this if experiment doesn't work 1st set of code
//
//
//
//        //STARTS-> working try... comeback to this if experiment doesn't work 2nd set of codes
//
//
////        try {
//////            URL urls = new URL(fileUrl);
////            URL urls = new URL("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_one.mp3?alt=media&token=48e38f0d-3b1c-4bf4-bd9c-320e950520ed");
////            URLConnection conection = urls.openConnection();
////            conection.connect();
////
////            int lenghtOfFile = conection.getContentLength();
////
////            InputStream input = conection.getInputStream();
////
//////            File SDCardRoot = Environment.getExternalStorageDirectory();
////            File SDCardRoot = Environment.getRootDirectory();
////            File folder = new File(SDCardRoot, "/storage/emulated/0/Download");
////            if (!folder.exists())
////                folder.mkdir();
////            file = new File(folder, "Saibaba_chapter1.mp3");
////            OutputStream output = new FileOutputStream(file);
////
////            byte data[] = new byte[1024];
////
////            long total = 0;
////
////            while ((count = input.read(data)) != -1) {
////                total += count;
//////                publishProgress("" + (int) ((total * 100) / lenghtOfFile));
////                output.write(data, 0, count);
////            }
////
////            output.flush();
////            output.close();
////            input.close();
////
////        }
////        catch (Exception e)
////        {
////            return null;
////        }
//////        return file;
////
////        return String.valueOf(file);
//
//
//        //STARTS-> working try... comeback to this if experiment doesn't work 2nd set of codes
//
//
//
//
//
//
//
//    }





//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
////        showProgressDialog();
//        progressbaraudiodownload.setProgress(0);
//        progressbaraudiodownload.setMax(100);
//        int progressbarstatus = 0;
//        progressbaraudiodownload.setVisibility(ProgressBar.VISIBLE);
//    }
//
//    @Override
//    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
//        progressbaraudiodownload.setVisibility(ProgressBar.GONE);
//    }








//    @Override
//    protected void onProgressUpdate(String... values) {
//
//        super.onProgressUpdate(values);
//    }



//}
// to download file



//The code to download part 2 begins


    private class DownloadFile extends AsyncTask<Void, String, File> {

        /**
         * Before starting background thread Show Progress Bar Dialog
         * */



//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            showProgressDialog();
//        }

        /**
         * Downloading file in background thread
         * */
        @Override
        protected File doInBackground(Void... params) {
            int count;
            File file;
            try {
                URL url = new URL("https://firebasestorage.googleapis.com/v0/b/saibaba-charitre-app-b1977.appspot.com/o/sri_sai_charitre_chapter_one.mp3?alt=media&token=48e38f0d-3b1c-4bf4-bd9c-320e950520ed");
                URLConnection conection = url.openConnection();
                conection.connect();

                int lenghtOfFile = conection.getContentLength();

                InputStream input = conection.getInputStream();

                File SDCardRoot = Environment.getExternalStorageDirectory();

                File folder = new File(SDCardRoot, "/storage/emulated/0/Download");
                if (!folder.exists())
                    folder.mkdir();
                file = new File(folder, "Saibaba_chapter1.mp3");

                OutputStream output = new FileOutputStream(file);

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;

                    publishProgress("" + (int) ((total * 100) / lenghtOfFile));

                    output.write(data, 0, count);
                }

                output.flush();

                output.close();
                input.close();

            } catch (Exception e) {
                return null;
            }
            return file;
        }

        /**
         * Updating progress bar
         * */
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            progressbaraudiodownload.setProgress(Integer.parseInt(progress[0]));
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/


//        @Override
//        protected void onPostExecute(File file) {
//            // dismiss the dialog after the file was downloaded
//            dismissProgressDialog();
//        }

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
}
