package com.jbk.dao;

import com.jbk.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

    //POST API: /user/login: Authenticates a user based on the provided credentials.
    //GET API: /user/getUser/{username}: Fetches a user by username.
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

    //GET API: /user/allUsers: Retrieves a list of all registered users.
    @Override
    public List<User> getAllUsers() {
        try {
            Session session = sessionFactory.openSession ();
            return session.createQuery("FROM User", User.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();  //Or return no data found.
        }
    }

    //PUT API: /user/updateUser: Updates user details.
    @Override
    public boolean updateUser(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            User existingUser = session.get(User.class, user.getUsername());
            if (existingUser != null) {
                session.evict(existingUser);
                session.update(user);
                transaction.commit();
                return true;
            } else {
                transaction.rollback();
                return false;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    //DELETE API: /user/deleteUser/{username}: Deletes a user by username.
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