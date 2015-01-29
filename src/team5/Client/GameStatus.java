package team5.Client;


public class GameStatus {
	
	
	public enum StatusEnum {
		IN_PROGRESS, COMPLETED, WAITING
	}

	private int playersLeft;

	private String serverIP;
	
	private StatusEnum status;
	
	// GameStatus  Constructor
	public GameStatus()
	{
		
	}
		public GameStatus(String serverIP, int playersLeft, StatusEnum status) {

			this.serverIP = serverIP;
			this.playersLeft = playersLeft;
			this.status = status;
		}
	
	public StatusEnum getStatus() {
		return this.status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		String status = "";

		switch (getStatus()) {
		case IN_PROGRESS:
			status = "In Progress";
			break;
		case COMPLETED:
			status = "Completed";
			break;
		case WAITING:
			status = "Waiting";
			break;
		}

		return "Game Info - Status: " + status + " | Server: " + getServerIP()
				+ " | Players left: " + getPlayersLeft() + "\n ";
	}
	
		public String getServerIP() {
			return serverIP;
		}

		public void setServerIP(String serverIP) {
			this.serverIP = serverIP;
			
		}
		
		public int getPlayersLeft() {
			return playersLeft;
		}

		public void setPlayersLeft(int playersLeft) {
			this.playersLeft = playersLeft;
	}
}
