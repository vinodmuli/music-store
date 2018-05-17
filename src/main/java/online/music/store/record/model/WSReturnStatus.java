package online.music.store.record.model;

import java.util.HashMap;
import java.util.Map;

public class WSReturnStatus extends HashMap<String, Object> {

	private static final int STAUS_CODE_BAD_REQUEST = 400;
	private static final int STAUS_CODE_SERVER_ERROR = 500;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WSReturnStatus() {
	}

	public WSReturnStatus(String key, Object value) {
		this.put(key, value);
	}

	public void addAttributes(Map<String, Object> data) {
		this.putAll(data);
	}

	public static WSReturnStatus badRequest() {
		return new WSReturnStatus("status", STAUS_CODE_BAD_REQUEST);
	}

	public static WSReturnStatus badRequest(String message) {
		WSReturnStatus status = new WSReturnStatus("status", STAUS_CODE_BAD_REQUEST);
		status.put("message", message);
		return status;
	}

	public static WSReturnStatus serverError() {
		return new WSReturnStatus("status", STAUS_CODE_SERVER_ERROR);
	}

	public static WSReturnStatus serverError(String message) {
		WSReturnStatus status = new WSReturnStatus("status", STAUS_CODE_SERVER_ERROR);
		status.put("message", message);
		return status;
	}
}
