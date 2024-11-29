package com.jbk.dao;

import com.jbk.entities.JobApplication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JobApplicationDaoImpl implements JobApplicationDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int saveApplication(JobApplication jobApplication) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            JobApplication existingApplication = session.get(JobApplication.class, jobApplication.getId());
            if (existingApplication == null) {
                session.save(jobApplication);
                transaction.commit();
                return 1;           // Application saved successfully.
            } else {
                return 2; // Application already exists.
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 3; // Error occurred due to an exception.
        }
    }

    @Override
    public int updateApplicationStatus(int id, String status) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            JobApplication application = session.get(JobApplication.class, id);
            if (application != null) {
                application.setStatus(status);
                session.update(application);
                transaction.commit();
                return 1; // Status updated successfully
            } else {
                return 2; // Application not found
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return 3; // Error occurred
        }
    }

    @Override
    public int deleteApplication(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            JobApplication application = session.get(JobApplication.class, id);
            if (application != null) {
                session.delete(application);
                transaction.commit();
                return 1; // Application deleted successfully
            } else {
                return 2; // Application not found
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return 3; // Error occurred
        }
    }
}