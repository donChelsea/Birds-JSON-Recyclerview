package android.example.com.jsonparsinghw;

public class Bird {
    private String family;
    private Members members;

    public Bird() {}

    public Bird(String family, Members members) {
        this.family = family;
        this.members = members;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getMembers() {
        return members.toString();
    }

    public void setMembers(Members members) {
        this.members = members;
    }
}
