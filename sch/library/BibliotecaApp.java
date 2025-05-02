package sch.library;

import java.util.ArrayList;
import java.util.Scanner;
import sch.library.modules.book.*;
import sch.library.modules.loan.Loan;
import sch.library.modules.loan.LoanService;
import sch.library.modules.user.Teacher;
import sch.library.modules.user.User;
import sch.library.modules.user.UserService;

public class BibliotecaApp {

    private static LoanService loanService = new LoanService();
    private static BookService bookService = new BookService();
    private static UserService userService = new UserService();

    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Loan> loans = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // Agregar algunos datos de ejemplo
        initializeData();

        boolean left = false;

        while (!left) {
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

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (option) {
                case 1:
                    bookService.add(books);
                    break;
                case 2:
                    userService.add(users);
                    break;
                case 3:
                    loanService.add(books, users, loans);
                    break;
                case 4:
                    loanService.returnBook(books, loans);
                    break;
                case 5:
                    bookService.searchBookByTerm(books);
                    break;
                case 6:
                    bookService.showAll(books);
                    break;
                case 7:
                    userService.showAll(users);
                    break;
                case 8:
                    loanService.showAll(books, users, loans);
                    break;
                case 9:
                    left = true;
                    System.out.println("¡Sistema de biblioteca! sesión finalizada");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void initializeData() {
        // example books 
        books.add(new AudioBook(1, "Don Quijote de la Mancha", "Miguel de Cervantes", 1605, "Ficción", true));
        books.add(new Ebook(2, "Cien años de soledad", "Gabriel García Márquez", 1967, "Novela", true));
        books.add(new FisicBook(3, "El principito", "Antoine de Saint-Exupéry", 1943, "Fábula", true));

        // example users
        users.add(new Teacher(101, "Jose Camacho", "jantonio@gmail.com", "123456789"));
        users.add(new Teacher(102, "Patricia Moreno", "patricia@gmail.com", "987654321"));

        // initialize services
    }

}
