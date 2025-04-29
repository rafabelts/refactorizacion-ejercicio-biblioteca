package sch.library;

import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import sch.library.modules.book.Book;
import sch.library.modules.book.BookService;
import sch.library.modules.book.BookService;
import sch.library.modules.loan.Loan;
import sch.library.modules.user.User;

public class BibliotecaApp {

    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Loan> loans = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // Agregar algunos datos de ejemplo
        initializeData();;

        boolean salir = false;
        while (!salir) {
            System.out.println("--- SISTEMA DE BIBLIOTECA ---");
            System.out.println("1. Registrar nuevo libro");
            System.out.println("2. Registrar nuevo usuario");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Buscar libros");
            System.out.println("6. Ver todos los libros");
            System.out.println("7. Ver todos los usuarios");
            System.out.println("8. Ver préstamos activos");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarLibro();
                    break;
                case 2:
                    registrarUsuario();
                    break;
                case 3:
                    prestarLibro();
                    break;
                case 4:
                    devolverLibro();
                    break;
                case 5:
                    buscarLibros();
                    break;
                case 6:
                    mostrarLibros();
                    break;
                case 7:
                    mostrarUsuarios();
                    break;
                case 8:
                    mostrarPrestamosActivos();
                    break;
                case 9:
                    salir = true;
                    System.out.println("¡Sistema de biblioteca! sesión finalizada");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void initializeData() {
        // example books 
        books.add(new Book(1, "Don Quijote de la Mancha", "Miguel de Cervantes", 1605, "Ficción", true));
        books.add(new Book(2, "Cien años de soledad", "Gabriel García Márquez", 1967, "Novela", true));
        books.add(new Book(3, "El principito", "Antoine de Saint-Exupéry", 1943, "Fábula", true));

        // example users
        users.add(new User(101, "Jose Camacho", "jantonio@gmail.com", "123456789"));
        users.add(new User(102, "Patricia Moreno", "patricia@gmail.com", "987654321"));
    }

    private static void buscarLibros() {
        System.out.println("--- BUSCAR LIBROS ---");
        System.out.println("1. Buscar por título");
        System.out.println("2. Buscar por autor");
        System.out.println("3. Buscar por género");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea

        System.out.print("Ingrese término de búsqueda: ");
        String termino = scanner.nextLine().toLowerCase();

        boolean encontrado = false;

        System.out.println("Resultados:");
        for (Libro libro : libros) {
            boolean coincide = false;

            switch (opcion) {
                case 1:
                    coincide = libro.getTitulo().toLowerCase().contains(termino);
                    break;
                case 2:
                    coincide = libro.getAutor().toLowerCase().contains(termino);
                    break;
                case 3:
                    coincide = libro.getGenero().toLowerCase().contains(termino);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }

            if (coincide) {
                System.out.println("ID: " + libro.getId() + " | Título: " + libro.getTitulo()
                        + " | Autor: " + libro.getAutor() + " | Año: " + libro.getAnio()
                        + " | Género: " + libro.getGenero()
                        + " | Disponible: " + (libro.isDisponible() ? "Sí" : "No"));
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron libros que coincidan con la búsqueda.");
        }
    }

    private static void mostrarLibros() {
        System.out.println("--- LISTADO DE LIBROS ---");

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (Libro libro : libros) {
            System.out.println("ID: " + libro.getId() + " | Título: " + libro.getTitulo()
                    + " | Autor: " + libro.getAutor() + " | Año: " + libro.getAnio()
                    + " | Género: " + libro.getGenero()
                    + " | Disponible: " + (libro.isDisponible() ? "Sí" : "No"));
        }
    }

    private static void mostrarUsuarios() {
        System.out.println("--- LISTADO DE USUARIOS ---");

        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId() + " | Nombre: " + usuario.getNombre()
                    + " | Email: " + usuario.getEmail() + " | Teléfono: " + usuario.getTelefono());
        }
    }

    private static void mostrarPrestamosActivos() {
        System.out.println("--- PRÉSTAMOS ACTIVOS ---");

        boolean hayPrestamos = false;

        for (Prestamo prestamo : prestamos) {
            if (!prestamo.isDevuelto()) {
                Libro libro = null;
                Usuario usuario = null;

                // Buscar libro y usuario asociados
                for (Libro l : libros) {
                    if (l.getId() == prestamo.getIdLibro()) {
                        libro = l;
                        break;
                    }
                }

                for (Usuario u : usuarios) {
                    if (u.getId() == prestamo.getIdUsuario()) {
                        usuario = u;
                        break;
                    }
                }

                if (libro != null && usuario != null) {
                    System.out.println("ID Préstamo: " + prestamo.getId()
                            + " | Libro: " + libro.getTitulo()
                            + " | Usuario: " + usuario.getNombre()
                            + " | Fecha: " + prestamo.getFechaPrestamo());
                    hayPrestamos = true;
                }
            }
        }

        if (!hayPrestamos) {
            System.out.println("No hay préstamos activos.");
        }
    }

}
