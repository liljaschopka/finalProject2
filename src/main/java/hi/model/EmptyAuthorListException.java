package hi.model;

//throws an exception if the author list is empty
public class EmptyAuthorListException extends Exception {
    private String message;

    public EmptyAuthorListException(String message) {
        this.message = message;
    }
}
