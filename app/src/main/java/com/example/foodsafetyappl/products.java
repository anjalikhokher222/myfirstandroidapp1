package com.example.foodsafetyappl;
import java.lang.String;
public class products {
    private String Title;
    private String Category;
    private String Description;
    private int Thumbnail;
    private int Thumbnaill;
    private String Titlee;

    public products(){

    }
    public products(String title,String category,String description,int thumbnail,int thumbnaill,String titlee) {

        Title = title;
        Category = category;
        Description = description;
        Thumbnail = thumbnail;
        Thumbnaill=thumbnaill;
        Titlee=titlee;

    }

public  String getTitle(){ return Title;}
    public  String getTitlee(){ return Titlee;}

    public String getCategory() {
        return Category;
    }

    public String getDescription() {
        return Description;
    }
    public  int getThumbnaill(){ return Thumbnaill;}


    public int getThumbnail() {
        return Thumbnail;
    }

    public void setTitle(String title) {
        Title = title;
    }
    public void setTitlee(String title) {
        Titlee = title;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
    public void setThumbnaill(int thumbnail) {
        Thumbnaill = thumbnail;
    }





}
