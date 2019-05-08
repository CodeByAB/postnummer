package se.codeby.service.postnummer.db;

import org.apache.commons.lang3.StringUtils;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import se.codeby.service.postnummer.core.Postnummer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;

@RegisterRowMapper(PostnummerDao.PostnummerMapper.class)
public interface PostnummerDao {

    @SqlQuery("INSERT INTO postnummer (zip_code, country_code, city, names, latitude, longitude, type, created_at, updated_at) VALUES (:zipCode, :countryCode, :city, :names, :latitude, :longitude, :type, current_timestamp, current_timestamp) RETURNING *")
    Postnummer insert(@BindBean Postnummer toBeSaved);

    @SqlQuery("UPDATE postnummer SET city = :city, names = :names, latitude = :latitude, longitude = :longitude, updated_at = current_timestamp RETURNING *")
    Postnummer update(@BindBean Postnummer toBeUpdated);

    @SqlQuery("SELECT * FROM postnummer p WHERE p.zip_code = :zipCode AND p.country_code = :countryCode")
    Optional<Postnummer> findBy(@Bind("countryCode") String countryCode, @Bind("zipCode") String zipCode);

    class PostnummerMapper implements RowMapper<Postnummer> {
        @Override
        public Postnummer map(ResultSet rs, StatementContext ctx) throws SQLException {
            return Postnummer.builder()
                .zipCode(rs.getString("zip_code"))
                .countryCode(rs.getString("country_code"))
                .city(rs.getString("city"))
                .latitude(rs.getString("latitude"))
                .longitude(rs.getString("longitude"))
                .type(rs.getString("type"))
                .names(Arrays.asList(StringUtils.split(rs.getString("names"), ",")))
                .build();
        }
    }
}
