package by.doall.repository;

import by.doall.model.Advertisement;
import by.doall.repository.exception.RepositoryException;
import by.doall.sql.MySqlConnectionPool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdvertisementRepository extends BaseEntityRepository<Advertisement> {

  private static final String SQL_GET_ALL_AD =
      "SELECT id, title, description, createdAt FROM advertisements";

  private static final String SQL_FIND_BY_ID_AD =
      "SELECT id, title, description, createdAt FROM advertisements WHERE id = ?";

  private static final String SQL_CREATE_AD =
      "INSERT INTO advertisements (title, description) VALUES (?, ?)";

  private static final String SQL_DELETE_AD = "DELETE FROM advertisements WHERE id = ?";

  private static final String SQL_UPDATE_AD =
      "UPDATE advertisements SET title = ?, description = ? WHERE id = ?";

  public AdvertisementRepository() {
    super(MySqlConnectionPool.getInstance());
  }

  private static void mapRow(ResultSet rs, Advertisement obj) throws SQLException {
    obj.setId(rs.getLong("id"));
    obj.setTitle(rs.getString("title"));
    obj.setDescription(rs.getString("description"));
    obj.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
  }

  public List<Advertisement> findAll() throws RepositoryException {
    return super.findAll(SQL_GET_ALL_AD, AdvertisementRepository::mapRow, Advertisement::new);
  }

  public Advertisement findById(long id) throws RepositoryException {
    return super.findById(
        SQL_FIND_BY_ID_AD, AdvertisementRepository::mapRow, Advertisement::new, id);
  }

  public long create(Advertisement obj) throws RepositoryException {
    return super.create(SQL_CREATE_AD, obj.getTitle(), obj.getDescription());
  }

  public void updateAdevertisementtrshjetuyu(Advertisement obj) throws RepositoryException {
    super.update(SQL_UPDATE_AD, obj.getId(), obj.getTitle(), obj.getDescription());
  }

  public void delete(long id) throws RepositoryException {
    super.delete(SQL_DELETE_AD, id);
  }
}
