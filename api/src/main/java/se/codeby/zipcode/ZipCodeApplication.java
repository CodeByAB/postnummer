package se.codeby.zipcode;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.Getter;
import se.codeby.zipcode.clients.OpenStreetMapClient;
import se.codeby.zipcode.clients.PostNordClient;
import se.codeby.zipcode.health.ZipCodeHealthCheck;
import se.codeby.zipcode.resources.ZipCodeResource;

@Getter
public class ZipCodeApplication extends Application<ZipCodeConfiguration> {

    private OpenStreetMapClient openStreetMapClient;
    private PostNordClient postNordClient;

    public static void main(final String... args) throws Exception {
        new ZipCodeApplication().run(args);
    }

    @Override
    public String getName() {
        return "zip-code-service";
    }

    @Override
    public void initialize(final Bootstrap<ZipCodeConfiguration> bootstrap) {
    }

    @Override
    public void run(final ZipCodeConfiguration configuration, final Environment environment) {
        this.postNordClient = PostNordClient.builder().environment(environment).configuration(configuration.postNordClient).build();
        this.openStreetMapClient = OpenStreetMapClient.builder().environment(environment).configuration(configuration.openStreetMapClient).build();

        environment.healthChecks().register(getName(), new ZipCodeHealthCheck());
        environment.jersey().register(new ZipCodeResource(this));
    }
}
