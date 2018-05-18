package online.music.store.record.catalog;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.music.store.record.model.IMusicDAO;
import online.music.store.record.model.IMusicService;

/**
 * 
 * @author vinod
 *
 */
@Service
public class IMusicServiceImpl implements IMusicService {

	@Autowired
	private IMusicDAO musicDao;

	@Override
	public int addRecord(MusicStore musicStore) {
		return musicDao.addRecord(musicStore);
	}

	@Override
	public int updateRecord(MusicStore musicStore) {
		return musicDao.updateRecord(musicStore);
	}

	@Override
	public int deleteRecord(int id) {
		return musicDao.deleteRecord(id);
	}

	@Override
	public MusicStore getRecord(int id) {
		return musicDao.getRecord(id);
	}

	@Override
	public Collection<MusicStore> getAll() {
		return musicDao.getAll();
	}

}
