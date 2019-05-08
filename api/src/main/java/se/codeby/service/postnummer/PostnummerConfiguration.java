package se.codeby.service.postnummer;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import se.codeby.service.postnummer.clients.ClientConfiguration;

import javax.validation.constraints.NotNull;

@SuppressWarnings("WeakerAccess")
public class PostnummerConfiguration extends Configuration {

    @NotNull
    @JsonProperty("postNordClient")
    public ClientConfiguration postNordClient = ClientConfiguration.builder().build();

    @NotNull
    @JsonProperty("openStreetMapClient")
    public ClientConfiguration openStreetMapClient = ClientConfiguration.builder().build();
}