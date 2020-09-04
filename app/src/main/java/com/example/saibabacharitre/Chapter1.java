package com.example.saibabacharitre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Chapter1 extends AppCompatActivity {


    PDFView pdfchapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1);


        pdfchapter1 = (PDFView)findViewById(R.id.pdfchapter1);


//        String getItem = getIntent().getStringExtra("pdfFileName");
        String getItem = getIntent().getStringExtra("pdfFileName");

//        String getItem = getIntent().getStringExtra("mChapternumber");

//        pdfchapter1.fromAsset("sai_chapter1.pdf")
//                .load();


//        if (getItem.equals("Saibaba chapter1"))
//        {
//            pdfchapter1.fromAsset("sai_chapter1.pdf").load();
//        }
//
//        if (getItem.equals("Saibaba chapter2"))
//        {
//            pdfchapter1.fromAsset("sai_chapter 2.pdf").load();
//        }



//        if (getItem.equals("Chapter 1"))
//        {
//            pdfchapter1.fromAsset("sai_chapter1.pdf").load();
//        }
//
//        if (getItem.equals("Chapter 2"))
//        {
//            pdfchapter1.fromAsset("sai_chapter 2.pdf").load();
//        }

        if (getItem.equals("0"))
        {
            pdfchapter1.fromAsset("sai_chapter 1.pdf").load();
        }

        if (getItem.equals("1"))
        {
            pdfchapter1.fromAsset("sai_chapter 2.pdf").load();
        }

        if (getItem.equals("2"))
        {
            pdfchapter1.fromAsset("sai_chapter 3.pdf").load();
        }

        if (getItem.equals("3"))
        {
            pdfchapter1.fromAsset("sai_chapter 4.pdf").load();
        }

        if (getItem.equals("4"))
        {
            pdfchapter1.fromAsset("sai_chapter 5.pdf").load();
        }

        if (getItem.equals("5"))
        {
            pdfchapter1.fromAsset("sai_chapter 6.pdf").load();
        }

        if (getItem.equals("6"))
        {
            pdfchapter1.fromAsset("sai_chapter 7.pdf").load();
        }

        if (getItem.equals("7"))
        {
            pdfchapter1.fromAsset("sai_chapter 8.pdf").load();
        }

        if (getItem.equals("8"))
        {
            pdfchapter1.fromAsset("sai_chapter 9.pdf").load();
        }

        if (getItem.equals("9"))
        {
            pdfchapter1.fromAsset("sai_chapter 10.pdf").load();
        }

        if (getItem.equals("10"))
        {
            pdfchapter1.fromAsset("sai_chapter 11.pdf").load();
        }

        if (getItem.equals("11"))
        {
            pdfchapter1.fromAsset("sai_chapter 12.pdf").load();
        }

        if (getItem.equals("12"))
        {
            pdfchapter1.fromAsset("sai_chapter 13.pdf").load();
        }

        if (getItem.equals("13"))
        {
            pdfchapter1.fromAsset("sai_chapter 14.pdf").load();
        }

        if (getItem.equals("14"))
        {
            pdfchapter1.fromAsset("sai_chapter 15.pdf").load();
        }

        if (getItem.equals("15"))
        {
            pdfchapter1.fromAsset("sai_chapter 16 and 17.pdf").load();
        }

        if (getItem.equals("16"))
        {
            pdfchapter1.fromAsset("sai_chapter 18 and 19.pdf").load();
        }

        if (getItem.equals("17"))
        {
            pdfchapter1.fromAsset("sai_chapter 20.pdf").load();
        }

        if (getItem.equals("18"))
        {
            pdfchapter1.fromAsset("sai_chapter 21.pdf").load();
        }

        if (getItem.equals("19"))
        {
            pdfchapter1.fromAsset("sai_chapter 22.pdf").load();
        }

        if (getItem.equals("20"))
        {
            pdfchapter1.fromAsset("sai_chapter 23.pdf").load();
        }

        if (getItem.equals("21"))
        {
            pdfchapter1.fromAsset("sai_chapter 24.pdf").load();
        }

        if (getItem.equals("22"))
        {
            pdfchapter1.fromAsset("sai_chapter 25.pdf").load();
        }

        if (getItem.equals("23"))
        {
            pdfchapter1.fromAsset("sai_chapter 26.pdf").load();
        }

        if (getItem.equals("24"))
        {
            pdfchapter1.fromAsset("sai_chapter 27.pdf").load();
        }

        if (getItem.equals("25"))
        {
            pdfchapter1.fromAsset("sai_chapter 28.pdf").load();
        }

        if (getItem.equals("26"))
        {
            pdfchapter1.fromAsset("sai_chapter 29.pdf").load();
        }

        if (getItem.equals("27"))
        {
            pdfchapter1.fromAsset("sai_chapter 30.pdf").load();
        }

//        if (getItem.equals("28"))
//        {
//            pdfchapter1.fromAsset("sai_chapter 31.pdf").load();
//        }

//        if (getItem.equals("29"))
//        {
//            pdfchapter1.fromAsset("sai_chapter 31.pdf").load();
//        }
//
//        if (getItem.equals("30"))
//        {
//            pdfchapter1.fromAsset("sai_chapter 32.pdf").load();
//        }
    }
}
