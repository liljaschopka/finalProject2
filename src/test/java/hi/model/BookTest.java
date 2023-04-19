package hi.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookTest {
    @Test
    public void testBook() throws EmptyAuthorListException {
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("John Doe"));
        authors.add(new Author("Jane Doe"));
        Book book1 = new Book("Life of Pi", authors);

        assertEquals("Book with title Life of Pi should return Life of Pi", "Life of Pi", book1.getTitle());
        assertEquals("Book with ArrayList authors should return authors", authors, book1.getAuthors());
    }

    /*@Test (expected = EmptyAuthorListException.class)
    public void testBookWithEmptyAuthorList() throws EmptyAuthorListException {
        ArrayList<Author> authors = new ArrayList<>();
        Book book1 = new Book("Life of Pi", authors);*/
}

