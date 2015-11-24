package cubeSolver;

public class Face {

	private String name;
	private char[][] matrix;
	private int size;
	public Face(String str,int s)
	{
		size = s;
		name =str;
		matrix = new char[size][size];		
		
		for(int i=0;i<size;++i)
		{
			for(int j=0;j<size;++j)
			{
				if(((i==0)&&(j==0))||(j==size-1)||(i==size-1))
				{
					matrix[i][j] = ' ';
				}else{
					matrix[i][j] = '0';
				}
			}
		}
	}
	
	public Face(char[][] m)
	{		
		matrix = m;
	}
	
	public boolean initializeFace(String top,String bottom,String right,String left)
	{
		int length = top.length();
		if(length==size)
		{
			for(int k=0;k<size;++k)
			{			
				matrix[0][k] = top.charAt(k);
				matrix[size-1][k] = bottom.charAt(k);
				
			}
		}else
		{
			for(int k=0;k<size-2;++k)
			{			
				matrix[0][k+1] = top.charAt(k);
				matrix[size-1][k+1] = bottom.charAt(k);				
			}
		}		
		for(int k=0;k<size-2;++k)
		{			
			matrix[k+1][size-1] = right.charAt(k);
			matrix[k+1][0] = left.charAt(k);
		}
		
		return true;
	}
	
	public void displayMatrix()
	{
		System.out.println("\n"+name+" :");
		for(int i=0;i<size; ++i)
		{
			System.out.println();			
			for(int j=0;j<size;++j)
			{
				char ch = matrix[i][j];
				if(ch== '1')
				{
					System.out.print(" " + " ");
				}else
				{
					System.out.print(ch+ " ");
				}
				
			}
		}
	}
	
}
