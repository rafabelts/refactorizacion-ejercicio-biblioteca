package sch.library.utils;

import java.util.List;
import sch.library.modules.book.Book;
import sch.library.modules.loan.Loan;
import sch.library.modules.user.User;

public interface LoanServiceInterface {

    public void add(List<Book> books, List<User> users, List<Loan> loans);

    public void showAll(List<Book> books, List<User> users, List<Loan> loans);
}
