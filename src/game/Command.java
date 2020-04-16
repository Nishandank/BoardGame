package game;

public class Command {
	
	private Integer commandNb;
	private Integer commandValue;
	private String commandType;
	private String commandDescription;
	
	
	public Command(int commandNb, Integer commandValue, String commandType, String commandDescription) {
		super();
		this.commandNb = commandNb;
		this.commandValue = commandValue;
		this.commandType = commandType;
		this.commandDescription = commandDescription;
	}


	public Integer getCommandNb() {
		return commandNb;
	}


	public void setCommandNb(int commandNb) {
		this.commandNb = commandNb;
	}


	public Integer getCommandValue() {
		return commandValue;
	}


	public void setCommandValue(int commandValue) {
		this.commandValue = commandValue;
	}


	public String getCommandType() {
		return commandType;
	}


	public void setCommandType(String commandType) {
		this.commandType = commandType;
	}


	public String getCommandDescription() {
		return commandDescription;
	}


	public void setCommandDescription(String commandDescription) {
		this.commandDescription = commandDescription;
	}
	


}
