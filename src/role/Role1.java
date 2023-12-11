package role;

public class Role1 {

    private String login = "ali@gmail.com";
    private String password = "12345678";

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role1(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Role1(){};
}

