package UsableClasses;

public class Staff extends User {

    public Staff(String username, String firstName, String lastName) {
        super(username, firstName, lastName);
    }

    @Override
    public int getSecurityLevel() {
        return STAFF;
    }

}
