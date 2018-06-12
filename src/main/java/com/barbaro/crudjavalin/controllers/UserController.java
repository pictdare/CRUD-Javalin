/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barbaro.crudjavalin.controllers;

import com.barbaro.crudjavalin.dao.UserDao;
import com.barbaro.crudjavalin.models.User;
import com.session.HibernateUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;

/**
 *
 * @author leolopez94
 */
public class UserController {
    
    public static Object create(String email, String name){
        Session session = null;
        User user = null;
        Map<String, Object> response = new HashMap<>();
        try{
            if(!email.equals("") && !name.equals("")){
                session = HibernateUtil.getLocalSession();
                UserDao dao = new UserDao(session);
                user = dao.create(email, name);
                response.put("user", user);
            } else {
                response.put("status", false);
                response.put("message", "empty values");
            }
        } catch (Exception e){
            e.printStackTrace();
            response.put("status", false);
            response.put("message", e.getMessage());
        } finally {
            if(session != null){
                HibernateUtil.closeLocalSession();
            }
        }
        return response;
    }
    
    public static List<User> list(){
        Session session = null;
        List<User> list = null;
        try{
            session = HibernateUtil.getLocalSession();
            UserDao dao = new UserDao(session);
            list = dao.list();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(session != null){
                HibernateUtil.closeLocalSession();
            }
        }
        return list;
    }
    
    public static Object get(String id){
        Session session = null;
        User user = null;
        Map<String, Object> response = new HashMap<>();
        try{
            session = HibernateUtil.getLocalSession();
            UserDao dao = new UserDao(session);
            user = dao.get(id);
            if(user != null){
                return user;
            } else {
                response.put("status", false);
                response.put("message", "unknown user");
            }
        } catch (Exception e){
            e.printStackTrace();
            response.put("status", false);
            response.put("message", e.getMessage());
        } finally {
            if(session != null){
                HibernateUtil.closeLocalSession();
            }
        }
        return response;
    }
    
    public static Object delete(String id){
        Session session = null;
        Map<String, Object> response = new HashMap<>();
        try{
            session = HibernateUtil.getLocalSession();
            UserDao dao = new UserDao(session);
            dao.delete(id);
            response.put("status", true);
            response.put("message", "success");
        } catch (Exception e){
            e.printStackTrace();
            response.put("status", false);
            response.put("message", "error");
        } finally {
            if(session != null){
                HibernateUtil.closeLocalSession();
            }
        }
        return response;
    }
    
    public static User update(String id, String name){
        Session session = null;
        User user = null;
        try{
            session = HibernateUtil.getLocalSession();
            UserDao dao = new UserDao(session);
            user = dao.update(id, name);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(session != null){
                HibernateUtil.closeLocalSession();
            }
        }
        return user;
    }
}
