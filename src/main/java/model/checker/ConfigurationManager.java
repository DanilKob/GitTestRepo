package model.checker;

/**
 * @param <T> type of configuration object
 */
public interface ConfigurationManager<T> {
    T getConfiguration();
    void updateConfiguration(T configuration);
}
