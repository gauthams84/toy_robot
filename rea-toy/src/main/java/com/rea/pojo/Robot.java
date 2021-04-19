package com.rea.pojo;

import com.rea.constants.Constants;

/**
 * Simple robot POJO for holding the position and direction on the table
 * 
 * @author Gautham Bhonsle
 *
 */
public class Robot extends Constants {

	private Integer positionX;

	private Integer positionY;

	private Direction direction;

	private boolean isPlaced = false;

	/**
	 * Returns if the robot is placed on the table
	 * @return boolean
	 */
	public boolean isPlaced() {
		return isPlaced;
	}

	public void setPlaced(boolean isPlaced) {
		this.isPlaced = isPlaced;
	}

	/**
	 * Method validates if the robot is within the set boundary condtions
	 * @param positionX
	 * @param positionY
	 * @return boolean
	 */
	public boolean isWithinBoudary(int positionX, int positionY) {
		if (positionX >= LOWER_BOUND && positionX <= UPPER_BOUND && positionY >= LOWER_BOUND
				&& positionY <= UPPER_BOUND) {
			return true;
		}
		return false;

	}

	/**
	 * Move the robot on either X or Y axis
	 * @param axis
	 */
	public void increment(String axis) {
		if (axis.equalsIgnoreCase("y")) {
			positionY++;
		} else {
			positionX++;
		}

	}

	/**
	 * retract the robot on either X or Y axis
	 * @param axis
	 */
	public void decrement(String axis) {
		if (axis.equalsIgnoreCase("y")) {
			positionY--;
		} else {
			positionX--;
		}
	}

	/**
	 * report the current orientation of the Robot
	 * @return
	 */
	public String report() {
		return String.join(",", positionX.toString(), positionY.toString(), direction.toString());
	}

	/**
	 * Getter for co-ordinate X
	 * @return X
	 */
	public int getPositionX() {
		return positionX;
	}

	/**
	 * Setter for co-ordinate X
	 * @param positionX
	 */
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	/**
	 * Getter for co-ordinate Y
	 * @return Y
	 */
	public int getPositionY() {
		return positionY;
	}

	/**
	 * Setter for co-ordinate Y
	 * @param positionY
	 */
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	/**
	 * Getter for Direction
	 * @return Enum Direction
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * Setter for Direction
	 * @param direction
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
