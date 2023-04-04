package hi.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    @Test
    public void testStudent() {
        Student student = new Student("John Doe", true);
        assertEquals("Student with feePaid true should return true", true, student.isFeePaid());
    }
}
