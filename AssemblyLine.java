import java.util.Random;


public class AssemblyLine
{
    
    private int ns;
    private int[][] f;
    private int fast_way;
    private int[][] l;
    private int line_No;

    
    public AssemblyLine(int[][] a, int[][] t,int[] e, int[] x, int ns)
    {
    	this.ns = ns;

    	f = new int[2][ns];
    	l = new int[2][ns];

    	fastestPath(a, t, e, x, ns);
    }

    
    private void fastestPath(int [][] a, int[][] t, int[] e, int[] x, int n)
    {
    	f[0][0] = e[0] + a[0][0];
    	f[1][0] = e[1] + a[1][0];
	
    	for (int j = 1; j < n; j++) {
    		if (f[0][j-1] + a[0][j] <= f[1][j-1] + t[1][j-1] + a[0][j]) {
    			f[0][j] = f[0][j-1] + a[0][j];
    			l[0][j] = 0;
    		} 
    		else {
    			f[0][j] = f[1][j-1] + t[1][j-1] + a[0][j];
    			l[0][j] = 1;
    		}

		    if (f[1][j-1] + a[1][j] <= f[0][j-1] + t[0][j-1] + a[1][j]) 
		    {
		    	f[1][j] = f[1][j-1] + a[1][j];
		    	l[1][j] = 1;
		    } 
		    else 
		    {
		    	f[1][j] = f[0][j-1] + t[0][j-1] + a[1][j];
		    	l[1][j] = 0;
		    }
		}
		
		if (f[0][n-1] + x[0] <= f[1][n-1] + x[1]) 
		{
		    fast_way = f[0][n-1] + x[0];
		    line_No = 0;
		} 
		else 
		{
			fast_way = f[1][n-1] + x[1];
		    line_No = 1;
		}
		
		
	    }

    public int[] FastestRoute()
    {
		int[] ret = new int[ns];	
		int i = line_No;
		
		ret[ns-1] = i;
	
		for (int j = ns-1; j >= 1; j--) {
		    i = l[i][j];
		    ret[j-1] = i;
		}
	
		return ret;
    }

  
    public String toString()
    {
	    System.out.println("Optimal Time is: "+fast_way);
	    if(line_No == 0){
	    	System.out.println("Optimal line is: 1");
	    }
	    if(line_No == 1){
	    	System.out.println("Optimal line is: 2");
	    }
		//System.out.println("Optimal line is: "+line_No);
		int[] route = FastestRoute();
		String path = "";

		for (int i = 0; i < route.length; i++)
		{
		    path += "Line " + (route[i] + 1) + ", Station " + (i + 1) + "\n";
		}
		return path;
	 }
    
   
}


        
        
