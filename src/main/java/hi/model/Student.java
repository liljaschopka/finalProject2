package hi.model;

public class Student extends User {

    boolean feePaid;

    public Student(String name, boolean feePaid) {
        super(name);
        this.feePaid = feePaid;
    }

    public boolean isFeePaid() {
        return feePaid;
    }

    public void setFeePaid(boolean feePaid) {
        this.feePaid = feePaid;
    }
}
