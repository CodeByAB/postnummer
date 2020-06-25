package se.codeby.service.postnummer.db;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public class ExternalPostgresJdbiRule extends JdbiRule {

    private final String hostname;
    private final Integer port;
    private final String username;
    private final String password;
    private final String database;

    ExternalPostgresJdbiRule(
        String hostname,
        Integer port,
        String username,
        String password,
        String database) {
        this.hostname = hostname;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database = database;
    }

    @Override
    protected DataSource createDataSource() {
        final PGSimpleDataSource datasource = new PGSimpleDataSource();
        datasource.setServerName(hostname);
        datasource.setPortNumber(port);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(database);
        datasource.setApplicationName("Hermes Unit Tests");
        return datasource;
    }

}
