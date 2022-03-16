package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.AdImage;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;

@Repository
public class AdImageRepository {
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  public AdImageRepository(DataSource dataSource) {
    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  }

  public Long addImage(AdImage image) {
    String sql = "INSERT INTO ad_image (ad_image_file, ad_image_type, ad_image_name) VALUES (:ad_image_file, :ad_image_type, :ad_image_name)";
    SqlParameterSource parameter = new MapSqlParameterSource("ad_image_file", image.getAd_image_file())
      .addValue("ad_image_type", image.getAd_image_type())
      .addValue("ad_image_name", image.getAd_image_name());

    KeyHolder keyHolder = new GeneratedKeyHolder();
    namedParameterJdbcTemplate.update(sql, parameter, keyHolder);

    return keyHolder.getKey().longValue();
  }

  public Optional<AdImage> findById(Long id) {
    String sql = "SELECT ad_image_id, ad_image_file, ad_image_type, ad_image_name FROM ad_image WHERE ad_image_id=:id";
    SqlParameterSource parameter = new MapSqlParameterSource("id", id);

    try {
      AdImage image = namedParameterJdbcTemplate.queryForObject(sql, parameter, BeanPropertyRowMapper.newInstance(AdImage.class));
      assert image != null;

      return Optional.of(image);
    } catch (Exception e) {
      return Optional.empty();
    }
  }
}
