package hi.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {

    private List<Book> books;
    private ObservableList<Book> fxBooks = FXCollections.observableArrayList();
    private List<User> users;
    private List<Lending> lendings;
    private ObservableList<Lending> fxLendings = FXCollections.observableArrayList();

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

    public List<User> getUsers() {
        return users;
    }

    public List<Book> getBooks() {
        return books;
    }

    public ObservableList<Book> getFxBooks() {
        return fxBooks;
    }

    public List<Lending> getLendings() {
        return lendings;
    }

    public ObservableList<Lending> getFxLendings() {
        return fxLendings;
    }

    public void setFxLendings(ObservableList<Lending> fxLendings) {
        this.fxLendings = fxLendings;
    }

    public void setBooks() {
        ArrayList<Author> Mockingbird = new ArrayList<>();
        Mockingbird.add(new Author("Harper Lee"));
        ArrayList<Author> Pride = new ArrayList<>();
        Pride.add(new Author("Jane Austen"));
        ArrayList<Author> Moby = new ArrayList<>();
        Moby.add(new Author("Herman Melville"));
        ArrayList<Author> Gatsby = new ArrayList<>();
        Gatsby.add(new Author("F. Scott Fitzgerald"));
        ArrayList<Author> Frankenstein = new ArrayList<>();
        Frankenstein.add(new Author("Mary Shelley"));
        ArrayList<Author> Women = new ArrayList<>();
        Women.add(new Author("Louisa May Alcott"));
        ArrayList<Author> Wuthering = new ArrayList<>();
        Wuthering.add(new Author("Emily Brontë"));
        ArrayList<Author> AnneKarenina = new ArrayList<>();
        AnneKarenina.add(new Author("Leo Tolstoy"));
        ArrayList<Author> TheTaleOfTwoCities = new ArrayList<>();
        TheTaleOfTwoCities.add(new Author("Charles Dickens"));
        ArrayList<Author> OfMiceAndMen = new ArrayList<>();
        OfMiceAndMen.add(new Author("John Steinbeck"));

        books.add(new Book("To Kill a Mockingbird", Mockingbird));
        books.add(new Book("Pride and Prejudice", Pride));
        books.add(new Book("Moby Dick", Moby));
        books.add(new Book("Gatsby", Gatsby));
        books.add(new Book("Frankenstein", Frankenstein));
        books.add(new Book("The Tale of Two Cities", TheTaleOfTwoCities));
        books.add(new Book("Of Mice and Men", OfMiceAndMen));

        System.out.println("books are made");
    }

    public void setFxBooks() {
        ArrayList<Author> Mockingbird = new ArrayList<>();
        Mockingbird.add(new Author("Harper Lee"));
        ArrayList<Author> Pride = new ArrayList<>();
        Pride.add(new Author("Jane Austen"));
        ArrayList<Author> Moby = new ArrayList<>();
        Moby.add(new Author("Herman Melville"));
        ArrayList<Author> Gatsby = new ArrayList<>();
        Gatsby.add(new Author("F. Scott Fitzgerald"));
        ArrayList<Author> Frankenstein = new ArrayList<>();
        Frankenstein.add(new Author("Mary Shelley"));
        ArrayList<Author> Women = new ArrayList<>();
        Women.add(new Author("Louisa May Alcott"));
        ArrayList<Author> Wuthering = new ArrayList<>();
        Wuthering.add(new Author("Emily Brontë"));
        ArrayList<Author> AnneKarenina = new ArrayList<>();
        AnneKarenina.add(new Author("Leo Tolstoy"));
        ArrayList<Author> TheTaleOfTwoCities = new ArrayList<>();
        TheTaleOfTwoCities.add(new Author("Charles Dickens"));
        ArrayList<Author> OfMiceAndMen = new ArrayList<>();
        OfMiceAndMen.add(new Author("John Steinbeck"));

        fxBooks.add(new Book("To Kill a Mockingbird", Mockingbird));
        fxBooks.add(new Book("Pride and Prejudice", Pride));
        fxBooks.add(new Book("Moby Dick", Moby));
        fxBooks.add(new Book("Gatsby", Gatsby));
        fxBooks.add(new Book("Frankenstein", Frankenstein));
        fxBooks.add(new Book("The Tale of Two Cities", TheTaleOfTwoCities));
        fxBooks.add(new Book("Of Mice and Men", OfMiceAndMen));

        System.out.println("books are made");
    }

}
