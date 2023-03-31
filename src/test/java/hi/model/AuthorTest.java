package hi.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthorTest {
    @Test
    public void testAuthor() {
        Author author1 = new Author("John Doe");
        assertEquals("Author with name John Doe should return John Doe", "John Doe", author1.getName());

        author1.setName("Jane Doe");
        assertEquals("Author with name Jane Doe should return Jane Doe", "Jane Doe", author1.getName());



    }
}
