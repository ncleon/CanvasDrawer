package com.leo.canvas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SimpleConsoleDrawer {

	private static final String CMD_CREATE_CANVAS = "C";
	private static final String CMD_QUIT = "Q";
	private static final String BUCKET_FILL_CMD = "B";
	private static final String DRAW_RECT_CMD = "R";
	private static final String DRAW_LINE_CMD = "L";
	private static CanvasDrawer canvasDrawer;
	
	public static void main(String[] args) {
     System.out.println("Hello World!"); // Display the string.\
     Scanner input = new Scanner(System.in);
     try {

         String command = input.nextLine();
         System.out.println("command >> " + command);
         while (!CMD_QUIT.equals(command)) {
          	 enterCommand(command);
        	 draw();
        	 command = input.nextLine();
         }
         System.out.println("Bye Bye World!"); // Display the string.\
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
 
		try {
			List<String> validCommandList = new ArrayList<String>(Arrays.asList(CMD_CREATE_CANVAS,BUCKET_FILL_CMD,DRAW_LINE_CMD,DRAW_RECT_CMD,CMD_QUIT));
			if (!validCommandList.contains(mainCommand)) {
				System.out.println(mainCommand + " command is no recognize, Please try again");
				return;
			}
			if(CMD_CREATE_CANVAS.equals(mainCommand)) {
				int width = Integer.parseInt(commandBreakDown[1]);
				int height =Integer.parseInt(commandBreakDown[2]);
				canvasDrawer = new CanvasDrawer(width, height);
			}
			else if(canvasDrawer==null) {
					System.out.println("Canvas no found, please create new canvas with command C w h. (width w, height h)");
					return;
			}
			else if (BUCKET_FILL_CMD.equals(mainCommand)) {
					int x1 = Integer.parseInt(commandBreakDown[1]);
					int y1 = Integer.parseInt(commandBreakDown[2]);
					char colour =commandBreakDown[3].charAt(0);
					canvasDrawer.bucketFill(x1,y1,colour);
					
			}
			else {
				int x1 = Integer.parseInt(commandBreakDown[1]);
				int y1 = Integer.parseInt(commandBreakDown[2]);
				int x2 =Integer.parseInt(commandBreakDown[3]);
				int y2 = Integer.parseInt(commandBreakDown[4]);
				
				if(DRAW_LINE_CMD.equals(mainCommand)) {
					canvasDrawer.drawLine(x1, y1 , x2, y2);
				}
				else if (DRAW_RECT_CMD.equals(mainCommand)) {
					canvasDrawer.drawRectangle(x1, y1 , x2, y2);
				}
			}
		} 
		catch (Exception e) {
			System.err.println("Invalid command, exception occur: " +  e);
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
	
