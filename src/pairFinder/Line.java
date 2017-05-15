package pairFinder;

import java.util.ArrayList;
import java.util.Comparator;

public class Line {
	private ArrayList<Point> leftHalf = new ArrayList<Point>();
	private ArrayList<Point> rightHalf = new ArrayList<Point>();
	private double x;
	
	public Line(ArrayList<Point> all){
		int half = all.size() / 2;
		Comparator<? super Point> xComp = new XCOMP();
		all.sort(xComp);
		for(int i = 0; i < half - 1; i++){
			leftHalf.add(all.get(i));
			rightHalf.add(all.get(half + i));
		}
		double leftLastX = leftHalf.get(leftHalf.size() - 1).getX();
		x = (leftLastX - rightHalf.get(rightHalf.size() - 1).getX()) / 2 + leftLastX; 
	}
	
	public ArrayList<Point> getLeft(){
		return leftHalf;
	}
	
	public ArrayList<Point> getRight(){
		return rightHalf;
	}
	
	public double getPos(){
		return x;
	}
	
	public ArrayList<Point> FindAndSortNearby(double length){
		ArrayList<Point> all = leftHalf;
		all.addAll(rightHalf);
		ArrayList<Point> closeBy = new ArrayList<Point>();	
		for(Point p : all){
			if(Math.abs(p.getX() - x) <= length ){
				closeBy.add(p);
			}
		}
		closeBy.sort(null);
		return closeBy;
	}

}
