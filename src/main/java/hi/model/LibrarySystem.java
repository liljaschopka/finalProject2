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
    private User currentUser = null;

    public LibrarySystem() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.lendings = new ArrayList<>();
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void addBookWithTitleAndAuthorlist(String title, List<Author> authors) throws EmptyAuthorListException {
        books.add(new Book(title, authors));
    }

    public void addStudentUser(String name, boolean feePaid) {
        if (feePaid == true) {
            users.add(new Student(name, true));
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


    public Student findStudent(String name) throws UserOrBookDoesNotExistException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name) && users.get(i) instanceof Student) {
                return (Student) users.get(i);
            }
        }
        throw new UserOrBookDoesNotExistException("The user does not exist");
    }

    public FacultyMember findFacultyByName(String name) throws UserOrBookDoesNotExistException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name) && users.get(i) instanceof FacultyMember) {
                return (FacultyMember) users.get(i);
            }
        }
        throw new UserOrBookDoesNotExistException("The user does not exist");
    }

    public FacultyMember findFaculty(String name, String department) throws UserOrBookDoesNotExistException {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user instanceof FacultyMember) {
                FacultyMember userFac = (FacultyMember) user;
                if (userFac.getName().equals(name) && userFac.getDepartment().equals(department)) {
                    return userFac;
                }
            }
        }
        throw new UserOrBookDoesNotExistException("The user does not exist");
    }

    public void borrowBook(Book book) {
        Lending lending = new Lending(currentUser, book);
        lendings.add(lending);
        currentUser.addLending(lending);
    }

    public void extendLending(Lending lending) {
        LocalDate newDueDate = lending.getDueDate().plusDays(30);
        if (currentUser instanceof FacultyMember) {
            FacultyMember faculty = (FacultyMember) currentUser;
            for (int i = 0; i < lendings.size(); i++) {
                if (lendings.get(i).getUser().getName().equals(faculty.getName()) && lendings.get(i).getBook().getTitle().equals(lending.getBook().getTitle())) {
                    lendings.get(i).setDueDate(newDueDate);
                    System.out.println("Lending extended in model");
                }
            }
            for (int i = 0; i < faculty.getLendings().size(); i++) {
                if (faculty.getLendings().get(i).equals(lending)) {
                    faculty.getLendings().get(i).setDueDate(newDueDate);
                    System.out.println("Lending extended in User");
                }
            }
        }

    }


    public void returnBook(Book book) throws UserOrBookDoesNotExistException {
        for (int i = 0; i < lendings.size(); i++) {
            if (lendings.get(i).getUser().getName().equals(currentUser.getName()) && lendings.get(i).getBook().getTitle().equals(book.getTitle())) {
                lendings.remove(i);
            }
        }
    }


    public ObservableList<Book> getFxBooks() {
        return fxBooks;
    }

    public List<Lending> getLendings() {
        return lendings;
    }

    public void setBooks() {
        try {
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
        } catch (Exception e) {
            System.out.println("books are not made");
        }
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
        try {
            fxBooks.add(new Book("To Kill a Mockingbird", Mockingbird));
            fxBooks.add(new Book("Pride and Prejudice", Pride));
            fxBooks.add(new Book("Moby Dick", Moby));
            fxBooks.add(new Book("Gatsby", Gatsby));
            fxBooks.add(new Book("Frankenstein", Frankenstein));
            fxBooks.add(new Book("The Tale of Two Cities", TheTaleOfTwoCities));
            fxBooks.add(new Book("Of Mice and Men", OfMiceAndMen));

            System.out.println("books are made");
        } catch (Exception e) {
            System.out.println("books are not made");
        }
    }

}
