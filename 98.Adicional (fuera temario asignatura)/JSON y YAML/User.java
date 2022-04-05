import java.util.Arrays;

public class User {

    private Preference[] preferences;
    public String name;
    public String email;
    private String[] roles;
    private boolean admin;


    public User() {
    }

    public User(String name, String email, String[] roles, Preference[] preferences, boolean admin) {
        this.name = name;
        this.email = email;
        this.roles = roles;
        this.admin = admin;
        this.preferences = preferences;
    }

    public Preference[] getPreferences() {
        return preferences;
    }

    public void setPreferences(Preference[] preferences) {
        this.preferences = preferences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "preferences=" + Arrays.toString(preferences) +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + Arrays.toString(roles) +
                ", admin=" + admin +
                '}';
    }
}