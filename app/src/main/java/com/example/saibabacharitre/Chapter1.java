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
    }
}
