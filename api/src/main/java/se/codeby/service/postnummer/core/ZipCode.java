package se.codeby.service.postnummer.core;

import lombok.Builder;

import java.util.List;

@Builder
public class ZipCode {
    public final String zipCode;
    public final String city;
    public final List<String> names;
    public final String latitude;
    public final String longitude;
    public final String type;
}
