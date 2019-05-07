package se.codeby.zipcode.health;

import com.codahale.metrics.health.HealthCheck;

public class ZipCodeHealthCheck extends HealthCheck {
    @Override
    protected Result check() {
        return Result.healthy();
    }
}
