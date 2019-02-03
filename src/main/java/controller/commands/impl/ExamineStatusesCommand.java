package controller.commands.impl;

import controller.commands.Command;
import controller.commands.CommandConstants;
import model.checker.*;
import model.checker.utils.ResultUtils;
import model.config.ConfigurationManagerBeanNames;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("getResult")
public class ExamineStatusesCommand implements Command {

    @Autowired
    // @Qualifier(ConfigurationManagerBeanNames.JAVA_CONFIGURATION_MANAGER_BEAN)
    @Qualifier(ConfigurationManagerBeanNames.DATABASE_CONFIGURATION_MANAGER_BEAN)
    // Can be configuration manager that read config from DataBase, XML, Json
    private ConfigurationManager<StatusCheckConfiguration> revisionConfigurationConfigurationManager;

    @Autowired
    private StatusCheckOrchestrator statusCheckOrchestrator;

    @Autowired
    private ExaminerAgentFactory examinerAgentFactory;

    @Autowired
    ResultUtils resultUtils;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        StatusCheckConfiguration statusCheckConfiguration = revisionConfigurationConfigurationManager.getConfiguration();
        OverallStatusCheckResult overallStatusCheckResult = statusCheckOrchestrator.checkServers(statusCheckConfiguration);

        JSONObject jsonObject = resultUtils.adaptToJson(overallStatusCheckResult);
        jsonObject.writeJSONString(response.getWriter());

        return CommandConstants.JSON_RESPONSE;
    }

    @PostConstruct
    private void initRevisorServer() {
        ExaminerAgent localExaminerAgent = examinerAgentFactory.build();
        statusCheckOrchestrator.addExaminerAgent(localExaminerAgent);
    }
}
