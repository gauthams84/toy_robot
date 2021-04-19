package com.rea.toyrobot;

import java.util.Scanner;

import com.rea.command.CommandHelper;
import com.rea.constants.Constants;
import com.rea.pojo.Robot;

/**
 * Main class for the Toy Robot simulation program
 * 
 * @author Gautham Bhonsle
 *
 */
public class Simulator extends Constants {

	/**
	 * Main method that instantiates all required entities
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Robot robot = new Robot();
		CommandHelper commandHelper = new CommandHelper(robot);
		Scanner scanner = new Scanner(System.in);
		System.out.println(WELCOME);
		// Prompter is alive for subsequent commands
		while (commandHelper.isInitialized()) {
			System.out.print(PROMPTER);
			try {
				commandHelper.parseCommands(scanner.nextLine());
			} catch (IllegalArgumentException ex) {
				System.out.println(ex);
			}
		}
	}

}
