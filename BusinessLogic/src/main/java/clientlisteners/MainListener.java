package clientlisteners;



import requests.RegistrationRequest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Mitioglov Boris
 */
public class MainListener {
    public static void main(String[] args){
        ServerSocket ss = null;
        try {

            ss = new ServerSocket(9091); // создаем сокет сервера и привязываем его к вышеуказанному порту
            System.out.println("Waiting for a client...");

            Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
            System.out.println("Got a client :) ... Finally, someone saw me through all the cover!");
            System.out.println();


            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            //DataInputStream in = new DataInputStream(sin);
            ObjectInputStream in = new ObjectInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

//            String line = null;
            Object object;
            while(true) {
//                line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
                object = in.readObject();
                if (object instanceof requests.RegistrationRequest)
                {
                    RegistrationRequest registrationRequest = (RegistrationRequest) object;
                    System.out.println("Получен запрос на регистрацию");
                    System.out.println("Имя пользователя: " + registrationRequest.firstName);
                }

                //System.out.println("The client just sent me this line : " + line);
                //out.writeUTF(line); // отсылаем клиенту обратно ту самую строку текста.
                //out.flush(); // заставляем поток закончить передачу данных.
                System.out.println("Waiting for the next line...");
                System.out.println();
            }


        } catch (IOException e) {
            System.out.println("exception in server");
            // do something here
        }
        catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }

    }
}
