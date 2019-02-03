package model.config;

import model.checker.ConfigurationManager;
import model.checker.StatusCheckConfiguration;
import model.checker.StatusCheckTask;
import org.springframework.stereotype.Repository;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

@Repository("javaConfigurationManagerBean")
public class JavaClassConfigurationManager implements ConfigurationManager<StatusCheckConfiguration> {

    private StatusCheckConfiguration statusCheckConfiguration = initRevisionConfiguration();

    @Override
    public StatusCheckConfiguration getConfiguration() {
        return this.statusCheckConfiguration;
    }

    @Override
    public void updateConfiguration(StatusCheckConfiguration configuration) {

    }

    private StatusCheckConfiguration initRevisionConfiguration() {
        StatusCheckConfiguration statusCheckConfiguration = new StatusCheckConfiguration();
        List<StatusCheckTask> statusCheckTaskList = new LinkedList<>();
        StatusCheckTask statusCheckTask = new StatusCheckTask();

        try {
            statusCheckTask.setUrl(new URL("https://www.tutorialspoint.com/javascript/javascript_placement.htm"));
            statusCheckTask.setCriticalTimeout(500);
            statusCheckTask.setErrorTimeout(700);
            statusCheckTaskList.add(statusCheckTask);

            statusCheckTask = new StatusCheckTask();
            statusCheckTask.setUrl(new URL("https://sitis.com.ua/about/articles/programma_1s_dlya_chaynikov/"));
            statusCheckTask.setCriticalTimeout(400);
            statusCheckTask.setErrorTimeout(600);
            statusCheckTaskList.add(statusCheckTask);

            statusCheckConfiguration.setStatusCheckTaskList(statusCheckTaskList);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return statusCheckConfiguration;
    }
}
