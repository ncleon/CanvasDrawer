package com.leo.canvas;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.system.OutputCaptureRule;

public class SimpleConsoleDrawTest {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
    // Rule will run before every test case
    @Rule
    public OutputCaptureRule outputCapture = new OutputCaptureRule(); 
	
	
    @Test
    public void simpleTestForOutputCapture() {

        System.out.println("Hello World");
        System.out.println("Welcome");
        
        
        StringBuffer expectedSB = new StringBuffer();
        expectedSB.append("Hello World"+LINE_SEPARATOR);
        expectedSB.append("Welcome"+LINE_SEPARATOR);
        		
        assertEquals(expectedSB.toString(), outputCapture.toString());
    }
    
    @Test
	public void testCanvasC_20_4() throws Exception {
    	
        StringBuffer expectedSB = new StringBuffer();
        expectedSB.append("----------------------"+LINE_SEPARATOR);
        expectedSB.append("|                    |"+LINE_SEPARATOR);
        expectedSB.append("|                    |"+LINE_SEPARATOR);
        expectedSB.append("|                    |"+LINE_SEPARATOR);
        expectedSB.append("|                    |"+LINE_SEPARATOR);
        expectedSB.append("----------------------"+LINE_SEPARATOR);
        
        SimpleConsoleDrawer.enterCommand("C 20 4");
        SimpleConsoleDrawer.draw();
        assertEquals(expectedSB.toString(), outputCapture.toString());

        
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
        
        SimpleConsoleDrawer.enterCommand("C 20 4");
        SimpleConsoleDrawer.enterCommand("L 1 2 6 2");
        SimpleConsoleDrawer.draw();
        assertEquals(expectedSB.toString(), outputCapture.toString());

	}
    //enter command: L 6 3 6 4
    
    @Test
	public void testCanvasL_6_3_6_4() throws Exception {
    	
        StringBuffer expectedSB = new StringBuffer();
        expectedSB.append("----------------------"+LINE_SEPARATOR);
        expectedSB.append("|                    |"+LINE_SEPARATOR);
        expectedSB.append("|xxxxxx              |"+LINE_SEPARATOR);
        expectedSB.append("|     x              |"+LINE_SEPARATOR);
        expectedSB.append("|     x              |"+LINE_SEPARATOR);
        expectedSB.append("----------------------"+LINE_SEPARATOR);
        
        SimpleConsoleDrawer.enterCommand("C 20 4");
        SimpleConsoleDrawer.enterCommand("L 1 2 6 2");
        SimpleConsoleDrawer.enterCommand("L 6 3 6 4");
        SimpleConsoleDrawer.draw();
        assertEquals(expectedSB.toString(), outputCapture.toString());

	}
    
    //R 14 1 18 3
    
    @Test
	public void testCanvasR_14_1_18_3() throws Exception {
    	
        StringBuffer expectedSB = new StringBuffer();
        expectedSB.append("----------------------"+LINE_SEPARATOR);
        expectedSB.append("|             xxxxx  |"+LINE_SEPARATOR);
        expectedSB.append("|xxxxxx       x   x  |"+LINE_SEPARATOR);
        expectedSB.append("|     x       xxxxx  |"+LINE_SEPARATOR);
        expectedSB.append("|     x              |"+LINE_SEPARATOR);
        expectedSB.append("----------------------"+LINE_SEPARATOR);
        

        SimpleConsoleDrawer.enterCommand("C 20 4");
        SimpleConsoleDrawer.enterCommand("L 1 2 6 2");
        SimpleConsoleDrawer.enterCommand("L 6 3 6 4");
        SimpleConsoleDrawer.enterCommand("R 14 1 18 3");
        SimpleConsoleDrawer.draw();
        assertEquals(expectedSB.toString(), outputCapture.toString());

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
        

        SimpleConsoleDrawer.enterCommand("C 20 4");
        SimpleConsoleDrawer.enterCommand("L 1 2 6 2");
        SimpleConsoleDrawer.enterCommand("L 6 3 6 4");
        SimpleConsoleDrawer.enterCommand("R 14 1 18 3");
        SimpleConsoleDrawer.enterCommand("B 10 3 o");
        SimpleConsoleDrawer.draw();
        assertEquals(expectedSB.toString(), outputCapture.toString());

	}
    
    

    
}
