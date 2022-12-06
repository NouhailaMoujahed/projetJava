/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.User;
import org.hibernate.Session;

import util.HibernateUtil;

/**
 *
 * @author nouha
 */
public class UserService {
    
    public boolean login(String email, String password) {
  Session session = (Session) HibernateUtil.getSessionFactory();
  if (session != null) {
   try {
    User user = (User) session.get(User.class, email);
    if (password.equals(user.getPassword())) {
     System.out.println("User: " + user.toString());
     return true;
    }
   } catch (Exception exception) {
    System.out.println("Exception occred while reading user data: "
      + exception.getMessage());
    return false;
   }

  } else {
   System.out.println("DB server down.....");
  }
  return false;
 }

 public String register(User user) {
  String msg = "Registration unsuccessful, try again.....";
  Session session = (Session) HibernateUtil.getSessionFactory();
  if (session != null) {
   try {
    if (user != null) {
     String email = (String) session.save(user);
     session.beginTransaction().commit();
     msg = "User " + email
       + " created successfully, please login...";
    }
   } catch (Exception exception) {
    System.out.println("Exception occred while reading user data: "
      + exception.getMessage());
   }

  } else {
   System.out.println("DB server down.....");
  }
  System.out.println("msg:" + msg);
  return msg;
 }
}
    

