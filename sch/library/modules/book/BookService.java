package sch.library.modules.book;

import java.util.List;
import java.util.Scanner;

public class BookService {

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
        scanner.nextLine();  // Consumir el salto de línea

        System.out.print("Género: ");
        String genero = scanner.nextLine();

        Book newBook = new Book(id, title, autor, anio, genero, true);
        books.add(newBook);

        System.out.println("Libro registrado con éxito.");
    }
}
