package model.checker;

import java.util.List;

/**
 * Result of ping all hosts done by one {@see model.checker.ExaminerAgent}
 */
public class StatusCheckFromAgentResult {
    private List<StatusCheckResultItem> statusCheckResultItemList;
    private ExaminerAgentConfiguration examinerAgentConfiguration;
    private String serverDescription;

    public ExaminerAgentConfiguration getExaminerAgentConfiguration() {
        return examinerAgentConfiguration;
    }

    public void setExaminerAgentConfiguration(ExaminerAgentConfiguration examinerAgentConfiguration) {
        this.examinerAgentConfiguration = examinerAgentConfiguration;
    }

    public List<StatusCheckResultItem> getStatusCheckResultItemList() {
        return statusCheckResultItemList;
    }

    public void setStatusCheckResultItemList(List<StatusCheckResultItem> statusCheckResultItemList) {
        this.statusCheckResultItemList = statusCheckResultItemList;
    }

    public String getServerDescription() {
        return serverDescription;
    }

    public void setServerDescription(String serverDescription) {
        this.serverDescription = serverDescription;
    }
}
