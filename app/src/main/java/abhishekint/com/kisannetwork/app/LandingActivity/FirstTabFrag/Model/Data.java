package abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhishek on 09-06-2018.
 */

public class Data {
    List<String> firstname=new ArrayList<>();
    List<String> lastname=new ArrayList<>();
    List<String> phone=new ArrayList<>();

    public List<String> getFirstname() {
        return firstname;
    }

    public void setFirstname(List<String> firstname) {
        this.firstname = firstname;
    }

    public List<String> getLastname() {
        return lastname;
    }

    public void setLastname(List<String> lastname) {
        this.lastname = lastname;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }
}
