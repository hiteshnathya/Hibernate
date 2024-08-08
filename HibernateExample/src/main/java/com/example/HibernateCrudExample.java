package com.example;
 
import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.util.HibernateUtil;
 
import java.util.List;
 
public class HibernateCrudExample {
 
   public static void main(String[] args) {
       UserDao userDao = new UserDao();
 
       // Create
       userDao.saveUser(new User("Hitesh", "nathya", "hiteshnathya@gmail.com"));
       userDao.saveUser(new User("Santosh", "Kumar", "santosh@gmail.com"));
 
       // Read
       List<User> users = userDao.getUsers();
       users.forEach(System.out::println);
 
       // Update
       User user = users.get(0);
       user.setFirstName("Hitesh");
       userDao.updateUser(user);
 
       // Delete
       userDao.deleteUser(user.getId());
 
       // Read
       users = userDao.getUsers();
       users.forEach(System.out::println);
 
       // Shutdown Hibernate
       HibernateUtil.shutdown();
   }
}
 
