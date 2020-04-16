package game;

import java.util.HashMap;
import java.util.Map;

public class Commands {
	
	private Map<Integer, Command> allCommands = new HashMap<>();

	public Commands(Map<Integer, Command> allCommands) {
		super();
		this.allCommands = allCommands;
	}
	
	
	public Boolean checkIfCommandExists(int command) {
		
		return this.allCommands.containsKey(command);
		
	}
	
	public String getAllCommands() {
		return this.allCommands.keySet().toString() ;
	}
	
	public String getCommandType(int key) {
		return this.allCommands.get(key).getCommandType();
	}
	
	public int getCommandValue(int key) {
		return this.allCommands.get(key).getCommandValue();
	}
	
	public String getCommandDescription(int key) {
		return this.allCommands.get(key).getCommandDescription();
	}
	
	

}
