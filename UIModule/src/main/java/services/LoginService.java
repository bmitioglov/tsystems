package services;

import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Mitioglov Boris
 */
public class LoginService {
    public LoginService(Socket s){
        this.socket = s;
    }

    private  Socket socket;
}
