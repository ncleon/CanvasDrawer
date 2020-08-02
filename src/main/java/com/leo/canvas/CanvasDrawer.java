package com.leo.canvas;

import org.springframework.util.StringUtils;

public class CanvasDrawer {
	
	private static final String MUST_LESS_THAN = " must less than ";
	private static final String MUST_MORE_THAN_0 = " must more than 0.";
	private static final char CHAR_DEFAULT_VALUE = '\u0000';
	char [][] canvas;
	
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	
	int maxX=0;
	int maxY=0;
	int width = 0;
	int height = 0;
	
	public CanvasDrawer (int width, int height){
		String errorMessage= validateSinglePoint(width, "width", Integer.MAX_VALUE);
		errorMessage += validateSinglePoint(height, "height", Integer.MAX_VALUE);
		
		if(!StringUtils.isEmpty(errorMessage)) {
			throw new IllegalArgumentException(errorMessage);
		}
		
		this.width = width;
		this.height= height;
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
	
	public void bucketFill(int x, int y, char colour) {
		isCoordinateAllow(x, y);
		isCoordinateAllowFillColour(x, y);
		fillConnectedAreaWithColour(x,y,colour);
		
	}

	private void isCoordinateAllowFillColour(int x, int y) {
		char currentValue = canvas[x][y];				
		if(!isDefaultValue(currentValue)) {
			throw new IllegalArgumentException("Coordinate (" + x + "," + y + ") is not allow to fill Colour");
		}
		
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
		isCoordinateAllow(x1, y1, x2, y2);
		int xMax = x2>x1?x2:x1;
		int xMin= xMax==x1?x2:x1;
		int yMax = y2>y1?y2:y1;
		int yMin= yMax==y1?y2:y1;
		
		if(xMin==xMax||yMin==yMax) {
			throw new IllegalArgumentException("Currently only Rectangle is supported");
		}
		
		for (int i = xMin; i <= xMax; i++) {
			canvas[i][y1] = 'x';
			canvas[i][y2] = 'x';
		}
		
		for (int j = yMin; j <= yMax; j++) {
			canvas[x1][j] = 'x';
			canvas[x2][j] = 'x';
		}
		
	}

	public void drawLine(int x1, int y1 , int x2, int y2) {
		isCoordinateAllow(x1, y1, x2, y2);

		if(x1==x2) {
			drawVerticalLine(x1, y1, y2);
		}
		else if(y1==y2) {
			drawHorizonLine(y1, x1, x2);
		}
		else {
			throw new IllegalArgumentException("Currently only horizontal or vertical line are supported");
		}

		
	}
	
	private void isCoordinateAllow(int x1, int y1) {
		String errorMessage = validateSinglePoint(x1, "x1",width);
		errorMessage += validateSinglePoint(y1, "y1",height);
		if(!StringUtils.isEmpty(errorMessage)) {
			throw new IllegalArgumentException(errorMessage);
		}
		
	}
	
	private void isCoordinateAllow(int x1, int y1 , int x2, int y2) {
		String errorMessage = validateSinglePoint(x1, "x1",width);
		errorMessage += validateSinglePoint(x2, "x2",width);
		errorMessage += validateSinglePoint(y1, "y1",height);
		errorMessage += validateSinglePoint(y2, "y2",height);
		if(!StringUtils.isEmpty(errorMessage)) {
			throw new IllegalArgumentException(errorMessage);
		}
		
	}

	private String validateSinglePoint(int target, String targetTitle, int maxAllow) {
		String errorMessage = "";
		if(target<=0) {
			errorMessage += targetTitle + MUST_MORE_THAN_0;
		}
		else if(target>maxAllow) {
			errorMessage += targetTitle + MUST_LESS_THAN + maxAllow +".";
		}
		
		return errorMessage;
	}

	private void drawHorizonLine(int y, int x1, int x2) {
		int xMax = x2>x1?x2:x1;
		int xMin= xMax==x1?x2:x1;
			
		for (int i = xMin; i <= xMax; i++) {
			canvas[i][y] = 'x';
		}
		
	}

	private void drawVerticalLine(int x, int y1, int y2) {
		int yMax = y2>y1?y2:y1;
		int yMin= yMax==y1?y2:y1;
		
		for (int i = yMin; i <= yMax; i++) {
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
