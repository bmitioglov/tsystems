package DAOpackage;

import Entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import requests.RegistrationRequest;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * Mitioglov Boris
 */
public class RegistrationDAO {
    public RegistrationDAO(Session session, RegistrationRequest registrationRequest){
        List users = session.createCriteria(UserEntity.class)
                .add(Expression.like("email", registrationRequest.email ))
                .list();
        if (users.size()!=0){
            System.out.println("Пользователь с email = "+((UserEntity) users.get(0)).email+" уже существует");
        }
        else
        {
            UserEntity userEntity = new UserEntity();
            userEntity.setFirstName(registrationRequest.firstName);
            userEntity.setSecondName(registrationRequest.secondName);
            userEntity.setBirthday(registrationRequest.birthDate);
            userEntity.setEmail(registrationRequest.email);
            userEntity.setPhone(registrationRequest.phone);
            session.save(userEntity);//сохранили таблицу, наш id сгенерировался и сразу заполнился
            userEntity = (UserEntity) session.get(UserEntity.class, userEntity.getId());
            System.out.println(userEntity.getId());
        }
//        userEntity.setPageCount(430);
//        session.save(book);
//        session.delete(book);
        session.flush();
        //session.close();
    }
}
