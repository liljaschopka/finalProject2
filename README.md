# Final Project in Hugbúnaðarhönnun og forritun
Our final project is based on the library system assignment. We have made an user interface with Javafx that has most if not all of the functions from the library system class. The user can sign in either as a student or faculty, pick books to lend and then checkout. Then the user can view the books he's currently lending and return them as well. If the user is a faculty member he can also extend his lendings. 

This project is a Maven project, i.e. it uses the standard Maven project structure that your IDE hopefully understands when you git clone it. The provided Maven POM includes the JUnit4 dependency.

The directories in the project: 
- `src/main/java`:
  - `hi/model`: The classes that make up the library system.
  - `hi/userinterface/finalproject2`: The classes that make up the user interface, i.e. the controllers for the scenes as well as a ViewSwitcher and View class. The package also includes two specialised ListView classes.

- `src/test/java/hi`:
  - `model`: Test cases testing the library system classes.
  - `userinterface/finalproject2`: Test cases testing the specialised ListView classes.

- `src/main/resources/hi/userinterface/finalproject2`: The fxml files for the user interface.
