package tntbot.core;

public class Notification {
	private String color;
	private String message;
	private boolean notify;
	
	protected Notification(){}
	
	public String getColor() {
		return color;
	}
	
	protected void setColor(String color) {
		this.color = color;
	}
	
	public String getMessage() {
		return message;
	}
	
	protected void setMessage(String message) {
		this.message = message;
	}
	
	public boolean isNotify() {
		return notify;
	}

	protected void setNotify(boolean notify) {
		this.notify = notify;
	}
}
