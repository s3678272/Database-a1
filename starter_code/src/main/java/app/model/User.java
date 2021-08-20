package app.model;

public class User {
    private String email;
    private String password;
    private String fullName;
    private String screenName;
    private String dateOfBrith;
    private String gender;
    private String status;
    private String location;

    public User(){
    }

    public User(String email, String password, String fullName, String screenName, 
        String dateOfBrith, String gender, String status, String location){
            this.email = email;
            this.password = password;
            this.fullName = fullName;
            this.screenName = screenName;
            this.dateOfBrith = dateOfBrith;
            this.gender = gender;
            this.status = status;
            this.location = location;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getFullName(){
        return fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public String getScreenName(){
        return screenName;
    }

    public void setScreenName(String screenName){
        this.screenName = screenName;
    }

    public String getDateOfBrith(){
        return dateOfBrith;
    }

    public void setDateOfBrith(String dateOfBrith){
        this.dateOfBrith = dateOfBrith;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }
}

