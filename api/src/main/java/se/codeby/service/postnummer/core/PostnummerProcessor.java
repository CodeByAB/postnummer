package se.codeby.service.postnummer.core;

import se.codeby.service.postnummer.PostnummerApplication;
import se.codeby.service.postnummer.clients.OpenStreetMapClient;
import se.codeby.service.postnummer.clients.PostNordClient;
import se.codeby.service.postnummer.db.PostnummerDao;

public class PostnummerProcessor {

    private final PostnummerApplication application;

    public PostnummerProcessor(PostnummerApplication application) {
        this.application = application;
    }

    public Postnummer findBy(String countryCode, String zipCode) {
        final PostnummerDao postnummerDao = application.getJdbi().onDemand(PostnummerDao.class);
        return postnummerDao.findBy(countryCode, zipCode).orElseGet(() -> {
            final PostNordClient.Location location = application.getPostNordClient().findBy(countryCode, zipCode);
            final OpenStreetMapClient.Place place = application.getOpenStreetMapClient().findBy(countryCode, location.postalCity);

            return postnummerDao.insert(Postnummer.builder()
                .city(location.postalCity)
                .names(place.names)
                .latitude(place.latitude)
                .longitude(place.longitude)
                .type(place.type)
                .zipCode(zipCode)
                .countryCode(countryCode)
                .build());
        });
    }
}
