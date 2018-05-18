package online.music.store.record.model;

import java.util.Collection;

import online.music.store.record.catalog.MusicStore;

/**
 * 
 * @author vinod
 *
 */

public interface IMusicService {
	public int addRecord(MusicStore musicStore);

	public int updateRecord(MusicStore musicStore);

	public int deleteRecord(int id);

	public MusicStore getRecord(int id);

	public Collection<MusicStore> getAll();

}
