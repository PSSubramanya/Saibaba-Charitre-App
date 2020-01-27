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
            pdfchapter1.fromAsset("sai_chapter1.pdf").load();
        }

        if (getItem.equals("1"))
        {
            pdfchapter1.fromAsset("sai_chapter 2.pdf").load();
        }
    }
}
