package DAOpackage.DAOImpl;

/**
 * Created with IntelliJ IDEA.
 * Author: Mitioglov Boris
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import HibernateUtilities.HibernateUtil;
import DAOpackage.UserDAO;
import entities.UserEntity;

public class UserDAOImpl implements UserDAO {

    public long addUser(UserEntity user) throws SQLException {
        Session session = null;
        long id = 0;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            id = user.getId();
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return id;
    }

    public void updateUser(UserEntity user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public UserEntity getUserById(Long id) throws SQLException {
        Session session = null;
        UserEntity user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user = (UserEntity) session.load(UserEntity.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    public List<UserEntity> getAllUsers() throws SQLException {
        Session session = null;
        List<UserEntity> studs = new ArrayList<UserEntity>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            studs = session.createCriteria(UserEntity.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return studs;
    }

    public void deleteUser(UserEntity user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}