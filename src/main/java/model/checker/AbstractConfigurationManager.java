package model.checker;

public abstract class AbstractConfigurationManager<T> implements ConfigurationManager<T>, Cached {
    private boolean isCashed;

    @Override
    public T getConfiguration() {
        if (isCashed) {
            return this.getFromCache();
        }

        return getConfiguration();
    }

    @Override
    public void setCache(boolean isCached) {
        this.isCashed = isCached;
    }

    protected abstract T getFromCache();
    protected abstract T loadFromRepository();
}
