package se.codeby.service.postnummer.core;

import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Builder
@Getter
public class Postnummer {
    public final String zipCode;
    public final String city;
    public final List<String> names;
    public final String latitude;
    public final String longitude;
    public final String type;
    public final String countryCode;

    public String getNames() {
        return StringUtils.join(names, ",");
    }
}
