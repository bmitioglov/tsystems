package Entities;

/**
 * Created with IntelliJ IDEA.
 * Mitioglov Boris
 */
import javax.persistence.Entity;

@Entity
public class UserEntity {

    public UserEntity(){

    }

    public Long getId() {
        return id;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {

        return birthday;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getEmail() {

        return email;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public String getPhone() {

        return phone;
    }

    public void setSecondName(String secondName) {

        this.secondName = secondName;
    }

    public String getSecondName() {

        return secondName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Long id;
    public String firstName;
    public String secondName;
    public String phone;
    public String email;
    public String birthday;

}
