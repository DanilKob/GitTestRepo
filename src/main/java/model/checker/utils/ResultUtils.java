package model.checker.utils;

import model.checker.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResultUtils {
    public JSONObject adaptToJson(OverallStatusCheckResult overallStatusCheckResult) {
        JSONObject jsonObject = new JSONObject();

        JSONArray jsonArray = new JSONArray();

        List<JSONObject> serverResults = overallStatusCheckResult.getStatusCheckFromAgentResultList()
                .stream()
                .map(this::serverResultToJson)
                .collect(Collectors.toList());

        jsonArray.addAll(serverResults);
        jsonObject.put(JsonResponseContants.RESULT, jsonArray);
        return jsonObject;
    }


    private JSONObject serverResultToJson(StatusCheckFromAgentResult statusCheckFromAgentResult) {
        List<JSONObject> jsonObjects = statusCheckFromAgentResult.getStatusCheckResultItemList()
                .stream()
                .map(this::serverResultItemToJson)
                .collect(Collectors.toList());

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        ExaminerAgentConfiguration agentConfiguration = statusCheckFromAgentResult.getExaminerAgentConfiguration();
        String agentIp = agentConfiguration.getHost();

        jsonArray.addAll(jsonObjects);
        jsonObject.put(JsonResponseContants.AGENT_RESULTS, jsonArray);
        jsonObject.put(JsonResponseContants.AGENT_IP, agentIp);

        return jsonObject;
    }

    private JSONObject serverResultItemToJson(StatusCheckResultItem statusCheckResultItem) {
        StatusCheckTask statusCheckTask = statusCheckResultItem.getStatusCheckTask();
        String url = statusCheckTask.getUrl().toString();
        int criticalTimeout = statusCheckTask.getCriticalTimeout();
        int errorTimeout = statusCheckTask.getErrorTimeout();

        int responseCode = statusCheckResultItem.getResponseCode();
        double responseTime = statusCheckResultItem.getResponseTime();
        String status = statusCheckResultItem.getResponseStatus().toString();

        JSONObject jsonObject = new JSONObject();

        jsonObject.put(JsonResponseContants.URL, url);
        jsonObject.put(JsonResponseContants.CRITICAL_TIMEOUT, criticalTimeout);
        jsonObject.put(JsonResponseContants.ERROR_TIMEOUT, errorTimeout);
        jsonObject.put(JsonResponseContants.RESPONSE_CODE, responseCode);
        jsonObject.put(JsonResponseContants.RESPONSE_TIME, responseTime);
        jsonObject.put(JsonResponseContants.STATUS, status);

        return jsonObject;
    }
}
