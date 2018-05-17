package online.music.store.record.catalog;

public class MusicStore {

	private int id;
	private String titleRecord;
	private String lyricist;
	private String album;

	public MusicStore() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	public MusicStore(int id, String titleRecord, String lyricist, String album) {
		super();
		this.id = id;
		this.titleRecord = titleRecord;
		this.lyricist = lyricist;
		this.album = album;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the titleRecord
	 */
	public String getTitleRecord() {
		return titleRecord;
	}

	/**
	 * @param titleRecord
	 *            the titleRecord to set
	 */
	public void setTitleRecord(String titleRecord) {
		this.titleRecord = titleRecord;
	}

	/**
	 * @return the lyricist
	 */
	public String getLyricist() {
		return lyricist;
	}

	/**
	 * @param lyricist
	 *            the lyricist to set
	 */
	public void setLyricist(String lyricist) {
		this.lyricist = lyricist;
	}

	/**
	 * @return the album
	 */
	public String getAlbum() {
		return album;
	}

	/**
	 * @param album
	 *            the album to set
	 */
	public void setAlbum(String album) {
		this.album = album;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MusicStore [id=" + id + ", titleRecord=" + titleRecord + ", lyricist=" + lyricist + ", album=" + album
				+ "]";
	}

}
