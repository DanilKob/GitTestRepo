package model.checker;

/**
 * Manage {@see model.checker.ExaminerAgent}
 */
public interface StatusCheckOrchestrator {
    OverallStatusCheckResult checkServers(StatusCheckConfiguration statusCheckConfiguration);

    void addExaminerAgent(ExaminerAgent examinerAgent);

    void update(ExaminerAgent examinerAgent);
}
