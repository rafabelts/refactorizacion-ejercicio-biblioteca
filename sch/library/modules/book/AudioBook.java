package sch.library.modules.book;

public class AudioBook extends Book {

    public AudioBook(int id, String title, String author, int year, String gender, boolean available) {
        super(id, title, author, year, gender, available);
    }

    public void play() {
        System.out.println("El audiolibro está siendo reproducido.");
    }
}
