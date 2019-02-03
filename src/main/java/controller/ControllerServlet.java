package controller;

import controller.commands.Command;
import controller.commands.CommandConstants;
import controller.response.processors.ResponseProcessor;
import controller.utils.CommandUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {

    private ApplicationContext springApplicationContext;

    @Autowired
    private CommandUtil commandUtil;

    @Override
    public void init() throws ServletException {
        super.init();
        springApplicationContext =
                (ApplicationContext) super.getServletContext().getAttribute(SpringContexConstants.APPLICATION_CONTEXT);
        AutowireCapableBeanFactory autowireCapableBeanFactory = springApplicationContext.getAutowireCapableBeanFactory();
        autowireCapableBeanFactory.autowireBean(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proccesRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proccesRequest(req, resp);
    }

    private void proccesRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String responseStr;
        try {
            String commandBeanName = commandUtil.getCommandBeanName(request);
            Command command = springApplicationContext.getBean(commandBeanName, Command.class);

            responseStr = command.execute(request, response);
        } catch (RuntimeException e) {
            e.printStackTrace();
            responseStr = CommandConstants.REDIRECT + "error.jsp";
        }
        String responseProcessCommandBeanName = commandUtil.getResponseProcessorBeanName(responseStr);
        String responsePage = commandUtil.getResponsePage(responseStr);

        springApplicationContext
                .getBean(responseProcessCommandBeanName, ResponseProcessor.class)
                .process(request, response, responsePage);
    }
}
