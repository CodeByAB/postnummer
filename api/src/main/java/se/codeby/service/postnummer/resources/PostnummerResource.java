package se.codeby.service.postnummer.resources;

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.servlets.assets.ResourceNotFoundException;
import se.codeby.service.postnummer.PostnummerApplication;
import se.codeby.service.postnummer.clients.OpenStreetMapClient;
import se.codeby.service.postnummer.clients.PostNordClient;
import se.codeby.service.postnummer.core.Postnummer;
import se.codeby.service.postnummer.core.PostnummerProcessor;

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

@Path("/{zip-code : postnummer|postinumero}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostnummerResource {

    private final PostnummerProcessor processor;

    public PostnummerResource(PostnummerApplication application) {
        this.processor = new PostnummerProcessor(application);
    }

    @GET
    @Timed
    @Path("/{zipCode}")
    public Response findBy(@QueryParam("countryCode") @DefaultValue("SE") @Pattern(regexp = "SE", message = "Only supportS 'SE'") String countryCode,
                           @PathParam("zipCode") String zipCode) {
        return Response.ok(processor.findBy(countryCode, zipCode)).build();
    }
}
