import java.util.Scanner;
import java.util.Random;
public class tester {
	 public static void main(String args[]) 
	    { 
		 	Scanner input = new Scanner(System.in);	
		 	int n;
		 	System.out.println("Enter the Number of Stations:");
	    	n = input.nextInt();
	    	
	    	int[][] a = new int[2][n];
		 	int [][]t = new int[2][n-1];
		 	int[] e = new int[2];
		 	int [] x = new int[2];
		 	
		 	Random randomGenerator = new Random();
		    
            for(int i = 0; i < a.length; i++) 
            {
            	System.out.println("Enter the time spent at stations:");
                    for(int j = 0; j < a[i].length; j++) //row
                    {
                    	int randomInt = randomGenerator.nextInt(10);
                    	
                    	a[i][j] = randomInt; //This will read the line of integers and fill all 9 positions in the array.
                    	System.out.println(a[i][j]);
                    }
                    
                    
            } 
                      
            for(int i = 0; i < t.length; i++) 
            {
            	System.out.println("Enter the transaction time:");
                    for(int j = 0; j < t[i].length; j++) //row
                    {
                    	int randomInt = randomGenerator.nextInt(10);
                         t[i][j] = randomInt; //This will read the line of integers and fill all 9 positions in the array.
                         System.out.println(t[i][j]);
                    }
            } 
            
            System.out.println("Enter the entry time:");
            
	    	for(int i = 0; i<e.length; i++){	
	    		int randomInt = randomGenerator.nextInt(10);
	    		e[i] = randomInt;
	    		System.out.println(e[i]);
	    	}
	    	
	    	System.out.println("Enter the exit time:");
	    	
	    	for(int i = 0; i<e.length; i++){
	    		int randomInt = randomGenerator.nextInt(10);
	    		x[i] = randomInt;
	    		System.out.println(x[i]);
	    	}
	    				    			
	    	AssemblyLine tester = new AssemblyLine(a,t,e,x,n);
	    	String k = tester.toString();
	    	System.out.println(" ");
	    	System.out.println("Optimal Path:");
	    	System.out.println(k);
	    	
	    }
	
}
