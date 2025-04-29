package sch.library.modules.book;

import sch.library.utils.Identifiable;

public class Book implements Identifiable {

    private int id;
    private String title;
    private String author;
    private int year;
    private String gender;
    private boolean available;

    public Book(int id, String title, String author, int year, String gender, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.gender = gender;
        this.available = available;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
