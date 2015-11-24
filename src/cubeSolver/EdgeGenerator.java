package cubeSolver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class EdgeGenerator{

	private Map<String,String> pairSet = new TreeMap<String,String>();
	private int size;
	public EdgeGenerator(int s)
	{
		size =s;
	}
	
	void generate()
	{
		ArrayList<String> possibleSet = new ArrayList<String>();		
		String pad = "0";
		int p =size;
		while(--p>0)
		{
			pad = pad +"0";
		}
		for(int i=1;i<Math.pow(2,size)-1;++i)
		{
			String str = Integer.toBinaryString(i);	
			
			if(str.length()<size)
			{
				str = pad.substring(str.length()) + str;
			}
			possibleSet.add(str);			
		}		
		for(int i=0,j = possibleSet.size()-1;i<possibleSet.size()/2;++i,--j)
		{
			pairSet.put(possibleSet.get(i),possibleSet.get(j));
		}
		pairSet.put(pairSet.get(possibleSet.get(size-2)),possibleSet.get(size-2));
		
	}
	
	public void filter()
	{
		Collection<String> c = pairSet.keySet();		
		Iterator<String> itr = c.iterator();	
		
		while(itr.hasNext())
		{
			String key = (String) itr.next();
			String value = pairSet.get(key.toString());
			if(key.startsWith("10")||(value.startsWith("10")))
			{
				itr.remove();
				pairSet.remove(key);				
			}else if(key.substring(key.length()-2).startsWith("01")||(value.substring(value.length()-2).equals("01")))
			{
				itr.remove();
				pairSet.remove(key);				
			}			
		}
		
	}
	
	public Map<String,String> getPairs()
	{
		return pairSet;
	}
	
	public ArrayList<String> getKeysList()
	{
		ArrayList<String> keys = new ArrayList<String>();
		Set<String> keySet = pairSet.keySet();		
		for(String key:keySet)
		{
			keys.add(key);
		}
		
		return keys;
	}
	
	public ArrayList<String> getlocksList()
	{
		ArrayList<String> locks = new ArrayList<String>();
		Collection<String> c = pairSet.values();		
		Iterator<String> itr = c.iterator();	
		
		while(itr.hasNext())
		{
			locks.add(itr.next());
		}
		
		return locks;
	}
	
	public int size()
	{
		return pairSet.size();
	}
	
	public void display()
	{
		Set<String> keySet = pairSet.keySet();
		for(String key:keySet)
		{
			System.out.println("Lock value for " + key +" = "  + pairSet.get(key));
		}
	}	

}

