package se.codeby.zipcode.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.client.JerseyClientConfiguration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientConfiguration extends JerseyClientConfiguration {

    @NotEmpty
    @JsonProperty("baseUri")
    public String BaseUri;

    @Builder.Default
    @JsonProperty("apiKey")
    public Optional<String> apiKey = Optional.empty();
}
