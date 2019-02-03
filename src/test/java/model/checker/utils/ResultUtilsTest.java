package model.checker.utils;

import model.checker.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class ResultUtilsTest {

    ResultUtils resultUtils = new ResultUtils();
    OverallStatusCheckResult overallStatusCheckResult;

    @Before
    public void init() throws MalformedURLException {
        overallStatusCheckResult = new OverallStatusCheckResult();
        StatusCheckFromAgentResult statusCheckFromAgentResult = new StatusCheckFromAgentResult();
        StatusCheckResultItem revisionResultItem = new StatusCheckResultItem();
        StatusCheckTask statusCheckTask = new StatusCheckTask();

        statusCheckTask.setCriticalTimeout(500);
        statusCheckTask.setUrl(new URL("https://www.tutorialspoint.com/javascript/javascript_placement.htm"));
        statusCheckTask.setErrorTimeout(700);

        revisionResultItem.setResponseTime(100);
        revisionResultItem.setResponseCode(200);
        revisionResultItem.setResponseStatus(ResponseStatus.OK);
        revisionResultItem.setStatusCheckTask(statusCheckTask);

        List<StatusCheckResultItem> statusCheckResultItemList = new LinkedList<>();

        statusCheckResultItemList.add(revisionResultItem);
        statusCheckResultItemList.add(revisionResultItem);

        statusCheckFromAgentResult.setStatusCheckResultItemList(statusCheckResultItemList);

        List<StatusCheckFromAgentResult> statusCheckFromAgentResultList = new LinkedList<>();

        statusCheckFromAgentResultList.add(statusCheckFromAgentResult);
        statusCheckFromAgentResultList.add(statusCheckFromAgentResult);

        overallStatusCheckResult.setStatusCheckFromAgentResultList(statusCheckFromAgentResultList);
    }

    @Test
    public void adaptToJson() {
        Assert.assertTrue(true);
    }
}