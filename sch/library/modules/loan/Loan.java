package sch.library.modules.loan;

import java.util.Date;
import sch.library.utils.Identifiable;

public class Loan implements Identifiable {

    private int id;
    private int bookId;
    private int userId;
    private Date loanDate;
    private Date devolutionDate;
    private boolean returned;

    public Loan(int id, int bookId, int userId, Date loanDate, Date devolutionDate, boolean returned) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.loanDate = loanDate;
        this.devolutionDate = devolutionDate;
        this.returned = returned;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}
