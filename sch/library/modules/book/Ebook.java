package sch.library.modules.book;

public class Ebook extends Book {

    public Ebook(int id, String title, String author, int year, String gender, boolean available) {
        super(id, title, author, year, gender, available);
    }

    public void download() {
        System.out.println("El libro digital ha sido descargado.");
    }

}
