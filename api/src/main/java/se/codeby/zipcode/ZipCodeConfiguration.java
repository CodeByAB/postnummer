package se.codeby.zipcode;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import se.codeby.zipcode.clients.ClientConfiguration;

import javax.validation.constraints.NotNull;

@SuppressWarnings("WeakerAccess")
public class ZipCodeConfiguration extends Configuration {

    @NotNull
    @JsonProperty("postNordClient")
    public ClientConfiguration postNordClient = ClientConfiguration.builder().build();

    @NotNull
    @JsonProperty("openStreetMapClient")
    public ClientConfiguration openStreetMapClient = ClientConfiguration.builder().build();
}
