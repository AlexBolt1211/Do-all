package by.doall.repository;

import by.doall.model.Advertisement;
import by.doall.repository.exception.RepositoryException;
import by.doall.sql.ConnectionSource;
import by.doall.sql.util.ResultSetMapper;

import java.util.Collection;

public class AdvertisementRepository extends BaseEntityRepository<Advertisement> {

    private static final String ADVERTISEMENT_TABLE_COLUMN_ID = "id";
    private static final String ADVERTISEMENT_TABLE_COLUMN_TITLE = "title";
    private static final String ADVERTISEMENT_TABLE_COLUMN_CONTENT = "content";
    private static final String ADVERTISEMENT_TABLE_COLUMN_CREATED = "created";
    private static final String ADVERTISEMENT_TABLE_COLUMN_USERID = "userid";

    public AdvertisementRepository(ConnectionSource connectionSource) {
        super(connectionSource);
    }


    @Override
    protected ResultSetMapper<Advertisement> getResultSetMapper() {
        return null;
    }

    @Override
    public Collection<Advertisement> findAll() throws RepositoryException {
        return null;
    }

    @Override
    public Advertisement create(Advertisement entity) throws RepositoryException {
        return null;
    }

    @Override
    public boolean remove(long id) throws RepositoryException {
        return false;
    }
}
