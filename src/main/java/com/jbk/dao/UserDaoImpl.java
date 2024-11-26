package com.jbk.dao;

import com.jbk.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;



@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    //POST API: /user/createUser: Creates a new user record.
    @Override
    public int createUser(User user) {
        try {
            Session session = sessionFactory.openSession ();
            User dbUser = session.get(User.class, user.getUsername());
            if (dbUser == null) {
                session.save(user);
                session.beginTransaction ().commit ();
                return 1; // User successfully created
            } else {
                return 2; // User already exists
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 3; // Error occurred
        }
    }

    //POST API /auth/login: Authenticates a user based on the provided credentials.
    @Override
    public User getUserByUsername(String username) {
        try {
            Session session = sessionFactory.openSession ();
            return session.get(User.class, username); // Assumes username is the primary key
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            Session session = sessionFactory.openSession ();
            return session.createQuery("FROM User", User.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /*@Override
    public User getUserByUsername(String username) {
        try {
            Session session = sessionFactory.getCurrentSession();
            return session.get(User.class, username);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/

    @Override
    public boolean updateUser(User user) {
        try {
            Session session = sessionFactory.openSession ();
            User existingUser = session.get(User.class, user.getUsername());
            if (existingUser != null) {
                session.evict(existingUser); // Optional to detach the existing entity.
                session.update(user);
                session.beginTransaction ().commit ();
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(String username) {
        try {
            Session session = sessionFactory.openSession ();
            User user = session.get(User.class, username);
            if (user != null) {
                session.delete(user);
                session.beginTransaction ().commit ();
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
