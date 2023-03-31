package hi.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FacultyMemberTest {
    @Test
    public void testFacultyMember() {
        FacultyMember facultyMember1 = new FacultyMember("John Doe", "Computer Science");
        assertEquals("FacultyMember with name John Doe should return John Doe", "John Doe", facultyMember1.getName());
        assertEquals("FacultyMember with department Computer Science should return Computer Science", "Computer Science", facultyMember1.getDepartment());
    }
}
