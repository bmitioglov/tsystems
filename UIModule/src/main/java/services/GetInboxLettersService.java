package services;

import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Mitioglov Boris
 */
public class GetInboxLettersService {
    public GetInboxLettersService(Socket s){
        this.socket = s;
    }

    public void sendData(){
//        try {
//            System.out.println("Sending GetInboxLettersRequest to server");
//            OutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
//            dataOutputStream.write("Give me Inbox Letters".getBytes());
//            dataOutputStream.close();
//        } catch (IOException e) {
//            System.out.println("io exception");// do something here
//        }
        try {
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            // Создаем поток для чтения с клавиатуры.
            String line = null;
            System.out.println();

//        while (true) {
            line = "Give me inbox Letters, please"; // ждем пока пользователь введет что-то и нажмет кнопку Enter.
            System.out.println("Sending this line to the server...");
            out.writeUTF(line); // отсылаем введенную строку текста серверу.
            out.flush(); // заставляем поток закончить передачу данных.
            //line = in.readUTF(); // ждем пока сервер отошлет строку текста.
            //System.out.println("The server was very polite. It sent me this : " + line);
            //System.out.println("Looks like the server is pleased with us. Go ahead and enter more lines.");
            System.out.println();
//        }
        } catch (Exception x) {
            System.out.println("Ошибка в клиенте при регистрации");
        }
    }

    private Socket socket;
}
