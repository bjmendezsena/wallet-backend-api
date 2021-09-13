package shared;

public class RequestResponse {
	private boolean ok;
	private Object data;

	public RequestResponse(Object data, boolean ok) {
		super();
		this.data = data;
		this.ok = ok;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
