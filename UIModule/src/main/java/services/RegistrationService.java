package services;

import coreobjects.User;
import requests.RegistrationRequest;

import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Mitioglov Boris
 */
public class RegistrationService {
    public RegistrationService(Socket s){
        this.socket = s;
    }

    public User sendData(RegistrationRequest registrationRequest){
        try {
            System.out.println("Sending request object to server...");
            OutputStream sout = socket.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(sout);
            out.writeObject(registrationRequest);
            out.flush(); // заставляем поток закончить передачу данных.

            //получаем ответ
            InputStream sin = socket.getInputStream();
            ObjectInputStream in = new ObjectInputStream(sin);
            user =  (User) in.readObject();
            System.out.println("user.id in client = "+ user.userId);
            System.out.println();
            return user;
    } catch (Exception e) {
        System.out.println("Ошибка в клиенте при регистрации");
        e.printStackTrace();
        return null;
    }

    }

    private User user;
    private Socket socket;
}
