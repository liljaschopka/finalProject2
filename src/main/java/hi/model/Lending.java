package hi.model;

import java.time.LocalDate;

public class Lending {

    LocalDate dueDate;
    User user;
    Book book;

    public Lending(User user, Book book) {
        dueDate = LocalDate.now().plusDays(30);
        this.user = user;
        this.book = book;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return book + ", return by: " + dueDate;
    }

}
