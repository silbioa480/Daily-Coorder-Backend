package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.ProfileImage;
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
public class ProfileImageRepository {
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  public ProfileImageRepository(DataSource dataSource) {
    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  }

  public Long addImage(ProfileImage image) {
    String sql = "INSERT INTO profile_image (profile_image_file, profile_image_type, profile_image_name) VALUES (:profile_image_file, :profile_image_type, :profile_image_name)";
    SqlParameterSource parameter = new MapSqlParameterSource("profile_image_file", image.getProfile_image_file())
      .addValue("profile_image_type", image.getProfile_image_type())
      .addValue("profile_image_name", image.getProfile_image_name());

    KeyHolder keyHolder = new GeneratedKeyHolder();
    namedParameterJdbcTemplate.update(sql, parameter, keyHolder);

    return keyHolder.getKey().longValue();
  }

  public Optional<ProfileImage> findById(Long id) {
    String sql = "SELECT profile_image_id, profile_image_file, profile_image_type, profile_image_name FROM profile_image WHERE profile_image_id=:id";
    SqlParameterSource parameter = new MapSqlParameterSource("id", id);

    try {
      ProfileImage image = namedParameterJdbcTemplate.queryForObject(sql, parameter, BeanPropertyRowMapper.newInstance(ProfileImage.class));
      assert image != null;

      return Optional.of(image);
    } catch (Exception e) {
      return Optional.empty();
    }
  }

}
