package com.leo.canvas;

public class CanvasDrawer {
	
	private static final char CHAR_DEFAULT_VALUE = '\u0000';
	char [][] canvas;
	
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	
	int maxX=0;
	int maxY=0;
	
	public CanvasDrawer (int width, int height) {
		maxX = width + 2;
		maxY = height + 2;
		canvas = new char [maxX][maxY];
		for (int i = 0; i < maxX; i++) {
			canvas[i][0] = '-';
			canvas[i][maxY-1] = '-';		
		}

		for (int i = 1; i < maxY-1; i++) {
			canvas[0][i] = '|';
			canvas[maxX-1][i] = '|';
		}
	}
	
	public void bucketFill(int x1, int y1, char colour) {
		fillConnectedAreaWithColour(x1,y1,colour);
		
	}

	private void fillConnectedAreaWithColour(int x, int y, char colour) {
		if(x<=0 || y<=0 || x>=maxX || y>=maxY) {
			return ;//Stop fill
		}
		char currentValue = canvas[x][y];				
		if(!isDefaultValue(currentValue)) {
			return ; //Stop fill
		}
		
		 canvas[x][y] = colour;
		 fillConnectedAreaWithColour(x-1,y,colour);
		 fillConnectedAreaWithColour(x+1,y,colour);
		 fillConnectedAreaWithColour(x,y-1,colour);
		 fillConnectedAreaWithColour(x,y+1,colour);
		 
		
	}

	public void drawRectangle(int x1, int y1, int x2, int y2) {
		for (int i = x1; i <= x2; i++) {
			canvas[i][y1] = 'x';
			canvas[i][y2] = 'x';
		}
		
		for (int j = y1; j <= y2; j++) {
			canvas[x1][j] = 'x';
			canvas[x2][j] = 'x';
		}
		
	}

	public void drawLine(int x1, int y1 , int x2, int y2) {
		if(x1==x2) {
			drawVerticalLine(x1, y1, y2);
		}
		else if(y1==y2) {
			drawHorizonLine(y1, x1, x2);
		}
		else {
			throw new IllegalArgumentException("Currently only horizontal or vertical lines are supported");
		}

		
	}
	
	private void drawHorizonLine(int y, int x1, int x2) {
			
		for (int i = x1; i <= x2; i++) {
			canvas[i][y] = 'x';
		}
		
	}

	private void drawVerticalLine(int x, int y1, int y2) {
		
		for (int i = y1; i <= y2; i++) {
			canvas[x][i] = 'x';
		}
		
	}

	private boolean isDefaultValue(char value) {
		return value == CHAR_DEFAULT_VALUE;
	}

	
	public StringBuffer getDrawing() {
		StringBuffer stringBuffer = new StringBuffer();
		for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
				char value = canvas[x][y];
				if(isDefaultValue(value)) {
					value =' ';
				}
				stringBuffer.append(value);
				
			}
			stringBuffer.append(LINE_SEPARATOR);
		}
		
		return stringBuffer;
		
	}




}
