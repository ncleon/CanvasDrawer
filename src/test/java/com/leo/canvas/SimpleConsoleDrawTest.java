package com.leo.canvas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
	public void testCommandC_20_4() throws Exception {
    	
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
	public void testCommandC_MustBeIncludeX_Y() throws Exception {
    	        
       	try 
    	{
		  SimpleConsoleDrawer.enterCommand("C 20");
	      fail();
		} catch (Exception e) {
			
			assertTrue(e.getMessage().contains("only allow 2 input integer Values."));
		}
       	
       	try 
    	{
		  SimpleConsoleDrawer.enterCommand("C 20 A");
	      fail();
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("must be integer."));
		}

        
	}
    
    @Test
	public void testCommandL_R_B_onlyAllowAfterCommandC() throws Exception {
    	
    	try 
    	{
	      SimpleConsoleDrawer.enterCommand("L 1 2 6 2");
	      fail();
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("Canvas no found"));
		}
    	
    	try 
    	{
            SimpleConsoleDrawer.enterCommand("R 14 1 18 3");
	      fail();
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("Canvas no found"));
		}
    	
    	try 
    	{
    		SimpleConsoleDrawer.enterCommand("B 10 3 o");
	      fail();
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("Canvas no found"));
		}

	}
    
    
    @Test
	public void testCommandL_1_2_6_2() throws Exception {
    	
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
	public void testCommandL_6_3_6_4() throws Exception {
    	
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
    
    @Test
 	public void testCommandL_MustIncluded_X1_X2_Y1_Y2_Only() throws Exception {
    	try 
    	{
		  SimpleConsoleDrawer.enterCommand("C 20 4");
	      SimpleConsoleDrawer.enterCommand("L 1 2 6");
	      fail();
		} catch (Exception e) {
			
			assertTrue(e.getMessage().contains("Draw Line Command, only allow 4 input integer Values."));
		}
    	
    	try 
    	{
		  SimpleConsoleDrawer.enterCommand("C 20 4");
	      SimpleConsoleDrawer.enterCommand("L 1 2 6 A");
	      fail();
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("must be integer."));
		}
    	
    	try 
    	{
		  SimpleConsoleDrawer.enterCommand("C 20 4");
	      SimpleConsoleDrawer.enterCommand("L 1 0 6 2");
	      fail();
		} catch (Exception e) {
			
			assertTrue(e.getMessage().contains("must more than 0"));
		}
    }
    
    //R 14 1 18 3
    
    @Test
	public void testCommandR_14_1_18_3() throws Exception {
    	
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
 	public void testCommandR_MustIncluded_X1_X2_Y1_Y2_Only() throws Exception {
    	try 
    	{
		  SimpleConsoleDrawer.enterCommand("C 20 4");
	      SimpleConsoleDrawer.enterCommand("R 14 1 18");
	      fail();
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("Draw Rectangle Command, only allow 4 input integer Values. Example R 14 1 18 3"));
		}
    	
    	try 
    	{
		  SimpleConsoleDrawer.enterCommand("C 20 4");
	      SimpleConsoleDrawer.enterCommand("R 14 1 18 A");
	      fail();
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("must be integer."));
		}
    	
    	try 
    	{
		  SimpleConsoleDrawer.enterCommand("C 20 4");
	      SimpleConsoleDrawer.enterCommand("R 14 0 18 3");
	      fail();
		} catch (Exception e) {
			
			assertTrue(e.getMessage().contains("must more than 0"));
		}
    }
    
    @Test
	public void testCommandB_10_3_o() throws Exception {
    	
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
    
    @Test
	public void testCommandB_MustBeIncludeX_Y_ColourCode() throws Exception {
    	
    	
    	try 
    	{
		  SimpleConsoleDrawer.enterCommand("C 20 4");
	      SimpleConsoleDrawer.enterCommand("B A 4 o");
	      fail();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue(e.getMessage().contains("only allow (x, y) with colour c. x and y must be interger , c is single character, example: B 1 1 c"));
		}
        
    	try 
    	{
		  SimpleConsoleDrawer.enterCommand("C 20 4");
	      SimpleConsoleDrawer.enterCommand("B 2 B oo");
	      fail();
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("only allow (x, y) with colour c. x and y must be interger , c is single character, example: B 1 1 c"));
		}

    	try 
    	{
		  SimpleConsoleDrawer.enterCommand("C 20 4");
	      SimpleConsoleDrawer.enterCommand("B 2 4");
	      fail();
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("Bucket fill Command, only allow 3 input Values"));
		}
    	
    	
 

	}
    
    

    
}
