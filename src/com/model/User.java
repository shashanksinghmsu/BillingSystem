
package com.model;

public class User {
    private int user_id;
    private String user_name;
    private String user_Designation;
    private String password;
    private String email;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_Designation() {
        return user_Designation;
    }

    public void setUser_Designation(String user_Designation) {
        this.user_Designation = user_Designation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{");
        sb.append("user_id=").append(user_id);
        sb.append(", user_name=").append(user_name);
        sb.append(", user_Designation=").append(user_Designation);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append('}');
        return sb.toString();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

 
}
