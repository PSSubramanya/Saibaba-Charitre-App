package com.example.saibabacharitre;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.ArrayList;
import java.util.List;

public class BookCharitre extends AppCompatActivity {


//    View v;
    private RecyclerView myrecyclerView;

//    private RecyclerView.Adapter mAdapter;

    Context context;

    private List<CharitreContents> lstContact;


    private ListView PDFlistView;

    String[] mChapternumber = {"Chapter 1","Chapter 2","Chapter 3","Chapter 4","Chapter 5", "Chapter 6","Chapter 7","Chapter 8","Chapter 9","Chapter 10",
            "Chapter 11","Chapter 12","Chapter 13","Chapter 14","Chapter 15","Chapter 16-17","Chapter 18-19","Chapter 20",
            "Chapter 21", "Chapter 22", "Chapter 23", "Chapter 24", "Chapter 25", "Chapter 26", "Chapter 27", "Chapter 28", "Chapter 29", "Chapter 30"};


    String[] mChaptername = {"The wondrous Saint grinding wheat - Obeisances - The story of grinding wheat and its philosophical significance",
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





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_charitre);





        PDFlistView = (ListView)findViewById(R.id.charitreListView); // Listview started


//        MyAdapter mAdapter = new MyAdapter(this,mChapternumber,mChaptername);
        MyAdapter mAdapter = new MyAdapter(this,mChapternumber,mChaptername);

        PDFlistView.setAdapter(mAdapter);

        PDFlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                String ii = String.valueOf(i);
                Intent intent = new Intent(getApplicationContext(),Chapter1.class);
//              intent.putExtra("pdfFileName",item);
                intent.putExtra("pdfFileName",ii);
                startActivity(intent);
            }
        });


        //WORKING CODE

//        PDFlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String item = PDFlistView.getItemAtPosition(i).toString();
//
//                Intent intent = new Intent(getApplicationContext(),Chapter1.class);
//                intent.putExtra("pdfFileName",item);
//                startActivity(intent);
//
//            }
//        });// List view ends

        //WORKING CODE





//        myrecyclerView = (RecyclerView)findViewById(R.id.charitreRecyclerView);
//        myrecyclerView.setHasFixedSize(true);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
//        myrecyclerView.setLayoutManager(layoutManager);
//
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter(lstContact);
//
//        initializeData();
//
//
//        initializeAdapter();

    }


    class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        String rChapternumber[];
        String rChaptername[];

        MyAdapter (Context c, String Chapternumber[], String Chaptername[])
        {
            super(c, R.layout.charitre_layout_design,R.id.chapternumber,Chaptername);
            this.context = c;
            this.rChapternumber = Chapternumber;
            this.rChaptername = Chaptername;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowview = layoutInflater.inflate(R.layout.charitre_layout_design,parent,false);
//            ImageView images = rowview.findViewById(R.id.saibabalistviewicon);
            TextView myChapternumber = rowview.findViewById(R.id.chapternumber);
            TextView myChaptername = rowview.findViewById(R.id.charitrname);


            myChapternumber.setText(rChapternumber[position]);
            myChaptername.setText(rChaptername[position]);


//            return super.getView(position, convertView, parent);
            return rowview;

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.languagepage_toolbar,menu);
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
}
