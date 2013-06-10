package entities;

/**
 * Created with IntelliJ IDEA.
 * Mitioglov Boris
 */
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="Users")
public class UserEntity {

    public UserEntity(){

    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    public Long getId() {
        return id;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    @Column(name="birthday")
    public String getBirthday() {

        return birthday;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    @Column(name="email")
    public String getEmail() {

        return email;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    @Column(name="phone")
    public String getPhone() {

        return phone;
    }

    public void setSecondName(String secondName) {

        this.secondName = secondName;
    }

    @Column(name="secondName")
    public String getSecondName() {

        return secondName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    @Column(name="firstName")
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
