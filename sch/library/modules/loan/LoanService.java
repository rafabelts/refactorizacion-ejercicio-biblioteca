package sch.library.modules.loan;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import sch.library.modules.book.Book;
import sch.library.modules.user.User;
import sch.library.utils.LoanServiceInterface;
import sch.library.utils.SearchItem;

public class LoanService implements LoanServiceInterface {

    Scanner scanner = new Scanner(System.in);

    public void add(List<Book> books, List<User> users, List<Loan> loans) {
        System.out.println("--- PRESTAR LIBRO ---");

        System.out.print("ID del libro: ");

        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("ID del usuario: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Book book = new SearchItem<Book>().search(bookId, books);
        User user = new SearchItem<User>().search(userId, users);

        if (book == null) {
            System.out.println("Error: Libro no encontrado.");
            return;
        }

        if (user == null) {
            System.out.println("Error: Usuario no encontrado.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Error: El libro no está disponible actualmente.");
        }

        if (userLoans(loans, userId) >= 3) {
            System.out.println("Error: El usuario ya tiene 3 libros prestados.");
            return;
        }

        Date loanDate = new Date();
        Loan newLoan = new Loan(loans.size() + 1, bookId, userId, loanDate, null, false);

        loans.add(newLoan);
        book.setAvailable(false);

        System.out.println("Préstamo realizado con éxito.");
    }

    public void showAll(List<Book> books, List<User> users, List<Loan> loans) {
        System.out.println("--- PRÉSTAMOS ACTIVOS ---");
        boolean areLoans = false;

        for (Loan loan : loans) {
            if (!loan.isReturned()) {
                Book book = null;
                User user = null;

                book = new SearchItem<Book>().search(loan.getBookId(), books);
                user = new SearchItem<User>().search(loan.getUserId(), users);

                if (book != null && user != null) {
                    System.out.println("ID Préstamo: " + loan.getId()
                            + " | Libro: " + book.getTitle()
                            + " | Usuario: " + user.getName()
                            + " | Fecha: " + loan.getLoanDate());
                    areLoans = true;
                }
            }
        }

        if (!areLoans) {
            System.out.println("No hay préstamos activos.");
        }

    }

    public void returnBook(List<Book> books, List<Loan> loans) {
        System.out.println("--- DEVOLVER LIBRO ---");

        System.out.print("ID del libro: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Loan loan = null;

        for (Loan l : loans) {
            if (l.getBookId() == bookId && !l.isReturned()) {
                loan = l;
                break;
            }
        }

        if (loan == null) {
            System.out.println("Error: No hay préstamos activos para este libro.");
            return;
        }

        loan.setReturned(true);
        loan.setDevolutionDate(new Date());

        Book returnedBook = new SearchItem<Book>().search(bookId, books);

        returnedBook.setAvailable(true);
    }

    private int userLoans(List<Loan> loans, int userId) {
        int userBooks = 0;
        for (Loan loan : loans) {
            if (loan.getUserId() == userId && !loan.isReturned()) {
                userBooks++;
            }
        }
        return userBooks;
    }

}
