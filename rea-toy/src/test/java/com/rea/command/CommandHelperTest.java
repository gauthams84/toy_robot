package com.rea.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rea.constants.Constants;
import com.rea.pojo.Direction;
import com.rea.pojo.Robot;

public class CommandHelperTest {
	private Robot robot;
	private CommandHelper commandHelper;

	@BeforeEach
	public void setUp() {
		this.robot = new Robot();
		this.commandHelper = new CommandHelper(robot);
	}

	@Test
	public void initialPlaceBeyondBoundaryLimits() {
		String command = "PLACE 5,0,NORTH";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			commandHelper.parseCommands(command);
		});
		assertTrue(exception.getMessage().contains(Constants.INITIAL_BOUNDARY_CONDITION_VIOLATED));
	}

	@Test
	public void incorrectParameters() {
		String command = "PLACE x,y,NORTH";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			commandHelper.parseCommands(command);
		});
		assertTrue(exception.getMessage().contains(Constants.INCORRECT_PARAMETERS));
	}
	
	@Test
	public void incorrectNumberofParameters() {
		String command = "PLACE";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			commandHelper.parseCommands(command);
		});
		assertTrue(exception.getMessage().contains(Constants.INCORRECT_PARAMETERS));
	}
	
	@Test
	public void incorrectDirection() {
		String command = "PLACE 0,0,USA";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			commandHelper.parseCommands(command);
		});
		assertTrue(exception.getMessage().contains("No enum constant"));
	}
	
	@Test
	public void robotNotPlaced() {
		String command = "MOVE";
		assertFalse(robot.isPlaced());
	}
	
	@Test
	public void executeLeft() {
		String InitialCommand = "PLACE 3,0,NORTH";
		String leftComand = "LEFT";
		commandHelper.parseCommands(InitialCommand);
		//Execute Left
		commandHelper.parseCommands(leftComand);
		assertEquals(robot.getDirection(), Direction.WEST);
		commandHelper.parseCommands(leftComand);
		assertEquals(robot.getDirection(), Direction.SOUTH);
		commandHelper.parseCommands(leftComand);
		assertEquals(robot.getDirection(), Direction.EAST);
		commandHelper.parseCommands(leftComand);
		assertEquals(robot.getDirection(), Direction.NORTH);
		
	}
	
	@Test
	public void executeRight() {
		String Initialcommand = "PLACE 3,0,NORTH";
		String rightCommand = "RIGHT";
		commandHelper.parseCommands(Initialcommand);
		//Execute Right
		commandHelper.parseCommands(rightCommand);
		assertEquals(robot.getDirection(), Direction.EAST);
		commandHelper.parseCommands(rightCommand);
		assertEquals(robot.getDirection(), Direction.SOUTH);
		commandHelper.parseCommands(rightCommand);
		assertEquals(robot.getDirection(), Direction.WEST);
		commandHelper.parseCommands(rightCommand);
		assertEquals(robot.getDirection(), Direction.NORTH);
		
	}
	
	@Test
	public void executeMove() {
		String Initialcommand = "PLACE 3,0,NORTH";
		commandHelper.parseCommands(Initialcommand);
		commandHelper.parseCommands("MOVE");
		assertEquals(robot.report(), "3,1,NORTH");
		commandHelper.parseCommands("RIGHT");
		commandHelper.parseCommands("MOVE");
		assertEquals(robot.report(), "4,1,EAST");
		commandHelper.parseCommands("RIGHT");
		commandHelper.parseCommands("MOVE");
		assertEquals(robot.report(), "4,0,SOUTH");
		commandHelper.parseCommands("RIGHT");
		commandHelper.parseCommands("MOVE");
		assertEquals(robot.report(), "3,0,WEST");
		
		
		
		
	}
	


}
