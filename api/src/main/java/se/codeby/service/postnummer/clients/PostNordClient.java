package se.codeby.service.postnummer.clients;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Environment;
import lombok.Builder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ResponseProcessingException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@SuppressWarnings("WeakerAccess")
public class PostNordClient {

    private final Client client;
    private final ClientConfiguration configuration;

    @Builder
    private PostNordClient(Environment environment, ClientConfiguration configuration) {
        this.configuration = configuration;
        this.client = new JerseyClientBuilder(environment).using(configuration).build(PostNordClient.class.getName());
    }

    public Location findBy(String countryCode, String zipCode) {
        Response response = client
            .target(configuration.BaseUri)
            .path(String.format("/rest/location/v1/surcharge/%s/%s", countryCode, zipCode))
            .queryParam("service_code", "31")
            .queryParam("apikey", configuration.apiKey.orElseThrow(IllegalStateException::new))
            .request(MediaType.APPLICATION_JSON)
            .buildGet().invoke();

        if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
            return response.readEntity(Location.class);
        } else {
            throw new ResponseProcessingException(response, "Error calling postNord");
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Location {
        public final String postalCode;
        public final String postalCity;
        public final String countryCode;

        @JsonCreator
        public Location(@JsonProperty("postalCode") String postalCode,
                        @JsonProperty("postalCity") String postalCity,
                        @JsonProperty("countryCode") String countryCode) {
            this.postalCode = postalCode;
            this.postalCity = postalCity;
            this.countryCode = countryCode;
        }
    }
}
