package com.jbk.dao;

import com.jbk.entities.JobPosting;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JobPostingDaoImpl implements JobPostingDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int saveJob(JobPosting jobPosting) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            JobPosting dbjobPosting = session.get (JobPosting.class, jobPosting.getId ());
            if (dbjobPosting == null) {
                session.save(jobPosting);
                transaction.commit();
                return 1;
            } else {
                return 2;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 3;
        }
    }

    @Override
    public List<JobPosting> getAllJobs() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM JobPosting", JobPosting.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JobPosting getJobById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(JobPosting.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int deleteJobById(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            JobPosting job = session.get(JobPosting.class, id);
            if (job != null) {
                session.delete(job);
                transaction.commit();
                return 1;
            } else {
                transaction.rollback ( );
                return 2;
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return 3;
        }
    }

    @Override
    public int updateJob(JobPosting jobPosting) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            JobPosting existingJobPosting = session.get(JobPosting.class, jobPosting.getId());
            if (existingJobPosting != null) {
                session.update(jobPosting);
                transaction.commit();
                return 1;
            } else {
                return 2;
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return 3;
        }
    }

    @Override
    public int saveMultipleJobs(List<JobPosting> jobPostings) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            for (JobPosting job : jobPostings) {
                session.save(job);
            }
            transaction.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        }
    }
}
