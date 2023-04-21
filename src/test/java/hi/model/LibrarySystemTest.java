package hi.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibrarySystemTest {

    @Test
    public void testLibrary() throws UserOrBookDoesNotExistException {
        LibrarySystem model = new LibrarySystem();
        model.addStudentUser("Egill", true);
        Student s1 = model.findStudent("Egill");
        model.setCurrentUser(s1);
        assertEquals("Current user set to Student Egill, should return student Egill", s1.toString(), ((Student)model.getCurrentUser()).toString());

        ArrayList<Author> LifeOfPieAuthors = new ArrayList<>();
        LifeOfPieAuthors.add(new Author("Harper Lee"));
        Book b1;
        try {
            b1 = new Book("Life of Pi", LifeOfPieAuthors);
            model.borrowBook(b1);
            Lending l1 = new Lending(model.getCurrentUser(), b1);
            assertEquals("When book is borrowed, lending should be created in lendings list in LibrarySystem", model.getLendings().get(0).toString(), l1.toString());
            assertEquals("When book is borrowed, lending should be added to User's lendings list in User", model.getCurrentUser().getLendings().get(0).toString(), l1.toString());

        } catch (EmptyAuthorListException e) {
            e.printStackTrace();
        }
        model.addFacultyMemberUser("Lilja", "Computer Science");
        FacultyMember f1 = model.findFacultyByName("Lilja");
        assertEquals("Find Faculty should return name Lilja when found", "Lilja", f1.getName());
        assertEquals("Find Faculty should return department Computer Science when found", "Computer Science", f1.getDepartmentString());
    }
}