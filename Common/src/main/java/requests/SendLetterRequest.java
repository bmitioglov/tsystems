package requests;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Author: Mitioglov Boris
 */
public class SendLetterRequest implements Serializable {

    public String from;
    public String to;
    public String date;
    public String subject;
    public String body;
}
