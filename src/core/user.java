package core;

import java.io.Serializable;

public class user implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userName, password;
    private int id;
    private static int userID = 0;

    public user(String userName,String password){

        this.userName = userName;
        this.password = password;
        this.id = ++userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "user{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
