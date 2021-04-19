package com.rea.constants;

public class Constants {
	public final static String PROMPTER = ">";
	public static final String PLACE = "PLACE";
	public static final String EXIT = "EXIT";
	public static final String MOVE = "MOVE";
	public static final String RIGHT = "RIGHT";
	public static final String LEFT = "LEFT";
	public static final String REPORT = "REPORT";
	public static final String SHOW_MANUAL = "MANUAL";

	public static final int UPPER_BOUND = 4;
	public static final int LOWER_BOUND = 0;
	public static final String COMMAND_REGEX = "(MOVE|LEFT|RIGHT|REPORT|EXIT)";
	public static final String PLACE_COMMAND_REGEX = "^(PLACE)\\s\\d+,\\d+,(NORTH|EAST|WEST|SOUTH)$";

	
	public final static String MANUAL = "Only the following commands are allowed:\n"
			+ "PLACE X,Y,{NORTH,EAST,WEST,SOUTH}\n" 
			+ "MOVE\n" 
			+ "LEFT\n" 
			+ "RIGHT\n" 
			+ "REPORT\n"
			+ "EXIT\n"
			+ "MANUAL\n";
	public static final String ROBOT_NOT_PLACED = "Robot is not placed on the table";
	public static final String INITIAL_BOUNDARY_CONDITION_VIOLATED = "Initial co-ordinates voilate boundary conditions";
	public static final String BOUNDARY_CONDITION_VIOLATED = "Boundary condition violated on direction ";
	public static final String INCORRECT_PARAMETERS = "Incorrect parameters provided";
	public static final String INCORRECT_COMMAND = "Command not recognized";
	
	public static final String WELCOME = "Welcome!! Type \'MANUAL\' to view valid commands.";
}
