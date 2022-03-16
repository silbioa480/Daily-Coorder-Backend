package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.BoardImage;
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
public class BoardImageRepository {

  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  public BoardImageRepository(DataSource dataSource) {
    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  }

  public Long addImage(BoardImage image) {
    String sql = "INSERT INTO board_image (board_image_file, board_image_type, board_image_name) VALUES (:board_image_file, :board_image_type, :board_image_name)";
    SqlParameterSource parameter = new MapSqlParameterSource("board_image_file", image.getBoard_image_file())
      .addValue("board_image_type", image.getBoard_image_type())
      .addValue("board_image_name", image.getBoard_image_name());

    KeyHolder keyHolder = new GeneratedKeyHolder();
    namedParameterJdbcTemplate.update(sql, parameter, keyHolder);

    return keyHolder.getKey().longValue();
  }

  public Optional<BoardImage> findById(Long id) {
    String sql = "SELECT board_image_id, board_image_file, board_image_type, board_image_name FROM board_image WHERE board_image_id=:id";
    SqlParameterSource parameter = new MapSqlParameterSource("id", id);

    try {
      BoardImage image = namedParameterJdbcTemplate.queryForObject(sql, parameter, BeanPropertyRowMapper.newInstance(BoardImage.class));
      assert image != null;

      return Optional.of(image);
    } catch (Exception e) {
      return Optional.empty();
    }
  }
}
