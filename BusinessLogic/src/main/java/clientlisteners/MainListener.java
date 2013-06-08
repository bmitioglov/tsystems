package clientlisteners;



import DAOpackage.RegistrationDAO;
import HibernateUtilities.HibernateUtil;
import coreobjects.User;
import org.hibernate.Session;
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
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

            ss = new ServerSocket(9091); // создаем сокет сервера и привязываем его к порту
            System.out.println("Waiting for a client...");

            Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
            System.out.println("Got a client :) ... Finally, someone saw me through all the cover!");
            System.out.println();


            Object object;
            while(true) {
                InputStream sin = socket.getInputStream();
                ObjectInputStream in = new ObjectInputStream(sin);
                object = in.readObject();
                if (object instanceof requests.RegistrationRequest)
                {
                    RegistrationRequest registrationRequest = (RegistrationRequest) object;
                    System.out.println("Получен запрос на регистрацию");
                    RegistrationDAO registrationDAO = new RegistrationDAO(session, registrationRequest);
                    //TODO: Проверить на наличие в базе и вернуть User. Если такой уже есть, то возвращаем null
                    //TODO: DAO.registerUser(registrationRequest);

                    //Отправим ответ
                    OutputStream sout = socket.getOutputStream();
                    ObjectOutputStream out = new ObjectOutputStream(sout);

                    coreobjects.User user = new User();

                    out.writeObject(user);
                }


                System.out.println("Waiting for the next line...");
                System.out.println();
            }


        } catch (IOException e) {
            System.out.println("exception in server");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }

    }
}
