package sch.library.modules.book;

import java.util.List;
import java.util.Scanner;
import sch.library.utils.Service;

public class BookService implements Service<Book> {

    private static Scanner scanner = new Scanner(System.in);

    public void add(List<Book> books) {
        System.out.println("--- REGISTRAR NUEVO LIBRO ---");

        System.out.print("ID: ");

        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Título: ");
        String title = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Año: ");
        int anio = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Género: ");
        String genero = scanner.nextLine();

        Book newBook = new Book(id, title, autor, anio, genero, true);
        books.add(newBook);

        System.out.println("Libro registrado con éxito.");
    }

    public void showAll(List<Book> books) {
        System.out.println("--- LISTADO DE LIBROS ---");

        if (books.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (Book book : books) {
            printBookInfo(book);
        }
    }

    public void searchBookByTerm(List<Book> books) {
        System.out.println("--- BUSCAR LIBROS ---");
        System.out.println("1. Buscar por título");
        System.out.println("2. Buscar por autor");
        System.out.println("3. Buscar por género");
        System.out.print("Seleccione una opción: ");

        int option = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea

        System.out.print("Ingrese término de búsqueda: ");
        String term = scanner.nextLine().toLowerCase();

        boolean founded = false;

        System.out.println("Resultados:");

        for (Book book : books) {
            switch (option) {
                case 1:
                    searchByTitle(book, term);
                    founded = true;
                    break;
                case 2:
                    searchByAuthor(book, term);
                    founded = true;

                    break;
                case 3:
                    searchByGender(book, term);
                    founded = true;
                    break;
                default:
                    System.out.println("Opción no valida");
                    return;
            }
        }

        if (!founded) {
            System.out.println("No se encontraron libros que coincidan con la búsqueda.");
        }
    }

    private void searchByTitle(Book book, String title) {
        if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
            printBookInfo(book);
        }
    }

    private void searchByAuthor(Book book, String author) {
        if (book.getTitle().toLowerCase().contains(author.toLowerCase())) {
            printBookInfo(book);

        }
    }

    private void searchByGender(Book book, String gender) {
        if (book.getTitle().toLowerCase().contains(gender.toLowerCase())) {
            printBookInfo(book);

        }
    }

    private void printBookInfo(Book book) {
        System.out.println("ID: " + book.getId() + " | Título: " + book.getTitle()
                + " | Autor: " + book.getAuthor() + " | Año: " + book.getYear()
                + " | Género: " + book.getGender()
                + " | Disponible: " + (book.isAvailable() ? "Sí" : "No"));
    }

}
