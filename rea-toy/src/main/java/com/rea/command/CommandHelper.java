package com.rea.command;

import com.rea.constants.Constants;
import com.rea.pojo.Direction;
import com.rea.pojo.Robot;

/**
 * Helper class for parsing user input commands from the console
 * 
 * @author Gautham Bhonsle
 *
 */
public class CommandHelper extends Constants {

	private boolean isInitialized;
	private Robot robot;
	private CommandExecutor commandExecutor;

	/**
	 * Constructor object accepts instance of a robot and sets the initilized
	 * boolean value
	 * 
	 * @param robot
	 */
	public CommandHelper(Robot robot) {
		this.isInitialized = true;
		this.robot = robot;
		this.commandExecutor = new CommandExecutor();

	}

	/**
	 * Method accepts user commands and delegates to appropriate methods for
	 * execution
	 * 
	 * @param command
	 * @throws IllegalArgumentException
	 */
	public void parseCommands(String command) throws IllegalArgumentException {
		command = command.toUpperCase().trim();
		if (command.equals(EXIT)) {
			System.exit(0);
		} else if (command.equals(SHOW_MANUAL)) {
			System.out.println(MANUAL);
		}

		else if (command.contains(PLACE)) {
			executePlace(command);
		} else {
			executeCommand(command);
		}

	}

	/**
	 * This method executes initial place command.
	 * checks for incorrect paramaters
	 * 
	 * @param command
	 * @throws IllegalArgumentException
	 */
	private void executePlace(String command) throws IllegalArgumentException {

		command = command.replace(PLACE, "").trim();
		String[] commandArgs = command.split(",");
		try {
			int x = Integer.parseInt(commandArgs[0].trim());
			int y = Integer.parseInt(commandArgs[1].trim());
			Direction direction = Direction.valueOf(commandArgs[2].trim());
			commandExecutor.executePlaceCommand(robot, x, y, direction);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INCORRECT_PARAMETERS);
		}
	}

	/**
	 * Interprets and executes subsequent commands
	 * 
	 * @param commmand
	 */
	private void executeCommand(String commmand) {
		if (robot.isPlaced()) {
			switch (commmand) {
			case MOVE:
				commandExecutor.executeMoveCommand(robot);
				break;
			case LEFT:
				commandExecutor.executeLeftCommand(robot);
				break;
			case RIGHT:
				commandExecutor.executeRightCommand(robot);
				break;
			case REPORT:
				System.out.println(commandExecutor.executeReportCommand(robot));
				break;
			}

		} else {
			// show error message on the console if the robot is not yet placed on the 4x4
			// table
			System.err.println(ROBOT_NOT_PLACED);
		}
	}

	/**
	 * Getter for isInitialized
	 * @return
	 */
	public boolean isInitialized() {
		return isInitialized;
	}

}
