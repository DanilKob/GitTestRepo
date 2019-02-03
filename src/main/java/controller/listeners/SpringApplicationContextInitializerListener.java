package controller.listeners;

import controller.SpringContexConstants;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SpringApplicationContextInitializerListener implements ServletContextListener {

    private ClassPathXmlApplicationContext context;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.context = new ClassPathXmlApplicationContext(SpringContexConstants.CONFIGURATION_XML_PATH);
        servletContextEvent.getServletContext().setAttribute(SpringContexConstants.APPLICATION_CONTEXT, context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        this.context.close();
    }
}
