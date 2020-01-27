package com.example.saibabacharitre;

public class CharitreContents {

    private String ChapterNumber;
    private String ChapterName;

    public CharitreContents(String chapterNumber, String chapterName) {
        ChapterNumber = chapterNumber;
        ChapterName = chapterName;
    }


    public String getChapterNumber() {
        return ChapterNumber;
    }

    public String getChapterName() {
        return ChapterName;
    }


    public void setChapterNumber(String chapterNumber) {
        ChapterNumber = chapterNumber;
    }

    public void setChapterName(String chapterName) {
        ChapterName = chapterName;
    }
}
