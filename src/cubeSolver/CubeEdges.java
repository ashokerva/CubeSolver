package cubeSolver;

import java.util.ArrayList;

public class CubeEdges {


	private ArrayList<String> key; 
	private ArrayList<String> lock; 

	public CubeEdges()
	{
		key = new ArrayList<String>();
		lock = new ArrayList<String>();
	}
	public void addEdge(String k,String l)
	{
		key.add(k);
		lock.add(l);
	}
	
	public void addEdges(ArrayList<String> k,ArrayList<String> l)
	{
		key = k;
		lock = l;
	}
	
	public String getKey(int pos)
	{
		return key.get(pos);
	}
	
	public String getLock(int pos)
	{
		return lock.get(pos);
	}
}
