package UsableClasses;

public class Admin extends User {

    public Admin(String username, String firstName, String lastName) {
        super(username, firstName, lastName);
    }

    @Override
    public int getSecurityLevel() {
        return ADMIN;
    }


}
