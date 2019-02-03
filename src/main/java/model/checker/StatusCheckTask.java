package model.checker;

import javax.persistence.*;
import java.net.URL;

@Entity
@Table(name = "check_task")
public class StatusCheckTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "url")
    private URL url;
    @Column(name = "critical_timeout")
    private int criticalTimeout;
    @Column(name ="error_timeout")
    private int errorTimeout;
    @Column(name = "min_content_size")
    private int minContentSize;
    @Column(name = "max_content_size")
    private int maxContentSize;

    public StatusCheckTask(){

    }

    public StatusCheckTask(URL url, int criticalTimeout, int errorTimeout, int minContentSize, int maxContentSize) {
        this.url = url;
        this.criticalTimeout = criticalTimeout;
        this.errorTimeout = errorTimeout;
        this.minContentSize = minContentSize;
        this.maxContentSize = maxContentSize;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public int getCriticalTimeout() {
        return criticalTimeout;
    }

    public void setCriticalTimeout(int criticalTimeout) {
        this.criticalTimeout = criticalTimeout;
    }

    public int getErrorTimeout() {
        return errorTimeout;
    }

    public void setErrorTimeout(int errorTimeout) {
        this.errorTimeout = errorTimeout;
    }

    public int getMinContentSize() {
        return minContentSize;
    }

    public void setMinContentSize(int minContentSize) {
        this.minContentSize = minContentSize;
    }

    public int getMaxContentSize() {
        return maxContentSize;
    }

    public void setMaxContentSize(int maxContentSize) {
        this.maxContentSize = maxContentSize;
    }
}
