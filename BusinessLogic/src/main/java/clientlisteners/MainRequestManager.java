package clientlisteners;



import DAOpackage.Factory;
import HibernateUtilities.HibernateUtil;
import coreobjects.Folder;
import coreobjects.Letter;
import coreobjects.User;
import entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import requests.RegistrationRequest;
import requests.SendLetterRequest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Mitioglov Boris
 */
public class MainRequestManager {

    public static void main(String[] args){
        ServerSocket ss = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

            ss = new ServerSocket(9091); // создаем сокет сервера и привязываем его к порту
            System.out.println("Waiting for a client...");
            Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
            System.out.println("Got a client :) ... Finally, someone saw me through all the cover!");
            Object object;

            while(true) {
                InputStream sin = socket.getInputStream();
                ObjectInputStream in = new ObjectInputStream(sin);
                object = in.readObject();

                if (object instanceof requests.RegistrationRequest)
                {
                    RegistrationRequest registrationRequest = (RegistrationRequest) object;
                    System.out.println("Получен запрос на регистрацию");
                    User result = registerUser(session, registrationRequest);
                    //Отправим ответ
                    OutputStream sout = socket.getOutputStream();
                    ObjectOutputStream out = new ObjectOutputStream(sout);
                    out.writeObject(result);
                }

                if(object instanceof SendLetterRequest)
                {
                    SendLetterRequest sendLetterRequest = (SendLetterRequest) object;
                    System.out.println("Получен запрос на отправку письма");
                    Letter result = sendLetter(session, sendLetterRequest);
                    //Отправим ответ
                    OutputStream sout = socket.getOutputStream();
                    ObjectOutputStream out = new ObjectOutputStream(sout);
                    out.writeObject(result);
                }

                System.out.println("Waiting for the next line...");

            }


        } catch (IOException e) {
            System.out.println("exception in server");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }

    }

    private static User registerUser(Session session, RegistrationRequest request){
        List users = session.createCriteria(UserEntity.class)
                .add(Expression.like("email", request.email))
                .list();
        if (users.size()!=0){
            System.out.println("Пользователь с email = "+((UserEntity) users.get(0)).email+" уже существует");
            return null;
        }
        else
        {
            UserEntity userEntity = new UserEntity();
            userEntity.setFirstName(request.firstName);
            userEntity.setSecondName(request.secondName);
            userEntity.setBirthday(request.birthDate);
            userEntity.setEmail(request.email);
            userEntity.setPhone(request.phone);
            long id = 0;
            try {
                id = Factory.getInstance().getUserDAO().addUser(userEntity);
            } catch (SQLException e) {
                System.out.println("Problem with userEntity");
                return null;
            }
            User user = new User();
            user.firstName = userEntity.firstName;
            user.secondName = userEntity.secondName;
            user.userId = id;

            return user;
        }
    }



    private static Letter sendLetter(Session session, SendLetterRequest request){
//    TODO
    }

    private static List<Letter> receiveLetters(Session session, SendLetterRequest request){
//    TODO
    }

    private static Letter deleteMessage(Session session, SendLetterRequest request){
//    TODO
    }

    private static Folder createFolder(Session session, )




}
