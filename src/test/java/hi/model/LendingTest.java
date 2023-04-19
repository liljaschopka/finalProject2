package hi.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
public class LendingTest {

    @Test
    public void testLending() throws EmptyAuthorListException {
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("John Doe"));
        Book book = new Book("Life of Pi", authors);
        FacultyMember user1 = new FacultyMember("Egill", "Computer Science");
        Lending lending = new Lending(user1, book);
        assertEquals("Lending with the book Life of Pi should return Life of Pi", book, lending.getBook());
        assertEquals("Lending with user Egill shold return user Egill", user1, lending.getUser());
    }

}
