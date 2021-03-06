package org.jobrunr.tests.e2e;

import org.jobrunr.storage.SimpleStorageProvider;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.utils.mapper.jackson.JacksonJsonMapper;

import javax.sql.DataSource;

public class Main extends AbstractSqlMain {

    public static void main(String[] args) throws Exception {
        new Main(args);
    }

    public Main(String[] args) throws Exception {
        super(args);
    }

    @Override
    protected StorageProvider initStorageProvider() {
        return new SimpleStorageProvider()
                .withJsonMapper(new JacksonJsonMapper())
                .withDefaultData()
                .withSomeRecurringJobs();
    }

    @Override
    protected DataSource createDataSource(String jdbcUrl, String userName, String password) {
        throw new UnsupportedOperationException("should not happen, we use in memory storage provider");
    }
}
