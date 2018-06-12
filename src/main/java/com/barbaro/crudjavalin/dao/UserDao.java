/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barbaro.crudjavalin.dao;

import com.barbaro.crudjavalin.models.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author leolopez
 */

public class UserDao {
    
    private final Session session;
    
    public UserDao(Session session){
        this.session = session;
    }
    
    public User create(String email, String name){
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setCreatedAt(new Date());
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        return user;
    }
    
    public List<User> list(){
        List<User> list = new ArrayList<>();
        list = session.createQuery("from User").list();
        return list;
    }
    
    public User get(String id){
        User user = (User) session.createQuery("from User U where U.id = :user_id")
                .setParameter("user_id", Integer.parseInt(id))
                .uniqueResult();
        return user;
    }
    
    public void delete(String id){
        User user = (User) session.createQuery("from User U where U.id = :user_id")
                .setParameter("user_id", Integer.parseInt(id))
                .uniqueResult();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }
    
    public User update(String id, String name){
        User user = (User) session.createQuery("from User U where U.id = :user_id")
                .setParameter("user_id", Integer.parseInt(id))
                .uniqueResult();
        user.setName(name);
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        return user;
    }
}
