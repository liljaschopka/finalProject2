package hi.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FacultyMember extends User {

    private StringProperty department = new SimpleStringProperty();

    private String departmentString;

    public FacultyMember(String name, String dm) {
        super(name);
        department.set(dm);
        departmentString = dm;
    }

    public String getDepartment() {
        return department.get();
    }

    public String getDepartmentString() {
        return departmentString;
    }

    public void setDepartment(String dm) {
        department.set(dm);
    }

    public StringProperty departmentProperty() {
        return department;
    }

    public void extendLending(Lending l) {
        for(int i = 0; i < lendings.size(); i++) {
            if(lendings.get(i).getBook().equals(l.getBook())) {
                lendings.get(i).setDueDate(l.getDueDate().plusDays(30));
            }
        }
    }
}
