package online.music.store.record.catalog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import online.music.store.record.model.DatabaseConstants;
import online.music.store.record.model.DatabaseUtil;
import online.music.store.record.model.IMusicDAO;

@Service
public class MusicDAOImpl implements IMusicDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addRecord(MusicStore musicStore) {
		if (musicStore == null) {
			throw new IllegalArgumentException();
		}

		int id = DatabaseUtil.getIdFromSeq(DatabaseConstants.MUSIC_ID_SEQ_NAME, jdbcTemplate);
		String Query = "INSERT INTO MUSIC (ID,titlerecord,lyricist,album) VALUES (?,?,?,?)";
		Object[] xx = new Object[] { id, musicStore.getTitleRecord(), musicStore.getLyricist(), musicStore.getAlbum() };

		int[] yy = new int[] { Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
		jdbcTemplate.update(Query, xx, yy);
		return id;
	}

	@Override
	public int updateRecord(MusicStore musicStore) {
		String update_query = "UPDATE MUSIC SET titlerecord=?,lyricist=?,album=? WHERE id =? ";
		return jdbcTemplate.update(update_query, new Object[] { musicStore.getTitleRecord(), musicStore.getLyricist(),
				musicStore.getAlbum(), musicStore.getId() });
	}

	@Override
	public int deleteRecord(int id) {

		String delete_query = "DELETE FROM MUSIC WHERE ID =?";
		return jdbcTemplate.update(delete_query, new Object[] { id });
	}

	@Override
	public MusicStore getRecord(int id) {

		String query = "Select id, titlerecord,lyricist,album from music where id= ?";
		return jdbcTemplate.query(query, new Object[] { id }, new ResultSetExtractor<MusicStore>() {

			@Override
			public MusicStore extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {
					return readFromResultSet(rs);
				} else {
					return null;
				}
			}
		});

	}

	@Override
	public Collection<MusicStore> getAll() {
		String query = "Select id, titlerecord,lyricist,album from music order by id desc";
		return jdbcTemplate.query(query, new RowMapper<MusicStore>() {

			@Override
			public MusicStore mapRow(ResultSet rs, int rowNum) throws SQLException {
				return readFromResultSet(rs);
			}
		});
	}

	private MusicStore readFromResultSet(ResultSet rs) throws SQLException {
		return new MusicStore(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
	}

}
