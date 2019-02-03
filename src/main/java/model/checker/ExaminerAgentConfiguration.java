package model.checker;

import java.util.Objects;

/**
 * Configuration of {@see model.checker.ExaminerAgent}
 */
public class ExaminerAgentConfiguration {
    private String host;
    private int port;
    private boolean isActive;

    public ExaminerAgentConfiguration() {

    }

    public ExaminerAgentConfiguration(String host, int port, boolean isActive) {
        this.host = host;
        this.port = port;
        this.isActive = isActive;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExaminerAgentConfiguration that = (ExaminerAgentConfiguration) o;
        return port == that.port &&
                host.equals(that.host);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port);
    }
}
