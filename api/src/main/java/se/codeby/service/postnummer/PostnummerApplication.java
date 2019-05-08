package se.codeby.service.postnummer;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.Getter;
import org.jdbi.v3.core.Jdbi;
import se.codeby.service.postnummer.clients.OpenStreetMapClient;
import se.codeby.service.postnummer.health.PostnummerHealthCheck;
import se.codeby.service.postnummer.resources.PostnummerResource;
import se.codeby.service.postnummer.clients.PostNordClient;

@Getter
public class PostnummerApplication extends Application<PostnummerConfiguration> {

    private OpenStreetMapClient openStreetMapClient;
    private PostNordClient postNordClient;
    private Jdbi jdbi;

    public static void main(final String... args) throws Exception {
        new PostnummerApplication().run(args);
    }

    @Override
    public String getName() {
        return "postnummer-service";
    }

    @Override
    public void initialize(final Bootstrap<PostnummerConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<PostnummerConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(PostnummerConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(final PostnummerConfiguration configuration, final Environment environment) {
        this.jdbi = new JdbiFactory().build(environment, configuration.getDataSourceFactory(), getName());
        this.postNordClient = PostNordClient.builder().environment(environment).configuration(configuration.postNordClient).build();
        this.openStreetMapClient = OpenStreetMapClient.builder().environment(environment).configuration(configuration.openStreetMapClient).build();

        environment.healthChecks().register(getName(), new PostnummerHealthCheck());
        environment.jersey().register(new PostnummerResource(this));
    }
}
