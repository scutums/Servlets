/**
 * Created by Alexander on 07.03.2017.
 */
public class Client {

    private String name;
    private String login;
    private String phone;
    private String mail;

    public Client(String name, String login, String phone, String mail) {
        this.name = name;
        this.login = login;
        this.phone = phone;
        this.mail = mail;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
