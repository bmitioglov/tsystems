package HibernateUtilities; /**
 * Created with IntelliJ IDEA.
 * Mitioglov Boris
 */

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            //creates the session factory from hibernate.cfg.xml
            String workingDir = System.getProperty("user.dir");
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (ExceptionInInitializerError ex) {
            System.out.println("Initial SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Gets hiberante session factory that was initialized at application startup.
     *
     * @return hibernate session factory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}