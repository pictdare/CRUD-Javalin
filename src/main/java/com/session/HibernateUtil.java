package com.session;

import java.io.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Hugo
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static final ThreadLocal localSession;
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        localSession = new ThreadLocal();
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    
    public static Session getLocalSession() {
        Session session = (Session) localSession.get();
        if (session == null) {
            System.out.println("Es null");
            session = sessionFactory.openSession();
            localSession.set(session);
            System.out.println("sesion iniciada");
        }
        return session;
    }
    
    
    /**
     * Closes the Session object assiociated with the current Thread (if any)
     * and sets its Session object to null.
     */
    public static void closeLocalSession() {
        Session session = (Session) localSession.get();
        if (session != null) session.close();
        localSession.set(null);
        System.out.println("sesion cerrada");
    }
    
}
