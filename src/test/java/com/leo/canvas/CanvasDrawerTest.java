package com.leo.canvas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CanvasDrawerTest {
	
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	  @Test
	  public void testCreateWidthAndHeightMustMoreThan0() throws Exception {
	    	
	    	
	    	try {
	    		new CanvasDrawer(0,0);
	    		fail();
			} catch (Exception e) {
				assertTrue(e.getMessage().contains("must more than 0"));
			}

	        
		}
	  
	  @Test
	  public void testCreateWidth20Height4() throws Exception {
	    	
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
		public void testDrawLine_1_2_6_2() throws Exception {
	    	
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
	        
	        //Reverse also allow
	        
	        canvasDrawer =  new CanvasDrawer(20,4);
	        canvasDrawer.drawLine(6, 2, 1, 2);
	        assertEquals(expectedSB.toString(),canvasDrawer.getDrawing().toString());

		}
	    
	    
	    @Test
		public void testDrawLine_MustWithinCanvasWidthAndHeigh() throws Exception {
	    	
	    	CanvasDrawer canvasDrawer =  new CanvasDrawer(20,4);
	    	  
	    	try {
	    		canvasDrawer.drawLine(0, 2, 6, 2);
	    		fail();
			} catch (Exception e) {
				assertTrue(e.getMessage().contains("must more than 0."));
			}
	    	
	    	try {
	    		canvasDrawer.drawLine(1, 2, 26, 2);
	    		fail();
			} catch (Exception e) {
				assertTrue(e.getMessage().contains("must less than 20"));
			}
	    	
	    	
	    	try {
	    		canvasDrawer.drawLine(1, 0, 6, 2);
	    		fail();
			} catch (Exception e) {
				assertTrue(e.getMessage().contains("must more than 0"));
			}
	    	
	    	try {
	    		canvasDrawer.drawLine(1, 2, 6, 5);
	    		fail();
			} catch (Exception e) {
				assertTrue(e.getMessage().contains("must less than 4"));
			}
	    	

		}
	    
	    @Test
		public void testDrawLine_OnlyHorizontalOrVertical() throws Exception {
	    	
	    	CanvasDrawer canvasDrawer =  new CanvasDrawer(20,4);
	    	try {
	    		canvasDrawer.drawLine(1, 2, 6, 3);
	    		fail();
			} catch (Exception e) {
				assertTrue(e.getMessage().contains("only horizontal or vertical line"));
			}

		}
	    //enter command: L 6 3 6 4
	    
	    @Test
		public void testDrawLine_6_3_6_4() throws Exception {
	    	
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
	        
	        canvasDrawer =  new CanvasDrawer(20,4);
	        canvasDrawer.drawLine(6, 4, 6, 3);
	        assertEquals(expectedSB.toString(),canvasDrawer.getDrawing().toString());

		}
	    
	    //R 14 1 18 3
	    
	    @Test
		public void testDrawRectangle_R_14_1_18_3() throws Exception {
	    	
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
		public void testDrawRectangle_R_MustWitinCanvasWidthAndHeight() throws Exception {
	    	
	    	CanvasDrawer canvasDrawer =  new CanvasDrawer(20,4);
	    	  
	    	try {
	    		canvasDrawer.drawRectangle(0, 1, 18, 3);
	    		fail();
			} catch (Exception e) {
				assertTrue(e.getMessage().contains("must more than 0."));
			}
	    	
	    	try {
	    		canvasDrawer.drawRectangle(14, 1, 28, 3);
	    		fail();
			} catch (Exception e) {
				assertTrue(e.getMessage().contains("must less than 20"));
			}
	    	
	    	
	    	try {
	    		canvasDrawer.drawRectangle(14, 1, 18, 0);
	    		fail();
			} catch (Exception e) {
				assertTrue(e.getMessage().contains("must more than 0"));
			}
	    	
	    	try {
	    		canvasDrawer.drawRectangle(14, 8, 18, 3);
	    		fail();
			} catch (Exception e) {
				assertTrue(e.getMessage().contains("must less than 4"));
			}
	    	
	

		}
	    
	    @Test
		public void testDrawRectangle_R_MustBeRectangle() throws Exception {
	    	
	    	CanvasDrawer canvasDrawer =  new CanvasDrawer(20,4);

	    	
	    	try {
	    		canvasDrawer.drawRectangle(14, 1, 14, 3);
	    		fail();
			} catch (Exception e) {
				assertTrue(e.getMessage().contains("only Rectangle"));
			}

		}
	    
	    @Test
		public void testBucketFill_B_10_3_o() throws Exception {
	    	
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
	    
	    @Test
		public void testBucketFill_B_MustWithinCanvasWidthAndHeigh() throws Exception {
	    	
	    	CanvasDrawer canvasDrawer =  new CanvasDrawer(20,4);
	    	try {
	    		canvasDrawer.bucketFill(0, 3, 'o');
	    		fail();
			} catch (Exception e) {
				assertTrue(e.getMessage().contains("must more than 0."));
			}
	    	
	    	try {
	    		canvasDrawer.bucketFill(23, 5, 'o');
	    		fail();
			} catch (Exception e) {
				assertTrue(e.getMessage().contains("must less than 20"));
			}
	    	
	    	
	    	try {
	    		canvasDrawer.bucketFill(10, 0, 'o');
	    		fail();
			} catch (Exception e) {
				assertTrue(e.getMessage().contains("must more than 0"));
			}
	    	
	    	try {
	    		canvasDrawer.bucketFill(10, 5, 'o');
	    		fail();
			} catch (Exception e) {
				assertTrue(e.getMessage().contains("must less than 4"));
			}
	    	
		}
	    
	    @Test
	 		public void testBucketFill_B_CoordinateIsNotAllowToFillColour() throws Exception {
	 	    	
	 	    	CanvasDrawer canvasDrawer =  new CanvasDrawer(20,4);
	 	    	  canvasDrawer.drawLine(1, 2, 6, 2);
	 	    	  canvasDrawer.drawLine(6, 3, 6, 4);
	 	    	try {
	 	    		canvasDrawer.bucketFill(1, 2, 'o');
	 	    		fail();
	 			} catch (Exception e) {
	 				assertTrue(e.getMessage().contains("is not allow to fill Colour"));
	 			}
	 	    	
		    	try {
	 	    		canvasDrawer.bucketFill(2, 2, 'o');
	 	    		fail();
	 			} catch (Exception e) {
	 				assertTrue(e.getMessage().contains("is not allow to fill Colour"));
	 			}
		    	
		    	try {
	 	    		canvasDrawer.bucketFill(6, 4, 'o');
	 	    		fail();
	 			} catch (Exception e) {
	 				assertTrue(e.getMessage().contains("is not allow to fill Colour"));
	 			}
		    	
		    	try {
	 	    		canvasDrawer.bucketFill(6, 3, 'o');
	 	    		fail();
	 			} catch (Exception e) {
	 				assertTrue(e.getMessage().contains("is not allow to fill Colour"));
	 			}
	 	    	
	 		}
	    
	    
	    

}
