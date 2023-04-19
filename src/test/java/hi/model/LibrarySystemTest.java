package hi.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibrarySystemTest {

    @Test
    public void testLibrary() {
        LibrarySystem model = new LibrarySystem();
        Student s1 = new Student("Egill", true);
        model.setCurrentUser(new Student("Egill", true));
        assertEquals("Current user set to Student Egill, should return student Egill", s1.toString(), ((Student)model.getCurrentUser()).toString());
    }
}