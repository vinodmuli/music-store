package online.music.store.record.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseUtil {

	public static int getIdFromSeq(String seqName,JdbcTemplate jdbcTemplate) {
		return jdbcTemplate.queryForObject("SELECT nextVal('"+seqName+"')", Integer.class);
	}
}
