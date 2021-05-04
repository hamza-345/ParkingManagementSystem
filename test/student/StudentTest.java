package student;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import graph.*;

public class StudentTest {
 /**
  * TODO: 
  * 	write at least 20 Junit test cases to test your implementation of ListDGraph;
  */
	DGraph<String> graph = new ListDGraph<String>();
    
    @Before
	public void setUp() throws Exception {
	 	graph.addV("1"); 
        graph.addV("2");
        graph.addV("3");
        graph.addV("4");
        graph.addV("5");
        graph.addV("6");
        
        graph.addE(new Edge<String>("1", "2"));
        graph.addE(new Edge<String>("2", "3"));
        graph.addE(new Edge<String>("3", "4"));
        graph.addE(new Edge<String>("4", "5"));
        graph.addE(new Edge<String>("5", "4"));
        graph.addE(new Edge<String>("4", "6"));
	}
    
    @Test
    public void test_getE() { 
		/**
		 * add an exist V
		 */
		Edge<String> e1 = graph.getE(0, 1);
		Edge<String> e2 = new Edge<String>("1", "2");
		Assert.assertEquals(true, e1.equals(e2));
		
     }
    @Test
    public void test_getE2() { 
		/**
		 * Exist doesn't exist
		 */
    	Edge<String> e1 = graph.getE(7, 8);
		Assert.assertEquals(null, e1);
		
     }

	@Test
    public void test_branches() { 
        //Iterate the graph from V "1"
    	ArrayList<ArrayList<String>> bs;
    	bs = graph.branches("1");
    	ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>();
    	ArrayList<String> b1 = new ArrayList<String>();
    	b1.add("1"); b1.add("2"); b1.add("4"); 
    	
    	ArrayList<String> b2 = new ArrayList<String>();
    	b1.add("1"); b1.add("2"); b1.add("3"); 
    	
    	ArrayList<String> b3 = new ArrayList<String>();
    	b1.add("1"); b1.add("3"); 
    	
    	expected.add(b1);
    	expected.add(b2);
    	expected.add(b3);
    	
        Assert.assertNotEquals(bs.size(), expected.size());
     }
	
	@Test
    public void test_branches2() { 
        //Iterate the graph from V "1"
    	ArrayList<ArrayList<String>> bs;
    	bs = graph.branches("1");
    	ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>();
    	ArrayList<String> b1 = new ArrayList<String>();
    	b1.add("1"); b1.add("2"); b1.add("4"); 
    	
    	ArrayList<String> b2 = new ArrayList<String>();
    	b1.add("1"); b1.add("2"); b1.add("3"); 
    	
    	expected.add(b1);
    	expected.add(b2);
    	
        Assert.assertEquals(bs.size(), expected.size());
     }
	
	@Test
	public void test_branches3() { 
        //Iterate the graph from V "1"
    	ArrayList<ArrayList<String>> bs;
    	bs = graph.branches("1");
    	ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>();
    	ArrayList<String> b1 = new ArrayList<String>();
    	b1.add("1"); b1.add("2"); b1.add("3"); b1.add("4");  b1.add("5"); b1.add("4"); b1.add("6");
    	expected.add(b1);
        Assert.assertEquals(bs.get(0).size(), expected.get(0).size());
     }
	
	@Test
	public void test_branches4() { 
        //Iterate the graph from V "1"
    	ArrayList<ArrayList<String>> bs;
    	bs = graph.branches("1");
    	ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>();
    	ArrayList<String> b1 = new ArrayList<String>();
    	b1.add("1"); b1.add("2"); b1.add("3"); b1.add("4"); b1.add("6");
    	expected.add(b1);
        Assert.assertEquals(bs.get(1).size(), expected.get(0).size());
     }
	
	@Test
    public void test_matrix() {
		/**
		 * genearte the matrix
		 */
		int [][] matrix = graph.matrix();
		
		/**
		 * expected matrix `m`
		 */
		 int m [][] = new int[6][6];
    	 m[0][0] =0; m[0][1] =1; m[0][2] =1; m[0][3] =0;  m[0][4] =1; m[0][5] =0;
    	 m[1][0] =0; m[1][1] =0; m[1][2] =1; m[1][3] =1;  m[1][4] =1; m[1][5] =0;
    	 m[2][0] =0; m[2][1] =0; m[2][2] =0; m[2][3] =0;  m[2][4] =1; m[2][5] =0;
    	 m[3][0] =0; m[3][1] =0; m[3][2] =0; m[3][3] =0;  m[3][4] =1; m[3][5] =0;
    	 m[4][0] =0; m[4][1] =1; m[4][2] =1; m[4][3] =0;  m[4][4] =1; m[4][5] =0;
    	 m[5][0] =0; m[5][1] =0; m[5][2] =1; m[5][3] =1;  m[5][4] =1; m[5][5] =0;
        Assert.assertEquals(matrix.length, m.length);
     }
	
	@Test
    public void test_matrix2() {
		/**
		 * genearte the matrix
		 */
		int [][] matrix = graph.matrix();
		
		/**
		 * expected matrix `m`
		 */

		 int m [] = new int[6];
    	 m[0] =0; m[1] =1; m[2] =0; m[3] =0;  m[4] =0; m[5] =0;
        Assert.assertTrue(Arrays.equals(matrix[0], m));
     }

	@Test
	public void test_matrix3() {
		/**
		 * genearte the matrix
		 */
		int [][] matrix = graph.matrix();
		
		/**
		 * expected matrix `m`
		 */
		int m [] = new int[6];
   	 	m[0] =0; m[1] =0; m[2] =1; m[3] =0;  m[4] =0; m[5] =0;
		 Assert.assertTrue(Arrays.equals(matrix[1], m));
     }

	@Test
	public void test_matrix4() {
		/**
		 * genearte the matrix
		 */
		int [][] matrix = graph.matrix();
		
		/**
		 * expected matrix `m`
		 */
		int m [] = new int[6];
   	 	m[0] =0; m[1] =0; m[2] =0; m[3] =1;  m[4] =0; m[5] =0;
    	Assert.assertTrue(Arrays.equals(matrix[2], m));
     }

	@Test
	public void test_matrix5() {
		/**
		 * genearte the matrix
		 */
		int [][] matrix = graph.matrix();
		
		/**
		 * expected matrix `m`
		 */
		int m [] = new int[6];
   	 	m[0] =0; m[1] =0; m[2] =0; m[3] =0;  m[4] =1; m[5] =1;
    	Assert.assertTrue(Arrays.equals(matrix[3], m));
     }
	
	@Test
	public void test_matrix6() {
		/**
		 * genearte the matrix
		 */
		int [][] matrix = graph.matrix();
		
		/**
		 * expected matrix `m`
		 */
		int m [] = new int[6];
   	 	m[0] =0; m[1] =0; m[2] =0; m[3] =1;  m[4] =0; m[5] =0;
    	Assert.assertTrue(Arrays.equals(matrix[4], m));
     }
	
	@Test
	public void test_matrix7() {
		/**
		 * genearte the matrix
		 */
		int [][] matrix = graph.matrix();
		
		/**
		 * expected matrix `m`
		 */
		int m [] = new int[6];
   	 	m[0] =0; m[1] =0; m[2] =0; m[3] =0;  m[4] =0; m[5] =0;
    	Assert.assertTrue(Arrays.equals(matrix[5], m));
     }
	
	@Test
    public void test_addV() { 
		/**
		 * add an exist V
		 */
		int index = graph.addV("1");
		Assert.assertEquals(-1, index);
		
		/**
		 * add a new V
		 */
		index = graph.addV("9");
		Assert.assertEquals(7, index);
     }
    
	@Test
    public void test_addE() { 

		Edge<String> e = new Edge<String>("1", "2");
		/**
		 * add an exist edge
		 */
		boolean success = graph.addE(e);
		Assert.assertEquals(false, success);
     }
	
	@Test
    public void test_addE2() { 
		
		/**
		 * add a new edge
		 */
		Edge<String> e1 = new Edge<String>("1", "4");
		Boolean success = graph.addE(e1);
		Assert.assertEquals(true, success);
     }
	
	@Test
    public void test_removeE() { 
		Edge<String> e1 = new Edge<String>("1", "4");
		graph.addE(e1);
	
		Edge<String> e2 = graph.removeE(new Edge<String>("1", "4"));
		
        Assert.assertEquals(true, e1.equals(e2));
        
     }
	@Test
    public void test_removeE2() { 
		Edge<String> e1 = graph.removeE(new Edge<String>("1", "4"));
        Assert.assertEquals(null, e1 );
     }
	
	@Test
    public void test_removeV() { 
    	String v = graph.removeV("4");
        Assert.assertEquals("4", v);
     }
	@Test
    public void test_removeV2() { 
    	String v = graph.removeV("10");
        Assert.assertEquals(null, v);
     }
}
