package online.music.store.record.model;

import online.music.store.record.catalog.MusicStore;
import online.music.store.record.model.WSReturnStatus;

public interface IMusicController {

	public WSReturnStatus addRecord(MusicStore musicStore);

	public WSReturnStatus getAll();

	public WSReturnStatus getRecordById(int id);
	
	public WSReturnStatus deleteRecord(int id);
	
	public WSReturnStatus updateRecord(MusicStore musicStore);

}