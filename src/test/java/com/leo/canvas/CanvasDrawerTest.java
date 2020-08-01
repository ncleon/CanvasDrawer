package com.leo.canvas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CanvasDrawerTest {
	
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	  @Test
	  public void testCanvasCreateWidth20Height4() throws Exception {
	    	
	        StringBuffer expectedSB = new StringBuffer();
	        expectedSB.append("----------------------"+LINE_SEPARATOR);
	        expectedSB.append("|                    |"+LINE_SEPARATOR);
	        expectedSB.append("|                    |"+LINE_SEPARATOR);
	        expectedSB.append("|                    |"+LINE_SEPARATOR);
	        expectedSB.append("|                    |"+LINE_SEPARATOR);
	        expectedSB.append("----------------------"+LINE_SEPARATOR);
	        
	        CanvasDrawer canvasDrawer = new CanvasDrawer(20,4);
	        assertEquals(expectedSB.toString(), canvasDrawer.getDrawing().toString());

	        
		}
	    
	    @Test
		public void testCanvasL_1_2_6_2() throws Exception {
	    	
	        StringBuffer expectedSB = new StringBuffer();
	        expectedSB.append("----------------------"+LINE_SEPARATOR);
	        expectedSB.append("|                    |"+LINE_SEPARATOR);
	        expectedSB.append("|xxxxxx              |"+LINE_SEPARATOR);
	        expectedSB.append("|                    |"+LINE_SEPARATOR);
	        expectedSB.append("|                    |"+LINE_SEPARATOR);
	        expectedSB.append("----------------------"+LINE_SEPARATOR);
	        
	        CanvasDrawer canvasDrawer =  new CanvasDrawer(20,4);
	        canvasDrawer.drawLine(1, 2, 6, 2);
	        assertEquals(expectedSB.toString(),canvasDrawer.getDrawing().toString());

		}
	    //enter command: L 6 3 6 4
	    
	    @Test
		public void testCanvasL_6_3_6_4() throws Exception {
	    	
	        StringBuffer expectedSB = new StringBuffer();
	        expectedSB.append("----------------------"+LINE_SEPARATOR);
	        expectedSB.append("|                    |"+LINE_SEPARATOR);
	        expectedSB.append("|                    |"+LINE_SEPARATOR);
	        expectedSB.append("|     x              |"+LINE_SEPARATOR);
	        expectedSB.append("|     x              |"+LINE_SEPARATOR);
	        expectedSB.append("----------------------"+LINE_SEPARATOR);
	        
	        CanvasDrawer canvasDrawer =  new CanvasDrawer(20,4);
	        canvasDrawer.drawLine(6, 3, 6, 4);
	        assertEquals(expectedSB.toString(),canvasDrawer.getDrawing().toString());

		}
	    
	    //R 14 1 18 3
	    
	    @Test
		public void testCanvasR_14_1_18_3() throws Exception {
	    	
	        StringBuffer expectedSB = new StringBuffer();
	        expectedSB.append("----------------------"+LINE_SEPARATOR);
	        expectedSB.append("|             xxxxx  |"+LINE_SEPARATOR);
	        expectedSB.append("|             x   x  |"+LINE_SEPARATOR);
	        expectedSB.append("|             xxxxx  |"+LINE_SEPARATOR);
	        expectedSB.append("|                    |"+LINE_SEPARATOR);
	        expectedSB.append("----------------------"+LINE_SEPARATOR);
	        
	        CanvasDrawer canvasDrawer =  new CanvasDrawer(20,4);
	        canvasDrawer.drawRectangle(14, 1, 18, 3);
	        assertEquals(expectedSB.toString(),canvasDrawer.getDrawing().toString());

		}
	    
	    @Test
		public void testCanvasB_10_3_o() throws Exception {
	    	
	        StringBuffer expectedSB = new StringBuffer();
	        expectedSB.append("----------------------"+LINE_SEPARATOR);
	        expectedSB.append("|oooooooooooooxxxxxoo|"+LINE_SEPARATOR);
	        expectedSB.append("|xxxxxxooooooox   xoo|"+LINE_SEPARATOR);
	        expectedSB.append("|     xoooooooxxxxxoo|"+LINE_SEPARATOR);
	        expectedSB.append("|     xoooooooooooooo|"+LINE_SEPARATOR);
	        expectedSB.append("----------------------"+LINE_SEPARATOR);
	        
	        CanvasDrawer canvasDrawer =  new CanvasDrawer(20,4);
	        canvasDrawer.drawLine(1, 2, 6, 2);
	        canvasDrawer.drawLine(6, 3, 6, 4);
	        canvasDrawer.drawRectangle(14, 1, 18, 3);
	        canvasDrawer.bucketFill(10, 3, 'o');
	        assertEquals(expectedSB.toString(),canvasDrawer.getDrawing().toString());

		}
	    

}
