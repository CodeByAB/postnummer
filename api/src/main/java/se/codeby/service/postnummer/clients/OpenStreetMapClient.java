package se.codeby.service.postnummer.clients;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Environment;
import lombok.Builder;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ResponseProcessingException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class OpenStreetMapClient {

    private final Client client;
    private final ClientConfiguration configuration;

    @Builder
    private OpenStreetMapClient(Environment environment, ClientConfiguration configuration) {
        this.configuration = configuration;
        this.client = new JerseyClientBuilder(environment).using(configuration).build(OpenStreetMapClient.class.getName());
    }

    public Place findBy(String countryCode, String city) {
        Response response = client
            .target(configuration.BaseUri)
            .path("/search")
            .queryParam("format", "json")
            .queryParam("city", city)
            .queryParam("country", countryCode)
            .request(MediaType.APPLICATION_JSON)
            .buildGet().invoke();

        if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
            return Arrays.stream(response.readEntity(Place[].class)).findFirst().orElseThrow(IllegalStateException::new);
        } else {
            throw new ResponseProcessingException(response, "Error calling openStreetMap");
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Place {
        public final long id;
        public final String latitude;
        public final String longitude;
        public final String type;
        public final List<String> names;

        @JsonCreator
        public Place(@JsonProperty("place_id") long id,
                     @JsonProperty("lat") String latitude,
                     @JsonProperty("lon") String longitude,
                     @JsonProperty("type") String type,
                     @JsonProperty("display_name") String displayName) {
            this.id = id;
            this.latitude = latitude;
            this.longitude = longitude;
            this.type = type;
            this.names = Arrays.asList(StringUtils.split(displayName, ","));
        }
    }
}
