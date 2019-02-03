package model.checker;

import java.util.List;

/**
 * Contains all host to ping
 * @see StatusCheckTask
 */
public class StatusCheckConfiguration {
    private List<StatusCheckTask> statusCheckTaskList;

    public List<StatusCheckTask> getStatusCheckTaskList() {
        return statusCheckTaskList;
    }

    public void setStatusCheckTaskList(List<StatusCheckTask> statusCheckTaskList) {
        this.statusCheckTaskList = statusCheckTaskList;
    }
}
