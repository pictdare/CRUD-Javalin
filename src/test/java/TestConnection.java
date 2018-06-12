/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.session.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leolopez94
 */
public class TestConnection {
    
    //private Session session;
    
    public TestConnection() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        //session = HibernateUtil.getLocalSession();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void get() {
        System.out.println("En el metodo de prueba");
        /*try{
            System.out.println("En el metodo de prueba");
            
        } catch(HibernateException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            if(session != null){
                HibernateUtil.closeLocalSession();
            }
        }*/
    }
}
