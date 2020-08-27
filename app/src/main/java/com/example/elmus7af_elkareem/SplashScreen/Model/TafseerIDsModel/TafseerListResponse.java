package com.example.elmus7af_elkareem.SplashScreen.Model.TafseerIDsModel;

public class TafseerListResponse {
    private int id;
    private String name;
    private String author;
    private String bookName;

    public TafseerListResponse(){}
    public TafseerListResponse(int id, String name, String author, String bookName) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.bookName = bookName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookName() {
        return bookName;
    }
}
