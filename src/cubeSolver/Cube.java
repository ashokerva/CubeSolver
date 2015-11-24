package cubeSolver;

import java.util.ArrayList;


public class Cube extends CubeEdges{

	private Face frontFace;
	private Face backFace;
	private Face rightFace;
	private Face leftFace;
	private Face topFace;
	private Face bottomFace;	
	private CubeEdges xAxis;
	private CubeEdges yAxis;
	private CubeEdges zAxis;
	private int size;
	
	public Cube(int s)
	{
		super();
		size=s;
		xAxis = new CubeEdges();
		yAxis = new CubeEdges();
		zAxis = new CubeEdges();
		frontFace = new Face("Front face",size);
		backFace = new Face("Back Face",size);
		rightFace = new Face("Right Face",size);
		leftFace = new Face("Left Face",size);
		topFace = new Face("Top Face",size);
		bottomFace = new Face("Bottom Face",size);	
		
	}
	
	
	public boolean assginAxis(CubeEdges x,CubeEdges y,CubeEdges z)
	{
		xAxis=x;
		yAxis=y;
		zAxis=z;
		assignFaces();
		return true;
	}
	
	public boolean assginAxis(ArrayList<String> k,ArrayList<String> l, int axis)
	{
		switch(axis)
		{
			case 1: xAxis.addEdges(k, l);
					break;
			case 2: yAxis.addEdges(k, l);
					break;
			case 3: zAxis.addEdges(k, l);
					break;
			default: return false;							
		}
		
		return true;
	}
	
	public boolean assginAxis(ArrayList<String> xk,ArrayList<String> xl,ArrayList<String> yk,ArrayList<String> yl,ArrayList<String> zk,ArrayList<String> zl)
	{
		xAxis.addEdges(xk, xl);
		yAxis.addEdges(yk, yl);
		zAxis.addEdges(zk, zl);
		assignFaces();
		return true;
	}
	
	public boolean assignFaces()
	{
		int i=0,j=i+1,k=i+2,l=i+3;
		frontFace.initializeFace(xAxis.getKey(i), xAxis.getLock(j), zAxis.getKey(i), zAxis.getLock(j));
		rightFace.initializeFace(yAxis.getKey(i), yAxis.getLock(j), zAxis.getKey(l), zAxis.getLock(i));
		backFace.initializeFace(xAxis.getKey(k), xAxis.getLock(l), zAxis.getLock(l), zAxis.getKey(k));
		leftFace.initializeFace(yAxis.getKey(l), yAxis.getLock(k), zAxis.getKey(j), zAxis.getLock(k));
		StringBuilder str = new StringBuilder(yAxis.getLock(i));
		StringBuilder str2 = new StringBuilder(yAxis.getLock(l));
		topFace.initializeFace(xAxis.getKey(l), xAxis.getLock(i), str.reverse().toString(),str2.reverse().toString());
		str = new StringBuilder(yAxis.getKey(j));
		str2 = new StringBuilder(yAxis.getKey(k));
		bottomFace.initializeFace(xAxis.getKey(j), xAxis.getLock(k),str.reverse().toString() ,str2.reverse().toString());
		
		return true;
	}
	
	
	public void display()
	{
		
		frontFace.displayMatrix();
		bottomFace.displayMatrix();
		backFace.displayMatrix();
		topFace.displayMatrix();
		rightFace.displayMatrix();
		leftFace.displayMatrix();
		
				
	}
	
	
}
