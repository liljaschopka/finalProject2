package hi.model;

import java.util.List;

public class Book {

    private String title;
    private List<Author> authors;


    public Book(String title, List<Author> authors) throws EmptyAuthorListException {
        this.title = title;
        this.authors = authors;
        if (authors.isEmpty()) {
            throw new EmptyAuthorListException("The author list is empty");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public String toString() {
        return title + " by " + authors;
    }


}
