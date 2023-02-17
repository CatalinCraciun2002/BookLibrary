package UsableClasses;

public abstract class User {

    public final static int ADMIN = 2;
    public final static int STAFF = 1;
    public final static int MEMBER = 0;
    private final String username;
    private final String firstName;
    private final String lastName;


    public User(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public abstract int getSecurityLevel();


}
