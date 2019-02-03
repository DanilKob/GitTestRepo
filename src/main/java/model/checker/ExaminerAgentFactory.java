package model.checker;

import java.util.List;

/**
 * Build {@see model.checker.ExaminerAgent} and set its configuration
 * if no configuration given build Agent on local server {@see model.checker.impl.LocalExaminerAgent}
 */
public interface ExaminerAgentFactory {
    ExaminerAgent build();
    ExaminerAgent build(ExaminerAgentConfiguration examinerAgentConfiguration);
    List<ExaminerAgent> build(OverallExaminerAgentsConfiguration overallExaminerAgentsConfiguration);
}
