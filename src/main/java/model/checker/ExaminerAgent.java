package model.checker;

/**
 * Ping host specified in {@see model.checker.StatusCheckConfiguration}
 * and represent result in {@see model.checker.StatusCheckFromAgentResult}
 * Agent can be local or proxy and call remote agent server
 * Configuration of agent contains in {@see model.checker.ExaminerAgentConfiguration}
 */
public interface ExaminerAgent {
    StatusCheckFromAgentResult checkServers(StatusCheckConfiguration statusCheckConfiguration);
    void setExaminerAgentConfiguration(ExaminerAgentConfiguration examinerAgentConfiguration);
    ExaminerAgentConfiguration getExaminerAgentConfiguration();
}
