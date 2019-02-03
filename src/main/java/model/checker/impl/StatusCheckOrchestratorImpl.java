package model.checker.impl;

import model.checker.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class StatusCheckOrchestratorImpl implements StatusCheckOrchestrator {

    private Map<ExaminerAgentConfiguration, ExaminerAgent> examinerAgentMap = new HashMap<>();

    @Override
    public OverallStatusCheckResult checkServers(StatusCheckConfiguration statusCheckConfiguration) {
        List<StatusCheckFromAgentResult> statusCheckFromAgentResults = examinerAgentMap.values()
                .stream()
                .map(examinerAgent -> examinerAgent.checkServers(statusCheckConfiguration))
                .collect(Collectors.toList());
        OverallStatusCheckResult overallStatusCheckResult = new OverallStatusCheckResult();
        overallStatusCheckResult.setStatusCheckFromAgentResultList(statusCheckFromAgentResults);
        return overallStatusCheckResult;
    }

    @Override
    public void addExaminerAgent(ExaminerAgent examinerAgent) {
        examinerAgentMap.put(examinerAgent.getExaminerAgentConfiguration(), examinerAgent);
    }

    @Override
    public void update(ExaminerAgent examinerAgent) {
        examinerAgentMap.put(examinerAgent.getExaminerAgentConfiguration(), examinerAgent);
    }
}
