package hi.model;

import org.junit.Test;

public class LibrarySystemTest {

    @Test
    public void testLibrary() throws UserOrBookDoesNotExistException {
        LibrarySystem model = new LibrarySystem();
        if(model.getCurrentUser() != null) {
            if(model.getCurrentUser() instanceof Student) {
                System.out.println("Logged in as Student: " +(model.getCurrentUser()).getName());
            }else{
                try{
                    System.out.println("Logged in as: " +(model.getCurrentUser()).getName()+", "+ model.findFacultyByName(model.getCurrentUser().getName()).getDepartment());
                } catch (Exception e){
                    System.out.println("Logged in as: " +(model.getCurrentUser()).getName());
                }
            }
        } else {
            System.out.println("Not signed in, sign in to continue");
        }
    }
}
