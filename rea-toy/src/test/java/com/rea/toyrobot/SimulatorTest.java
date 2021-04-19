package com.rea.toyrobot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rea.command.CommandHelper;
import com.rea.constants.Constants;
import com.rea.pojo.Robot;

/**
 * Unit tests for simulating the Robot application
 * 
 * @author Gautham Bhonsle
 *
 */
public class SimulatorTest {

	private Robot robot;
	private CommandHelper commandHelper;

	@BeforeEach
	public void SetUp() {
		this.robot = new Robot();
		this.commandHelper = new CommandHelper(robot);
	}

	@Test
	public void place() {
		assertTests("0,0,NORTH", "PLACE 0,0,NORTH;REPORT");
	}

	@Test
	public void placeMultipleTimes() {
		assertTests("2,3,WEST", "PLACE 0,0,NORTH; PLACE 2,3,WEST;REPORT");

	}

	@Test
	public void placeAndChangeDirectionToRight() {
		assertTests("0,0,EAST", "PLACE 0,0,NORTH;RIGHT;REPORT");
	}

	@Test
	public void placeAndChangeDirectionToLeft() {
		assertTests("0,0,EAST", "PLACE 0,0,NORTH;RIGHT;REPORT");
	}

	@Test
	public void placeAndChangeDirectionAndMove() {
		assertTests("0,4,WEST", "PLACE 0,4,SOUTH;RIGHT;MOVE;MOVE;REPORT");
	}

	@Test
	/**
	 * When placed and moved beyond boundary, the postion remains unchanged at the
	 * last point of movement
	 */
	public void placeAndMoveBeyondBoundary() {
		//
		assertTests("4,0,EAST", "PLACE 1,0,NORTH;RIGHT;MOVE;MOVE;MOVE;MOVE");
		assertTests("0,1,WEST", "PLACE 0,1, NORTH;LEFT;MOVE");
	}

	/**
	 * Helper method to assert the units
	 * @param expected
	 * @param commandString
	 */
	public void assertTests(String expected, String commandString) {
		String[] commandArry = commandString.split(";");
		for (String command : commandArry) {
			commandHelper.parseCommands(command);
		}
		assertEquals(expected, robot.report());
	}

}
