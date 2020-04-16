package game;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;



public class Application {
	
	private static Commands gameCommands = null ;
	private static Vector<Integer> matrixInputVector = new Vector<Integer>();
	private static Vector<Integer> commandsInputVector = new Vector<Integer>();
	private static Map<Integer, Command> generalCommands = new HashMap<>();

	public static void main(String[] args) throws Exception {
	
		generalCommands.put(0, new Command(0, 0 , "general", "QuitGame"));
		generalCommands.put(1, new Command(1, 1, "movement", "MoveOneStepForward"));
		generalCommands.put(2, new Command(2, 1, "movement", "MoveOneStepBack"));
		generalCommands.put(3, new Command(3, 90, "rotation", "RotateClockWise"));
		generalCommands.put(4, new Command(4, 90, "rotation", "RotateCounterClockWise"));
		
		
		gameCommands = new Commands(generalCommands);
		
		System.out.println("Input Matrix and Start point:");
		Scanner scanner = new Scanner(System.in);
		String matrixAndStartPoint[] = scanner.next().split(",");
		
		readMatrixAndStartInput(matrixAndStartPoint);
		
		System.out.println("Input commands:");
		String commandsInput[] = scanner.next().split(",");
		scanner.close();
		
		readCommandsInput(commandsInput);
		
		Matrix game = new Matrix(matrixInputVector, 0, gameCommands);
		
		game.handleCommands(commandsInputVector);
		
	}
		
	public static void readMatrixAndStartInput(String tokens[] ) throws Exception {
			
		//validate the length of input
		
		if (tokens.length != 4) {
			 throw new Exception("Input must be 4 numbers 2 numbers for the matrix and 2 for the start position");
		}
		
		//check if the input is number and is >= 0 
		
		for (int i = 0; i < tokens.length; i++) {
			if(Integer.parseInt((tokens[i])) < 0) {
				 throw new Exception("Input must be >= 0");
			}
			matrixInputVector.add(Integer.parseInt((tokens[i])));		
		}
	}
	
	public static void readCommandsInput(String tokens[]) throws Exception {
		
		//validate the length of input
		
		if (tokens.length <= 0 ) {
			throw new Exception("Please insert one of the following commands"+ gameCommands.getAllCommands());
		}
		
		if(Integer.parseInt(tokens[tokens.length - 1]) != 0){
			throw new Exception("End command 0 is missing");
			
		}
		
		for (int i = 0; i < tokens.length; i++) {
			//validates the input to check if it is string / command number
			if(!gameCommands.checkIfCommandExists(Integer.parseInt((tokens[i])))) {
				 throw new Exception("A command can only consist of the values "+ gameCommands.getAllCommands() +" the command value: " + tokens[i] + " is invalid");
			}
			commandsInputVector.add(Integer.parseInt((tokens[i])));
		}
		
	}

}
