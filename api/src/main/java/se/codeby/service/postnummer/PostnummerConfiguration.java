package se.codeby.service.postnummer;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import lombok.extern.slf4j.Slf4j;
import se.codeby.service.postnummer.clients.ClientConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;

@SuppressWarnings("WeakerAccess")
@Slf4j
public class PostnummerConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty("database")
    public DataSourceFactory dataSourceFactory = new DataSourceFactory();

    @NotNull
    @JsonProperty("postNordClient")
    public ClientConfiguration postNordClient = ClientConfiguration.builder().build();

    @NotNull
    @JsonProperty("openStreetMapClient")
    public ClientConfiguration openStreetMapClient = ClientConfiguration.builder().build();

    public DataSourceFactory getDataSourceFactory() {
        String databaseUrl = System.getenv("DATABASE_URL");
        if (databaseUrl == null) {
            log.info("Running within local");
            return dataSourceFactory;
        } else {
            log.info("Running within Heroku");
            log.info("Creating DB for " + databaseUrl);

            try {
                URI dbUri = new URI(databaseUrl);
                final String user = dbUri.getUserInfo().split(":")[0];
                final String password = dbUri.getUserInfo().split(":")[1];
                final String url = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

                dataSourceFactory.setUser(user);
                dataSourceFactory.setPassword(password);
                dataSourceFactory.setUrl(url);
                return dataSourceFactory;
            } catch (URISyntaxException e) {
                log.info(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }
}
