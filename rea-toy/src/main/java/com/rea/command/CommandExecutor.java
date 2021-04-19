package com.rea.command;

import com.rea.constants.Constants;
import com.rea.pojo.Direction;
import com.rea.pojo.Robot;

/**
 * Executor class to execute commands
 * 
 * @author Gautham Bhonsle
 *
 */
public class CommandExecutor extends Constants {

	/**
	 * Method executes the place command if boundary(4x4) conditions are met
	 * 
	 * @param robot
	 * @param x
	 * @param y
	 * @param direction
	 */
	public void executePlaceCommand(Robot robot, int x, int y, Direction direction) {
		if (robot.isWithinBoudary(x, y)) {
			robot.setPositionX(x);
			robot.setPositionY(y);
			robot.setDirection(direction);
			robot.setPlaced(true);
		} else {
			throw new IllegalArgumentException(INITIAL_BOUNDARY_CONDITION_VIOLATED);
		}

	}

	/**
	 * This method executes Left command and sets robot's direction
	 * 
	 * @param robot
	 */
	public void executeLeftCommand(Robot robot) {

		switch (robot.getDirection()) {
		case NORTH:
			robot.setDirection(Direction.WEST);
			break;
		case EAST:
			robot.setDirection(Direction.NORTH);
			break;
		case SOUTH:
			robot.setDirection(Direction.EAST);
			break;
		case WEST:
			robot.setDirection(Direction.SOUTH);
			break;

		}

	}

	/**
	 * This method executes Right command and sets robot's direction
	 * 
	 * @param robot
	 */
	public void executeRightCommand(Robot robot) {

		switch (robot.getDirection()) {
		case NORTH:
			robot.setDirection(Direction.EAST);
			break;
		case SOUTH:
			robot.setDirection(Direction.WEST);
			break;
		case EAST:
			robot.setDirection(Direction.SOUTH);
			break;
		case WEST:
			robot.setDirection(Direction.NORTH);
			break;
		}

	}

	/**
	 * 
	 * @param direction
	 */
	private void violatedBoundaryCondition(Direction direction) {
		System.err.println(BOUNDARY_CONDITION_VIOLATED + direction);
	}
	
	
	/**
	 * Method executes the move command based on the orientation of the robot
	 * @param robot
	 */
	public void executeMoveCommand(Robot robot) {

		switch (robot.getDirection()) {
		case NORTH:
			if (robot.getPositionY() < UPPER_BOUND) {
				robot.increment("y");
			} else {
				violatedBoundaryCondition(robot.getDirection());
			}
			break;
		case EAST:
			if (robot.getPositionX() < UPPER_BOUND) {
				robot.increment("x");
			} else {
				violatedBoundaryCondition(robot.getDirection());
			}
			break;
		case SOUTH:
			if (robot.getPositionY() > LOWER_BOUND) {
				robot.decrement("y");
			} else {
				violatedBoundaryCondition(robot.getDirection());
			}
			break;

		case WEST:
			if (robot.getPositionX() > LOWER_BOUND) {
				robot.decrement("x");
			} else {

				violatedBoundaryCondition(robot.getDirection());
			}
			break;
		}

	}

	/**
	 * Reports the current position of the robot on the 4x4 table
	 * @param robot
	 * @return
	 */
	public String executeReportCommand(Robot robot) {
		return robot.report();
	}

}
