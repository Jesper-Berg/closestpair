package pairFinder;

import java.util.ArrayList;

public class Line {
	private ArrayList<Point> leftHalf = new ArrayList<Point>();
	private ArrayList<Point> rightHalf = new ArrayList<Point>();
	private double x;
	
	public Line(ArrayList<Point> all){
		int half = all.size() / 2;
		all.sort(new XCOMP()); 				//Sorterar efter X-koordinaten
		for(int i = 0; i < half; i++){
			leftHalf.add(all.get(i));
			rightHalf.add(all.get(half + i));
		}
		double leftLastX = leftHalf.get(leftHalf.size() - 1).getX();
		x = (leftLastX - rightHalf.get(rightHalf.size() - 1).getX()) / 2 + leftLastX; //S�tter linjen mellan de tv� n�rmsta punkterna
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
		for(Point p : all){								//Hittar alla punkter length ifr�n linjen
			if(Math.abs(p.getX() - x) <= length ){
				closeBy.add(p);
			}
		}
		closeBy.sort(null);				//Sorterar efter y-koordinaten
		return closeBy;
	}

}
