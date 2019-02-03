package model.checker;

import java.util.List;

/**
 * Contains all results {@see model.checker.StatusCheckFromAgentResult} from
 * {@see model.checker.ExaminerAgent} about hosts statuses
 */
public class OverallStatusCheckResult {
    private List<StatusCheckFromAgentResult> statusCheckFromAgentResultList;

    public List<StatusCheckFromAgentResult> getStatusCheckFromAgentResultList() {
        return statusCheckFromAgentResultList;
    }

    public void setStatusCheckFromAgentResultList(List<StatusCheckFromAgentResult> statusCheckFromAgentResultList) {
        this.statusCheckFromAgentResultList = statusCheckFromAgentResultList;
    }
}
