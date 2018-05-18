package online.music.store.record.catalog;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import online.music.store.record.model.IMusicController;
import online.music.store.record.model.WSReturnStatus;

/**
 * 
 * @author vinod
 *
 */
@Controller
@RequestMapping("/music")
public class MusicControllerImpl implements IMusicController {

	@Autowired
	private IMusicServiceImpl musicService;

	@Override
	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public @ResponseBody WSReturnStatus addRecord(@RequestBody MusicStore musicStore) {
		try {
			int id = musicService.addRecord(musicStore);
			return new WSReturnStatus("createdrecordid", id);
		} catch (Exception e) {
			return WSReturnStatus.serverError(e.getMessage());
		}
	};

	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public @ResponseBody WSReturnStatus getAll() {
		try {
			Collection<MusicStore> records = musicService.getAll();
			return new WSReturnStatus("records", records);
		} catch (Exception e) {
			return WSReturnStatus.serverError(e.getMessage());
		}
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody WSReturnStatus getRecordById(@PathVariable int id) {
		try {
			MusicStore yy = musicService.getRecord(Integer.valueOf(id));
			return new WSReturnStatus("musicRecord", yy);
		} catch (Exception e) {
			return WSReturnStatus.serverError(e.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public @ResponseBody WSReturnStatus deleteRecord(@PathVariable int id) {
		try {
			int deletedRecordId = musicService.deleteRecord(id);
			return new WSReturnStatus("deletedRecordId", deletedRecordId);
		} catch (Exception e) {
			return WSReturnStatus.serverError(e.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	public @ResponseBody WSReturnStatus updateRecord(@RequestBody MusicStore musicStore) {

		try {
			MusicStore existingRecord = musicService.getRecord(musicStore.getId());
			if (existingRecord == null) {
				return WSReturnStatus.badRequest("Record not found : " + musicStore);
			} else {
				int yy = musicService.updateRecord(musicStore);
				return new WSReturnStatus("updatedrecords", yy);
			}
		} catch (Exception e) {
			return WSReturnStatus.serverError(e.getMessage());
		}
	}

}
