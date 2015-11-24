package cubeSolver;

import java.util.ArrayList;


public class CubeSolver 
{
	
	private EdgeGenerator xEdge;
	private EdgeGenerator yEdge;
	private EdgeGenerator zEdge; 
	private ArrayList<Cube> cubes;	
	private ArrayList<String> yKeys;
	private ArrayList<String> yLocks;
	private ArrayList<String> zKeys;
	private ArrayList<String> zLocks;
	private ArrayList<String> xKeys;
	private ArrayList<String> xLocks;	
	private int size;
	
	public CubeSolver(int s)
	{
		size=s;
		cubes = new ArrayList<Cube>();
		
		xEdge = new EdgeGenerator(size);		
		xEdge.generate();
		xEdge.filter();
		xKeys = xEdge.getKeysList();
		xLocks = xEdge.getlocksList();
		
		yEdge =  new EdgeGenerator(size-2);	
		yEdge.generate();
		yKeys = yEdge.getKeysList();		
		yLocks = yEdge.getlocksList();
		
		zEdge =  new EdgeGenerator(size-2);	
		zEdge.generate();	
		zKeys = zEdge.getKeysList();		
		zLocks = zEdge.getlocksList();
	
	}	
	
	
	public void combinationGenerator()
	{
		int combinations=0;
		
		for(int k=0;k<xEdge.size();++k)
		{
			Cube cube = new Cube(size);
			cubes.add(cube);
			axisAllocator(combinations);
			++combinations;
			xKeys = rotateList(xKeys);
			xLocks = rotateList(xLocks);
			yKeys = rotateList(yKeys);
			yLocks = rotateList(yLocks);
			zKeys = rotateList(zKeys);
			zLocks = rotateList(zLocks);
		}		
					
	}
	
	public void axisAllocator(int position)
	{
		cubes.get(position).assginAxis(xKeys,xLocks,1);
		cubes.get(position).assginAxis(yKeys,yLocks,2);
		cubes.get(position).assginAxis(zKeys,zLocks,3);		
		cubes.get(position).assignFaces();		
	}
	
	
	
	public ArrayList<String> rotateList(ArrayList<String> actualList)
	{		
		actualList.add(actualList.get(0));
		actualList.remove(0);
		return actualList;
	}
	public void displayCubes()
	{
		for(int i=0;i<cubes.size();++i)
		{
			System.out.println("\n\nThe "+ (i+1) +" combination of " + (size) + " edged cube is");
			cubes.get(i).display();
		}
	}

	public static void main(String[] args) 
	{
			
		CubeSolver solver = new CubeSolver(5);
		
		solver.combinationGenerator();
				
		solver.displayCubes();
				
	}
	
}
