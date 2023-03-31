package hi.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {

    private List<Book> books;
    private List<User> users;
    private List<Lending> lendings;

    public LibrarySystem() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.lendings = new ArrayList<>();
    }

    public void addBookWithTitleAndAuthorlist(String title, List<Author> authors) throws EmptyAuthorListException {
        books.add(new Book(title, authors));
    }

    public void addStudentUser(String name, boolean feePaid) {
        if (feePaid == true) {
            users.add(new User(name));
        }
    }

    public void addFacultyMemberUser(String name, String department) {
        users.add(new FacultyMember(name, department));
    }

    public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        throw new UserOrBookDoesNotExistException("The book does not exist");
    }

    public User findUserByName(String name) throws UserOrBookDoesNotExistException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                return users.get(i);
            }
        }
        throw new UserOrBookDoesNotExistException("The user does not exist");
    }

    public void borrowBook(User user, Book book) {
        Lending lending = new Lending(user, book);
        lendings.add(lending);
    }

    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) throws UserOrBookDoesNotExistException {
        boolean found = false;
        for (int i = 0; i < lendings.size(); i++) {
            if (lendings.get(i).getUser().getName().equals(facultyMember.getName()) && lendings.get(i).getBook().getTitle().equals(book.getTitle())) {
                lendings.get(i).setDueDate(newDueDate);
                found = true;
            }
        }
        if (!found) {
            throw new UserOrBookDoesNotExistException("The user does not exist");
        }

    }

    public void returnBook(User user, Book book) throws UserOrBookDoesNotExistException {
        for (int i = 0; i < lendings.size(); i++) {
            if (lendings.get(i).getUser().getName().equals(user.getName()) && lendings.get(i).getBook().getTitle().equals(book.getTitle())) {
                lendings.remove(i);
            }
        }
    }

}
