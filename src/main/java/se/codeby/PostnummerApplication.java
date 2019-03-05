package se.codeby;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class PostnummerApplication extends Application<PostnummerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new PostnummerApplication().run(args);
    }

    @Override
    public String getName() {
        return "postnummer";
    }

    @Override
    public void initialize(final Bootstrap<PostnummerConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final PostnummerConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
