package hi.model;

import org.junit.Test;

public class LibrarySystemTest {

    @Test
    public void testLibrary() throws UserOrBookDoesNotExistException {
        LibrarySystem model = new LibrarySystem();
        model.addStudentUser("Alice", true);
        model.findUserByName("Alice");
    }
}
