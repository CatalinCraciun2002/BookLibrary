package UsableClasses;

public class Member extends User {

    public Member(String username, String firstName, String lastName) {
        super(username, firstName, lastName);
    }

    @Override
    public int getSecurityLevel() {
        return MEMBER;
    }

}
