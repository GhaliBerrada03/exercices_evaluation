package ma.projet.gestion.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory fabriqueSession;

    static {
        try {
            fabriqueSession = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.printf("Echec de la creation de la session factory : " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return fabriqueSession;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
