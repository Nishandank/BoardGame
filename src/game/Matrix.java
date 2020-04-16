package game;

import java.util.Vector;

public class Matrix {
	
	
	private String[][] matrix;
	private Integer numOfRows;
	private Integer numOfColumns;
	private Integer xPos;
	private Integer yPos;
	private Integer direction;
	private Commands gameCommands;
	
	public Matrix( Vector<Integer> matrixInput, Integer direction, Commands gameCommands) {
		super();
		this.numOfRows = matrixInput.get(0);
		this.numOfColumns = matrixInput.get(1);
		this.xPos = matrixInput.get(2);
		this.yPos = matrixInput.get(3);
		this.gameCommands = gameCommands;
		this.direction = direction;
		this.matrix = new String[numOfRows][numOfColumns];
		
		 for(int i = 0; i < numOfRows; i++)
	        {
	            for(int j = 0; j < numOfColumns; j++)
	                {
	                    this.matrix[i][j] = "[" + i + "," + j + "]";
	                }
	        }
		
	}
		
	public void handleCommands(Vector<Integer> arr) {
		
		for (int i : arr) {
			String commandType = gameCommands.getCommandType(i);
			String commandDesc = gameCommands.getCommandDescription(i);
			int commandValue = gameCommands.getCommandValue(i);
			
			switch(commandType) {
			  case "movement":
				  handleMovement(commandDesc, commandValue);
			    break;
			  case "rotation":
				  handleRotation(commandDesc, commandValue);
			    break;
			    
			  case "general":
				  handleGeneral(commandValue);
			    break;
			}
		}
		
		
	}
	
	public void handleRotation(String rotationCommand, Integer rotationValue) {
		
		switch(rotationCommand) {
		  case "RotateClockWise":
			  if(this.direction + rotationValue >= 360) {
				  this.direction = 0;
			  } else {
				  this.direction += rotationValue;
			  }
		    break;
		    
		  case "RotateCounterClockWise":
			  if(this.direction - rotationValue < 0) {
				  this.direction = 270;
			  } else {
				  this.direction -= rotationValue;
			  }
			  
		    break;
		  
		}
				
	}
	
	public void handleMovement(String movementDescription, Integer movementCommand) {
		
		Boolean moveBack = false;
		
		if(movementDescription.equals("MoveOneStepBack")) {
			moveBack = true;
		}
		
		switch(this.direction) {
		  case 0:
			  this.yPos = (moveBack)? this.yPos + movementCommand : this.yPos - movementCommand;
		    break;
		    
		  case 90:
			  this.xPos = (moveBack)? this.xPos - movementCommand : this.xPos + movementCommand;
		    break;
		    
		  case 180:
			  this.yPos = (moveBack)? this.yPos - movementCommand : this.yPos + movementCommand;
		    break;
		    
		  case 270:
			  this.xPos = (moveBack)? this.xPos + movementCommand : this.xPos - movementCommand;
		    break;
		  
		}
		
	}
	
	public void handleGeneral(Integer generalCommand) {
		
		switch(generalCommand) {
		  case 0:
			  System.out.println("OUTPUT: " + getCoord() );
			  System.exit(0);
		    break;
		    
		  
		}
		
	}


	public Integer getNumOfRows() {
		return numOfRows;
	}


	public Integer getNumOfColumns() {
		return numOfColumns;
	}

	public Integer getxPos() {
		return xPos;
	}


	public void setxPos(int xPos) {
		this.xPos = xPos;
	}


	public Integer getyPos() {
		return yPos;
	}


	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	public String getCoord() {
		try {
			return this.matrix[this.xPos][this.yPos];
        }
        catch(ArrayIndexOutOfBoundsException e) {
        	return "[-1,-1]";
        }
				
	}
	
	
	
	
	
	
	
	
	
	

}
