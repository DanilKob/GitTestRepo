package model.config;

import model.checker.ConfigurationManager;
import model.checker.StatusCheckConfiguration;
import model.checker.StatusCheckTask;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("databaseConfigurationManagerBean")
public class DataBaseConfigurationManager implements ConfigurationManager<StatusCheckConfiguration> {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public StatusCheckConfiguration getConfiguration() {

        StatusCheckConfiguration statusCheckConfiguration = new StatusCheckConfiguration();
        Session session = sessionFactory.getCurrentSession();
        //session.beginTransaction();
        List<StatusCheckTask> statusCheckTasks = session
                .createQuery("from model.checker.StatusCheckTask", StatusCheckTask.class)
                .getResultList();
        //session.getTransaction().commit();
        statusCheckConfiguration.setStatusCheckTaskList(statusCheckTasks);
        return statusCheckConfiguration;
    }

    @Override
    public void updateConfiguration(StatusCheckConfiguration configuration) {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
