package sch.library.modules.book;

public class FisicBook extends Book {

    public FisicBook(int id, String title, String author, int year, String gender, boolean available) {
        super(id, title, author, year, gender, available);
    }

    public void clean() {
        System.out.println("El libro físico ha sido limpiado.");
    }

}
