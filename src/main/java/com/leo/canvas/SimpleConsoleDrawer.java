package com.leo.canvas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SimpleConsoleDrawer {

	private static final String CMD_CREATE_CANVAS = "C";
	private static final String CMD_HELP = "H";
	private static final String CMD_QUIT = "Q";
	private static final String CMD_BUCKET_FILL = "B";
	private static final String CMD_DRAW_RECT = "R";
	private static final String CMD_DRAW_LINE = "L";
	private static CanvasDrawer canvasDrawer;
	
	public static void main(String[] args) {
     System.out.println("Welcome to simple drawing diagram, command H for Help. "); // Display the string.\
     Scanner input = new Scanner(System.in);
     try {

         String command = input.nextLine();
         while (!CMD_QUIT.equals(command)) {
        	try {
        		 if(CMD_HELP.equals(command)) {
        			printHelp();
        			continue;
        		 }
	          	 enterCommand(command);
	          	 draw();
        	}
         	catch (Exception e) {
         		System.err.println("Invalid command: " +  e.getMessage());
         	}
        	finally {
        		command = input.nextLine();
			}
	
         }
         System.out.println("Thank you for using Leo's simple drawing diagram, See you again. "); // Display the string.\
         input.close();
	} finally {
		if(input!=null) {
			input.close();
		}
	}
     
    }
	
	
	public static void enterCommand(String command) {
		String[] commandBreakDown = command.split(" ");
		String mainCommand = commandBreakDown[0];

 
		List<String> validCommandList = new ArrayList<String>(Arrays.asList(CMD_CREATE_CANVAS,CMD_BUCKET_FILL,CMD_DRAW_LINE,CMD_DRAW_RECT,CMD_QUIT));
		if (!validCommandList.contains(mainCommand)) {
			throw new IllegalArgumentException(mainCommand + " command is no recognize, Please try again");
		}
		else {
			validateCommandInput(mainCommand, commandBreakDown);
		}
		
		boolean isCreateCanvas = CMD_CREATE_CANVAS.equals(mainCommand);
		String commandBreakDown1 = commandBreakDown[1];
		String commandBreakDown2 = commandBreakDown[2];
		if(isCreateCanvas) {
			
			if(!(isInteger(commandBreakDown1)&&isInteger(commandBreakDown2))) 
			{
				throw new IllegalArgumentException("Width and height must be integer.");
			}
			
			int width = Integer.parseInt(commandBreakDown1);
			int height =Integer.parseInt(commandBreakDown2);
			canvasDrawer = new CanvasDrawer(width, height);
		}
		else if(canvasDrawer==null) {
				throw new IllegalArgumentException("Canvas no found, please create new canvas with command C w h. (width w, height h)");
				
		} else {
			boolean isBucketFill = CMD_BUCKET_FILL.equals(mainCommand);
			boolean isDrawLine = CMD_DRAW_LINE.equals(mainCommand);
			boolean isDrawRectangle = CMD_DRAW_RECT.equals(mainCommand);
			String commandBreakDown3 = commandBreakDown[3];
			
			if (isBucketFill)
			{							
				if(!(isInteger(commandBreakDown1)&&isInteger(commandBreakDown2)&&commandBreakDown3.length()==1)) {
					throw new IllegalArgumentException("only allow (x, y) with colour c. x and y must be interger , c is single character, example: B 1 1 c");
				}
					
				int x1 = Integer.parseInt(commandBreakDown1);
				int y1 = Integer.parseInt(commandBreakDown2);
				char colour =commandBreakDown3.charAt(0);
				canvasDrawer.bucketFill(x1,y1,colour);
					
			}
			else if(isDrawLine || isDrawRectangle)
			{			
				String commandBreakDown4 = commandBreakDown[4];
						
				if(!(isInteger(commandBreakDown1)&&isInteger(commandBreakDown2)
								&&isInteger(commandBreakDown3)&&isInteger(commandBreakDown4))) 
				{
					throw new IllegalArgumentException("x1 y1 x2 y2 must be integer.");
				}
				
				int x1 = Integer.parseInt(commandBreakDown1);
				int y1 = Integer.parseInt(commandBreakDown2);
				int x2 = Integer.parseInt(commandBreakDown3);
				int y2 = Integer.parseInt(commandBreakDown4);

				
				if(isDrawLine) {
					canvasDrawer.drawLine(x1, y1 , x2, y2);
				} else if (isDrawRectangle) 
				{
					canvasDrawer.drawRectangle(x1, y1 , x2, y2);
				}
			}
		}

	}
	private static void printHelp() {
		System.out.println("Command (input...) ==> Description");
		System.out.println("C w h ==> create a new canvas of width w and height h.");
		System.out.println("L x1 y1 x2 y2 ==> Create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the System.out.println('x' character.");
		System.out.println("R x1 y1 x2 y2 ==> Create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' System.out.println(character.");
		System.out.println("B x y c ==> Fill the entire area connected to (x,y) with colour c. The behavior of this is the same as that of the bucket fill tool in paint programs.");
		System.out.println("Q ==> Quit the program.");
		
	}


	private static void validateCommandInput(String mainCommand, String[] commandBreakDown) {
		switch (mainCommand) {
		case CMD_CREATE_CANVAS:
			if(commandBreakDown.length!=3) {
				throw new IllegalArgumentException("Create canvas command, only allow 2 input integer Values. Example C 20 4");
			}
			break;
		case CMD_BUCKET_FILL:
			if(commandBreakDown.length!=4) {
				throw new IllegalArgumentException("Bucket fill Command, only allow 3 input Values. Example B 2 1 c");
			}
			break;
		case CMD_DRAW_LINE:
			if(commandBreakDown.length!=5) {
				throw new IllegalArgumentException("Draw Line Command, only allow 4 input integer Values. Example L 1 2 1 3");
			}
			break;
		case CMD_DRAW_RECT:
			if(commandBreakDown.length!=5) {
				throw new IllegalArgumentException("Draw Rectangle Command, only allow 4 input integer Values. Example R 14 1 18 3");
			}
			break;
		default:
			break;
		}
		
		
	}


	private static boolean isInteger(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	public static void draw() {
		if(canvasDrawer==null) {
			System.out.println("Canvas no found, please create new canvas with command C w h. (width w, height h)");
			return;
			}
		System.out.print(canvasDrawer.getDrawing());
		
	}


}
	
