package hi.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class UserTest {
    @Test
    public void testUser() {
        User user1 = new User("John Doe");
        assertEquals("User with name John Doe should return John Doe", "John Doe", user1.getNameString());
    }
}
