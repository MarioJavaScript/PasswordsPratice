package inicios;
public class User{
    private String username;
    private String email;
    private String Password;

    public User(String username, String email, String Password){ //Constructor
        this.username = username;
        this.email = email;
        this.Password = Password;
    }

     String getUsername() {
        return username;
    }
    String getEmail() {
        return email;
    }
    String getPassword() {
        return Password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}