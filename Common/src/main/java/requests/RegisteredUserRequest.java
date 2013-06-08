package requests;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Mitioglov Boris
 */
public class RegisteredUserRequest implements Serializable {
    public enum requestType{
        GETINBOXLETTERS,
        GETSENTLETTERS,
        GETDELETEDLETTERS
    }


}
