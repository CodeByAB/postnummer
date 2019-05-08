package se.codeby.service.postnummer.resources;

import com.codahale.metrics.annotation.Timed;
import se.codeby.service.postnummer.ZipCodeApplication;
import se.codeby.service.postnummer.clients.OpenStreetMapClient;
import se.codeby.service.postnummer.clients.PostNordClient;
import se.codeby.service.postnummer.core.ZipCode;

import javax.validation.constraints.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/zip-code")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ZipCodeResource {

    private final ZipCodeApplication application;

    public ZipCodeResource(ZipCodeApplication application) {
        this.application = application;
    }

    @GET
    @Timed
    @Path("/{zipCode}")
    public Response findBy(@QueryParam("countryCode") @DefaultValue("SE") @Pattern(regexp = "SE", message = "Only supportS 'SE'") String countryCode,
                           @PathParam("zipCode") String zipCode) {
        PostNordClient.Location location = application.getPostNordClient().findBy(countryCode, zipCode);
        OpenStreetMapClient.Place place = application.getOpenStreetMapClient().findBy(countryCode, location.postalCity);

        return Response.ok(ZipCode.builder()
            .city(location.postalCity)
            .names(place.names)
            .latitude(place.latitude)
            .longitude(place.longitude)
            .type(place.type)
            .zipCode(zipCode)
            .build()).build();
    }
}
