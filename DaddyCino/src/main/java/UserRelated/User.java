package UserRelated;

import java.util.ArrayList;

public class User {

    private String username;
    private String password;
    private double balance;
    private boolean loggedIn = false;

    public User(String username, String password, double balance){
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void setLoggedIn(boolean loggedIn){
        this.loggedIn = loggedIn;
    }
}
